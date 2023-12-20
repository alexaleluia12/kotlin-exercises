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
A. donuts
Dado um número inteiro de rosquinhas, retorne uma string
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
B. bothEnds
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

/*
C. fixStart
Dada uma string s, retorne uma string
onde todas as ocorrências de seu primeiro caractere foram
alteradas para '*', exceto o primeiro caractere em si.
exemplo 'babble' retorna 'ba**le'
Assuma que a string tem comprimento 1 ou mais.
Dica: usar replace
*/
fun fixStart(s: String): String {
    assert(s.length >= 1)
    val firstCha = s[0]
    return firstCha + s.slice(1 ..< s.length).replace(firstCha, '*')
}


/*
D. MixUp
Dadas as strings a e b, retorne uma única string com a e b separadas
por um espaço '<a> <b>', mas troque os dois primeiros caracteres de cada string.
Exemplo:
'mix', 'pod' -> 'pox mid'
'dog', 'dinner' -> 'dig donner'
Assuma que a e b têm comprimento 2 ou mais.
*/
fun mixUp(s: String, v: String): String {
    val firstPair = s.slice(0 ..< 2)
    val secondPair = v.slice(0 ..< 2)

    return "$secondPair${s.slice(2..< s.length)} $firstPair${v.slice(2 ..< v.length)}"
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
    test(fixStart("babble"), "ba**le")
    test(fixStart("aardvark"), "a*rdv*rk")
    test(fixStart("google"), "goo*le")
    test(fixStart("donut"), "donut")

    println()
    println("mix_up")
    test(mixUp("mix", "pod"), "pox mid")
    test(mixUp("dog", "dinner"), "dig donner")
    test(mixUp("gnash", "sport"), "spash gnort")
    test(mixUp("pezzy", "firm"), "fizzy perm")
}