package com.alexaleluia12.basic
/*
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google"s Python Class
# http://code.google.com/edu/languages/google-python-class/

# Copyright 2023 Alex Aleluia
# Licença MIT
*/

private fun test(got: String, expected: String) {
    val prefix = if (got == expected) " OK " else "  X "
    println("${prefix} got: ${got.toString()} expected: ${expected.toString()}")
}


fun main() {
    println("verbing")
    test(verbing("hail"), "hailing")
    test(verbing("swiming"), "swimingly")
    test(verbing("do"), "do")

    println()
    println("not_bad")
    test(not_bad("This movie is not so bad"), "This movie is good")
    test(not_bad("This dinner is not that bad!"), "This dinner is good!")
    test(not_bad("This tea is not hot"), "This tea is not hot")
    test(not_bad("It\"s bad yet not"), "It\"s bad yet not")

    println()
    println("front_back")
    test(front_back("abcd", "xy"), "abxcdy")
    test(front_back("abcde", "xyz"), "abcxydez")
    test(front_back("Kitten", "Donut"), "KitDontenut")
}

/*
D. verbing
Dada uma string, se seu comprimento for pelo menos 3,
adicione o sufixo 'ing' ao seu final.
A menos que a string já termine em 'ing', nesse caso
adicione o sufixo 'ly' em vez disso.
Se o comprimento da string for menor que 3, deixe-a inalterada.
Retorne a string resultante.
*/
fun verbing(s: String): String {

    return when {
        s.endsWith("ing") -> s + "ly"
        s.length >= 3 -> s + "ing"
        else -> s
    }
}


fun not_bad(s: String): String {
    return ""
}

fun front_back(s: String, s1: String): String {
    return ""
}
