package com.alexaleluia12.basic
/*
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
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
    test(notBad("This movie is not so bad"), "This movie is good")
    test(notBad("This dinner is not that bad!"), "This dinner is good!")
    test(notBad("This tea is not hot"), "This tea is not hot")
    test(notBad("It's bad yet not"), "It's bad yet not")

    println()
    println("front_back")
    test(frontBack("abcd", "xy"), "abxcdy")
    test(frontBack("abcde", "xyz"), "abcxydez")
    test(frontBack("Kitten", "Donut"), "KitDontenut")
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

/*
E. not bad
Dada uma string, encontre a primeira ocorrência das
sub-strings "not" e "bad". Se "bad" vier depois de "not",
substitua toda a sub-string "not"..."bad" por "good".
Retorne a string resultade. Então 'This dinner is not that bad!'
gera This dinner is good!
*/

fun notBad(s: String): String {
    val positionNot = s.indexOf("not")
    val positionBad = s.indexOf("bad")

    return if (positionNot < positionBad)
        s.slice(0..<positionNot) + "good" + s.slice(positionBad + 3..<s.length)
    else
        s
}


/*
F. front_back
Considere dividir uma string em duas metades.
Se o comprimento for par, as metades frontal e traseira terão o mesmo comprimento.
Se o comprimento for ímpar, diremos que o caractere extra vai para a metade frontal.
Por exemplo, em 'abcde', a metade frontal é 'abc' e a metade traseira é 'de'.
Dadas duas strings, a e b, retorne uma string no formato:
a-front + b-front + a-back + b-back
*/
fun frontBack(s: String, v: String): String {
    var middleFirst: Int = s.length / 2
    if (s.length % 2 != 0) {
        middleFirst += 1
    }
    var middleSecond: Int = v.length / 2
    if (v.length % 2 != 0) {
        middleSecond += 1
    }

    val frontFirst = s.slice( 0 ..< middleFirst)
    val backFirst = s.slice(middleFirst ..< s.length)

    val frontSecond = v.slice(0 ..< middleSecond)
    val backSecond = v.slice(middleSecond ..< v.length)

    return "$frontFirst$frontSecond$backFirst$backSecond"
}

