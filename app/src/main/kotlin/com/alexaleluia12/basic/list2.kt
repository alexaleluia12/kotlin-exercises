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
    println("remove_adjacent")
    test(remove_adjacent(listOf(1, 2, 2, 3)), listOf(1, 2, 3))
    test(remove_adjacent(listOf(2, 2, 3, 3, 3)), listOf(2, 3))
    test(remove_adjacent(listOf(3)), listOf(3))
    test(remove_adjacent(emptyList()), emptyList<Int>())

    println()
    println("linear_merge")
    test(linear_merge(listOf("aa", "xx", "zz"), listOf("bb", "cc")),
        listOf("aa", "bb", "cc", "xx", "zz"))
    test(linear_merge(listOf("aa", "xx"), listOf("bb", "cc", "zz")),
        listOf("aa", "bb", "cc", "xx", "zz"))
    test(linear_merge(listOf("aa", "aa"), listOf("aa", "bb", "bb")),
        listOf("aa", "aa", "aa", "bb", "bb"))
}

/*
D. Dada uma lista de numeros, retorne uma lista onde
todos adjacentes == elementos serão reduzidos para apenas um elemento,
como [1, 2, 2, 3] retorna [1, 2, 3]. Você pode criar uma nova lista
ou modificar a lista passada
 */
fun remove_adjacent(lst: List<Int>): List<Int> {
    if (lst.isEmpty()) return emptyList()

    var prev = lst.first()
    val nlst = mutableListOf<Int>(prev)
    for (i in 1 ..< lst.size) {
        val current = lst[i]
        if (current != prev) {
            nlst.add(current)
            prev = current
        }
    }
    return nlst
}

fun linear_merge(a: List<String>, b: List<String>): List<String> {
    return listOf("name")
}