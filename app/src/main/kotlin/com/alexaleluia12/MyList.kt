package com.alexaleluia12

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

        }
    }
}