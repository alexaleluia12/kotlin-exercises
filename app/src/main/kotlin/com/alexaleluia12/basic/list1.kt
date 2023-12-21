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

private fun test(got: Any, expected: Any) {
    val prefix = if (got == expected) " OK " else "  X "
    println("${prefix} got: ${got.toString()} expected: ${expected.toString()}")
}

fun main() {
    println("match_ends")
    test(matchEnds(listOf("aba", "xyz", "aa", "x", "bbb")), 3)
    test(matchEnds(listOf("", "x", "xy", "xyx", "xx")), 2)
    test(matchEnds(listOf("aaa", "be", "abc", "hello")), 1)

    /*
    println()
    print("front_x")
    test(front_x(["bbb", "ccc", "axx", "xzz", "xaa"]),
        ["xaa", "xzz", "axx", "bbb", "ccc"])
    test(front_x(["ccc", "bbb", "aaa", "xcc", "xaa"]),
        ["xaa", "xcc", "aaa", "bbb", "ccc"])
    test(front_x(["mix", "xyz", "apple", "xanadu", "aardvark"]),
        ["xanadu", "xyz", "aardvark", "apple", "mix"])


    println()
    print("sort_last")
    test(sort_last([(1, 3), (3, 2), (2, 1)]),
    [(2, 1), (3, 2), (1, 3)])
    test(sort_last([(2, 3), (1, 2), (3, 1)]),
    [(3, 1), (1, 2), (2, 3)])
    test(sort_last([(1, 7), (1, 3), (3, 4, 5), (2, 2)]),
    [(2, 2), (1, 3), (3, 4, 5), (1, 7)])

     */
}

/*
A. match_ends
Dada uma lista de strings, retorne a contagem do número
de strings com comprimento de 2 ou mais caracteres e
cujos primeiros e últimos caracteres sejam iguais.
*/
fun matchEnds(lst: List<String>): Int {
    var count: Int = 0
    for (s in lst) {
        if (s.isNotEmpty() && s.length >= 2 &&  s[0] == s[s.length-1]) {
            count += 1
        }
    }
    return count
}

fun front_x(lst: List<String>): List<String> {
    return listOf("oi")
}

fun sort_last(lst: List<List<Int>>):List<List<Int>> {
    return listOf(listOf(9))
}
