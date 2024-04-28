import java.io.File
import java.io.IOException
import java.io.InputStream
import java.lang.StringBuilder
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.name
import kotlin.io.path.notExists
import kotlin.system.exitProcess

/*
Exercicio Logpuzzle

Dado um arquivo de log do apache, encontre as urls puzzle e faça o download das images.
URI do host: code.google.com

Como é uma linha que tem uma url puzzle:
10.254.254.28 - - [06/Aug/2007:00:13:48 -0700] "GET /~foo/puzzle-bar-aaab.jpg HTTP/1.0" 302 528 "-" "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.6) Gecko/20070725 Firefox/2.0.0.6"
*/

const val HOST = "https://code.google.com"
//https://code.google.com/edu/languages/google-python-class/images/puzzle/a-babh.jpg

/**
Esta função retorna uma lista de URLs de puzzle do arquivo de log fornecido.
Filtra URLs duplicadas e retorna as URLs classificadas em ordem crescente.
 */
fun readUrls(filename: String): List<String> {
    val selectedUris = mutableListOf<String>()
    val f = File(filename)
    val regexPuzzle = Regex("""/puzzle/""")
    val regexPuzzleUri = Regex("""GET\s([\w-/.~]+)\s""")

    f.forEachLine { line ->
        if (regexPuzzle.containsMatchIn(line)) {
            val m = regexPuzzleUri.find(line)
            m?.let {
                selectedUris.add(m.groupValues[1])
            }
        }
    }

    return selectedUris.sorted().toSet().toList()
}

// Extra functions to complement functionalities
fun dirNameFrom(fileName: String): String {
    val dotPos = fileName.indexOf('.')
    return fileName.slice(0 until dotPos)
}

fun newImg(name: String) =  """<img src="$name">"""


/**
Dada as urls já na ordem correta, faça o download de cada imagen
no diretorio dado.
Troque o nome da imagens local para algo tipo: img0, img1, assim por diante.
Crei um arquivo index.html no diretorio com uma tag img para cada imagen local
Crie o diretorio se necessario
 */
fun downloadImages(imgUrls: List<String>, destDir: String) {
    val baseName = "img"
    var count = 0
    val html = StringBuilder("""
        <html>
        <body>
    """.trimIndent())

    for (imgUri in imgUrls) {
        val img = fetch(imgUri)
        img?.let {
            val fileName = "$baseName$count"
            store(it, destDir, fileName)
            html.append(newImg(Path(destDir, fileName).name))
        }
        count++
    }
    html.append("""
        </body>
        </html>
    """.trimIndent())

    val outHtml = File(destDir, "index.html")
    outHtml.outputStream().bufferedWriter(Charsets.UTF_8).use { writer ->
        writer.write(html.toString())
    }
}

fun fetch(imgUri: String): InputStream? {
    var result: InputStream? = null
    try {
        val client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(imgUri))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofInputStream())
        check(response.statusCode() in 200..299)
        result = response.body()
    } catch (e: IOException) {
        System.err.println("Error ${e.javaClass}: fail to get $imgUri")
    }

    return result
}

fun store(data: InputStream, directory: String, imgName: String) {
    Path(directory, imgName)
        .toFile()
        .outputStream().use { writer ->
            data.copyTo(writer)
        }
}

/*
Milestones
A. download das imagens
    - ler e extrair a path de url que tem *puzzle*
    - download

    $ ./logpuzzle animal_code.google.com
    http://code.google.com/something/puzzle-animal-baaa.jpg
    http://code.google.com/something/puzzle-animal-baab.jpg

B. index.html
    - reanomear os arquivos seguindo o padrão img{num}
    - criar aquivo html com os novos nomes no diretorio passado

    index.html
        <html>
        <body>
        <img src="img0"><img src="img1"><img src="img2">...
        </body>
        </html>

    $ ./logpuzzle --todir animaldir animal_code.google.com
    $ ls animaldir
    img0  img1  img2  img3  img4  img5  img6  img7  img8  img9  index.html

C. codígo deve funcionar tmb para place_code
 */

fun main(args: Array<String>) {
    val usage = "usage: ./logpuzzle [--todir dir] file"
    fun exit() {
        println(usage)
        exitProcess(-1)
    }

    if (args.isEmpty()) {
        exit()
    }

    val filename: String
    val destDir: String
    when (args.size) {
        1 -> {
            filename = args[0]
            destDir = dirNameFrom(filename)
        }
        3 -> {
            if (args[0] != "--todir") {
                exit()
            }
            filename = args[2]
            destDir = args[1]
        }
        else -> {
            exit()
            return
        }
    }

    val urls = readUrls(filename).map { HOST + it}
    val path = Path(destDir)
    if (path.notExists()) {
        path.createDirectories()
    }
    downloadImages(urls, destDir)
}