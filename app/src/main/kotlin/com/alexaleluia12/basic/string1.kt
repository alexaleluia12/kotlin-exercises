package com.alexaleluia12.basic
/*
#!/usr/bin/python3
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
# http://code.google.com/edu/languages/google-python-class/

# Copyright 2023 Alex Aleluia
# Licença MIT
*/

/*
A. Dado um número inteiro de rosquinhas, retorne uma string
no formato 'Number of donuts: <contagem>', onde <contagem> é o número
passado. No entanto, se a contagem for 10 ou mais, use a palavra 'many'
em vez da contagem real.
Então donuts(5) retorna 'Number of donuts: 5'
e donuts(23) retorna 'Number of donuts: many'
*/
fun donuts(n: Int): String {
    val count = if (n >= 10) "many" else n.toString()
    return "Number of donuts: $count"
}

/*
B. both_ends
Dado uma string s, retorne uma string feita dos primeiros 2
e os últimos 2 caracteres da string original,
então 'spring' retorna 'spng'. No entanto, se o comprimento da string
for menor que 2, retorne a string vazia.
*/
fun bothEnds(s: String): String {
    return if (s.length < 2) {
        ""
    } else {
        s.slice(0..< 2) + s.slice(s.length-2..< s.length)
    }
}

fun fix_start(s: String): String {
    return ""
}

fun mix_up(s: String, v: String): String {
    return ""
}

private fun test(got: String, expected: String) {
    val prefix = if (got == expected) " OK " else "  X "
    println("${prefix} got: ${got.toString()} expected: ${expected.toString()}")
}

fun main() {
    println("donuts")
    // Each line calls donuts, compares its result to the expected for that call.
    test(donuts(4), "Number of donuts: 4")
    test(donuts(9), "Number of donuts: 9")
    test(donuts(10), "Number of donuts: many")
    test(donuts(99), "Number of donuts: many")

    println()
    println("both_ends")
    test(bothEnds("spring"), "spng")
    test(bothEnds("Hello"), "Helo")
    test(bothEnds("a"), "")
    test(bothEnds("xyz"), "xyyz")


    println()
    println("fix_start")
    test(fix_start("babble"), "ba**le")
    test(fix_start("aardvark"), "a*rdv*rk")
    test(fix_start("google"), "goo*le")
    test(fix_start("donut"), "donut")

    println()
    println("mix_up")
    test(mix_up("mix", "pod"), "pox mid")
    test(mix_up("dog", "dinner"), "dig donner")
    test(mix_up("gnash", "sport"), "spash gnort")
    test(mix_up("pezzy", "firm"), "fizzy perm")
}