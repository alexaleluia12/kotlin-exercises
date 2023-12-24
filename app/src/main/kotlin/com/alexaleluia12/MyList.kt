package com.alexaleluia12

import kotlin.math.floor
import kotlin.math.round
import kotlin.math.sqrt

class lst {
    companion object {
        fun doWork() {
            println("list learning")
            val colors = listOf("red", "blue", "green") // lista *imutavel*
            println(colors[0])
            println(colors[2])
            println(colors.size)

            val squares = listOf(1, 4, 9, 16)
            var sum = 0
            for (n in squares) {
                sum += n
            }
            println(sum) // 30

            println("blue" in colors)
            for (i in 0..< 10) {
                print(i)
                print(' ')
            }
            println()
            val bc = mutableListOf<Int>()
            val bk = listOf(8, 9, 10)
            val listMethods = """
            bc.add(45), add(index, 45)
            bc.addAll(otherList) : concatenar listas
            bc.indexOf(elemento) : -1 se não achou ou indece caso exista (Int)
            bc.removeAt(index) : remove e retona elemento removido, pode lancar IndexOutOfBoundsException
            bc.remove(elemento) : apenas remove caso  exista sem execoes e retorna um (Boolean)
            bc.sort() : ordena lista (crescente), alterando ela mesma in-place
            bc.reverse() : in-place reverte
                non in-place: sorted(), reversed()
            """.trimIndent()
            bc.add(45)
            bc.addAll(bk)
            println(bc.indexOf(11))
            println(bc.removeAt(1))
            println(bc.remove(52))
            bc.sort()
            bc.reverse()
            println(bc.toString())

            var ob = mutableListOf('a', 'b', 'c', 'd')
            println(ob.slice(1 ..< ob.size-1 ))
            // slice com atribuição não tem
            // ordenacao
            var oc = mutableListOf("ccc", "aaaa", "d", "bb")
            println(oc.sortedBy { it.length }) // ordena pelo tamanho da palavra

            // trible
            var od = mutableListOf(
                Triple("Freddy", "Frank", 3),
                Triple("Anil", "Frank", 100),
                Triple("Anil", "Wang", 24)
            )
            // ordenar pelo primeiro nome e score
            println(od.sortedBy { it.first + it.third })

            // 1 .. 100
            // todo dos numero que sao quadrados perfeitos
            val oe = List(100){ it+1 }
            // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
            println(oe.filter { v ->
                val sv = sqrt(v.toFloat())
                (sv - sv.toInt()) <= 0.0f
            })
            val oz = listOf(1, 2, 3, 4)
            println(oz.map { it*it }) // [1, 4, 9, 16]
        }
    }
}