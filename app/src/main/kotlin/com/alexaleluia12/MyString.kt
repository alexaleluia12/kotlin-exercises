package com.alexaleluia12

class str {
    companion object {
        fun doWork() {
            // referencia: https://developers.google.com/edu/python/strings?hl=en
            val name: String = "One day I will be a awesome"
            val resume = """ // this is an raw string in kotlin
                String methods
                name.uppercase(), name.lowercase()
                name.trim() : remove espaco em branco no inicio e fim
                name.isBlank() // "" or "     "
                name.isEmpty() // ""
                name.startsWith("n")
                name.endsWith("e")
                name.contains(substring) : encontra substrig (Boolean)
                name.indexOf(substring) : encontra substrig (Int)
                name.replace(old, new)
                name.split(str)
                join : eh um methodo de list e não de string
                    name.split(" ").joinToString("-")
                slice : pega ultima palavra de tamanho 7, usa range operator
                    name.slice(name.length - 7 .. name.length - 1)
            """.trimIndent()
            println(name.contains("one", true))
            var r = name.indexOf("day")
            println(r)
            val name2 = name.replace("will", "definitely")
            println("$name \n $name2")
            var k = name.split(" ")
            println(k.joinToString("-"))
            println(name.slice(name.length - 7..name.length - 1))
            println(name.last())
            val lnum = 2.791514f
            println(String.format("eu sou um quadrado=%.2f numero %s endereco ", lnum, "Pedra brancha, 79"))

            val name3 = "alex"
            println("${name3.padEnd(10, ' ')}*") // alex      *

        }
    }
}

