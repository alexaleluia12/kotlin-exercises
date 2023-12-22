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


    println()
    println("front_x")
    test(front_x(listOf("bbb", "ccc", "axx", "xzz", "xaa")),
        listOf("xaa", "xzz", "axx", "bbb", "ccc"))
    test(front_x(listOf("ccc", "bbb", "aaa", "xcc", "xaa")),
        listOf("xaa", "xcc", "aaa", "bbb", "ccc"))
    test(front_x(listOf("mix", "xyz", "apple", "xanadu", "aardvark")),
        listOf("xanadu", "xyz", "aardvark", "apple", "mix"))


    println()
    println("sort_last")
    test(
        sortLast(listOf(listOf(1, 3), listOf(3, 2), listOf(2, 1))),
        listOf(listOf(2, 1), listOf(3, 2), listOf(1, 3))
    )
    test(
        sortLast(listOf(listOf(2, 3), listOf(1, 2), listOf(3, 1))),
        listOf(listOf(3, 1), listOf(1, 2), listOf(2, 3))
    )
    test(
        sortLast(listOf(listOf(1, 7), listOf(1, 3), listOf(3, 4, 5), listOf(2, 2))),
        listOf(listOf(2, 2), listOf(1, 3), listOf(3, 4, 5), listOf(1, 7))
    )
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
/*
B. front x
Dada uma lista de strings, retorne uma lista com as strings
em ordem alfabética, exceto agrupe todas as strings que começam com 'x' primeiro.
Por exemplo, ['mix', 'xyz', 'apple', 'xanadu', 'aardvark']
resulta em ['xanadu', 'xyz', 'aardvark', 'apple', 'mix']
Dica: isso pode ser feito criando 2 listas e classificando cada uma delas antes de combiná-las.
 */
fun front_x(lst: List<String>): List<String> {
    val xlist = mutableListOf<String>()
    val others = mutableListOf<String>()
    for (s in lst) {
        if (s.startsWith('x'))
            xlist.add(s)
        else
            others.add(s)
    }

    return xlist.sorted() + others.sorted()
}

/*
C. sort last
Dada uma lista de lista de inteiros, retorne a lista em ordem crescrente
com base no último elemento de cada sublista
Exemplo: [[1, 7], [1, 3], [3, 4, 5], [2, 2]] gera
 [(2, 2), (1, 3), (3, 4, 5), (1, 7)]
 */
fun sortLast(lst: List<List<Int>>): List<List<Int>> {
    /*
    // tem mesmo resultado
    return lst.sortedWith{a, b ->
        a.last() - b.last()
    }
     */
    return lst.sortedBy { it.last() }
}
