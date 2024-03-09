package com.alexaleluia12.babynames

import java.io.File
import java.lang.Integer.min

/*
Baby Names exercício

Define a função extractName() abaixo e mude main() para chamar ela.
Para escrever regex, é bom incluir uma cópia do texto alvo como guia
Como o html do aquivo baby.html se parece :
...
<h3 align="center">Popularity in 1990</h3>
....
<tr align="right"><td>1</td><td>Michael</td><td>Jessica</td>
<tr align="right"><td>2</td><td>Christopher</td><td>Ashley</td>
<tr align="right"><td>3</td><td>Matthew</td><td>Brittany</td>
...
Milestone sugeridas para desenvolvimento incremental:
 -Extrair cada ano e printar (mostrar na tela) ele
 -Extrair os names e ranks e apenas printar eles
 -Organizar os nomes em uma estrutura de dados List/Map
 -Construir a lista [ano, 'nome rank', ...] e printar ela
 -Arrumar o main() para usar a lista de extractName
*/


fun extractYear(filename: String): Int {
    val posHtml = filename.indexOf(".html")
    val baby = "baby"
    val posBaby = filename.lastIndexOf(baby)

    return filename.slice(posBaby+baby.length until  posHtml).toInt()
}

/**
 * Dada uma nome de aquivo baby.html retorne uma lista com
 * o primeiro elemento o ano do arquivo e os proximo os nomes e ranks
 * em ordem crescente pelo nome.
 * ['2006', 'Aaliyah 91', Aaron 57', 'Abagail 895', ' ...]
 */
fun extractName(filename: String, resume: Boolean = false): List<String> {
    val year = extractYear(filename)

    // <tr align="right"><td>1</td><td>Michael</td><td>Jessica</td>
    val rawPatter = """<td>(\d+)</td><td>([\w\s]+)</td><td>([\w\s]+)</td>"""
    val regex = Regex(rawPatter)
    val names = mutableMapOf<String, Int>()
    File(filename).forEachLine { line ->
        val patterns = regex.find(line)
        patterns?.let {
            val (position, maleName, femaleName) = it.groupValues.slice(1 until 4)
            names[maleName] = min(position.toInt(), names.getOrDefault(femaleName, Int.MAX_VALUE))
            names[femaleName] = min(position.toInt(), names.getOrDefault(maleName, Int.MAX_VALUE))
        }
    }

    return listOf(year.toString()) + names.entries
        .sortedBy { it.key }.map { "${it.key} ${it.value}" }

}


fun createResumeFile(filename: String, names: List<String>) {
    // foo.html -> foo.html.summary
    val newName = "$filename.summary"
    File(newName).writeText(names.joinToString("\n"))
}

fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("usage: [--summaryfile] file [file ...]")
        return
    }
    val filesName: List<String>
    val matchedFiles = mutableListOf<String>()

    var summary = false
    if (args.first() == "--summaryfile") {
        summary = true
        filesName = args.slice( 1 .. args.lastIndex)
    } else {
        filesName = args.toList()
    }

    val first = filesName.first()
    if (first.contains("*")) {
        val starFile = File(first)
        val starPath = File(starFile.parent ?: ".")

        val patterLast = starFile.name
        val regexPatterLast = Regex(patterLast.replace("*", ".*") + "\$")

        starPath.listFiles()?.let { workingFiles ->
            for (f in workingFiles) {
                if (regexPatterLast.containsMatchIn(f.path)) {
                    matchedFiles.add(f.path)
                }
            }
        }
    }
    val filesToProcess = if (matchedFiles.size > 0) matchedFiles else filesName
    for (f in filesToProcess) {
        val lst = extractName(f)
        if (summary) {
            createResumeFile(f, lst)
        } else {
            println(lst.joinToString("\n"))
        }
    }
}
