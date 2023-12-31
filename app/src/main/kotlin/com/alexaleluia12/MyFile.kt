package com.alexaleluia12

import java.io.File

class file {
    companion object {
        fun read() {
            val path = "app/src/main/resources/small.txt"
            File(path).useLines { lines ->
                lines.forEach { line -> // linhas vem sem \n
                    println(line)
                }
            }
        }

        fun write() {
            val path = "app/src/main/resources/ktWrite.txt"
            // fecha arquivo automaticamente
            File(path).outputStream().bufferedWriter(Charsets.UTF_8).use { writer ->
                writer.write("\u20ACunicode\u20AC")
                writer.newLine()  // Manually add newline
            }

        }
    }
}