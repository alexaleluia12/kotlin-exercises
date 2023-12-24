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
    test(removeAdjacent(listOf(1, 2, 2, 3)), listOf(1, 2, 3))
    test(removeAdjacent(listOf(2, 2, 3, 3, 3)), listOf(2, 3))
    test(removeAdjacent(listOf(3)), listOf(3))
    test(removeAdjacent(emptyList()), emptyList<Int>())

    println()
    println("linear_merge")
    test(linearMerge(mutableListOf("aa", "xx", "zz"), mutableListOf("bb", "cc")),
        listOf("aa", "bb", "cc", "xx", "zz"))
    test(linearMerge(mutableListOf("aa", "xx"), mutableListOf("bb", "cc", "zz")),
        listOf("aa", "bb", "cc", "xx", "zz"))
    test(linearMerge(mutableListOf("aa", "aa"), mutableListOf("aa", "bb", "bb")),
        listOf("aa", "aa", "aa", "bb", "bb"))
}

/*
D. Dada uma lista de numeros, retorne uma lista onde
todos adjacentes == elementos serão reduzidos para apenas um elemento,
como [1, 2, 2, 3] retorna [1, 2, 3]. Você pode criar uma nova lista
ou modificar a lista passada
 */
fun removeAdjacent(lst: List<Int>): List<Int> {
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

/*
E. Dada duas lista ordenadas em order crescente, retorne uma nova lista com
a união de todos os outros elementos das listas também ordenado. Sua solução dever
ser linear: O(n)
 */
fun linearMerge(a: MutableList<String>, b: MutableList<String>): List<String> {
    val merge = mutableListOf<String>()
    val dfstr = ""
    var v1: String
    var v2: String

    while ((a.size +  b.size) > 0) {
        v1 = a.getOrElse(0) { dfstr }
        v2 = b.getOrElse(0) { dfstr }
        if (v1 < v2 && v1 != dfstr) {
            merge.add(a.removeAt(0))
        } else {
            if (b.isNotEmpty())
                merge.add(b.removeAt(0))
            else if (a.isNotEmpty())
                merge.add(a.removeAt(0))
        }
    }
    return merge
}