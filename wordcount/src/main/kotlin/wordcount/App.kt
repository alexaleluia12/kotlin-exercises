import java.io.File

/*
Mostra lista da frequência das palavras no arquivo, orden crescente
considere todas em minusculo: The e the são a mesma palavra
(--count)
word1 count1
word2 count2
...

(--topcount) apenas as 20 mais comuns, ordem descendente
 */
fun main(args: Array<String>) {
    if (args.size != 2) {
        println("usage: ./wordcount {--count | --topcount} file")
        return
    }

    val option = args[0]
    val filename = args[1]

    when (option) {
        "--count" -> printWords(filename)
        "--topcount" -> printTop(filename)
        else -> {
            println("unknown option: $option")
            return
        }
    }
}

fun printWords(fileName: String) {
    val wordFrequency = wordFrequencyFrom(fileName)

    val orderedByValue = wordFrequency.entries.sortedBy { it.value }
    for ((k, v) in orderedByValue) {
        println("$k $v")
    }

}

fun printTop(fileName: String) {
    val wc = wordFrequencyFrom(fileName)

    val orderedDesByValue = wc.entries.sortedByDescending { it.value }
    var e: MutableMap.MutableEntry<String, Int>
    for (i in 0 until 20) {
        e = orderedDesByValue[i]
        println("${e.key} ${e.value}")
    }
}

fun wordFrequencyFrom(fileName: String): MutableMap<String, Int> {
    val wordAccount = mutableMapOf<String, Int>()

    File(fileName).useLines {lines->
        lines.forEach { line ->
            line
                .lowercase()
                .split(" ")
                .forEach {word ->
                    if (word.isNotEmpty())
                        wordAccount[word] = wordAccount.getOrElse(word) { 0 } + 1
                }
        }
    }

    return wordAccount
}