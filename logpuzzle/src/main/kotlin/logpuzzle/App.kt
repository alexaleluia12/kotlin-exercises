import java.io.File

/*
Exercicio Logpuzzle

Dado um arquivo de log do apache, encontre as urls puzzle e faça o download das images.
URI do host: code.google.com

Como é uma linha que tem uma url puzzle:
10.254.254.28 - - [06/Aug/2007:00:13:48 -0700] "GET /~foo/puzzle-bar-aaab.jpg HTTP/1.0" 302 528 "-" "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.6) Gecko/20070725 Firefox/2.0.0.6"
*/

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



/**
Dada as urls já na ordem correta, faça o download de cada imagen
no diretorio dado.
Troque o nome da imagens local para algo tipo: img0, img1, assim por diante.
Crei um arquivo index.html no diretorio com uma tag img que mostra cada imagen local
Crie o diretorio se necessario
 */
fun downloadImages(imgUrls: String, destDir: String) {
    // seu codigo
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

    $ ./logpuzzle --todir animaldir animal_code.google.com
    $ ls animaldir
    img0  img1  img2  img3  img4  img5  img6  img7  img8  img9  index.html

C. codígo deve funcionar tmb para place_code
 */

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("usage: ./logpuzzle file")
        return
    }

    val filename = args[0]
    readUrls(filename).forEach(::println)
}