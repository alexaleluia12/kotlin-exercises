package com.alexaleluia12

class map {
    companion object {
        fun doWork() {
            println("Map - dict python like")
            val d = mutableMapOf<Char, String>()
            d['a'] = "alpha"
            d['g'] = "gamma"
            d['o'] = "omega"

            println(d.toString())
            println(d['a'])
            d['a'] = "happy"
            println('a' in d)
            println(d['z']) // se chave nao existe retorna null
            // getValue() lanca exceção se não existir
            println(d.getOrElse('k') { "new" })

            for (v in d) {
                println(v) // Par chave/valor
            }
            println(d.keys)
            println(d.values)
            // loop chave em ordem descrescente
            for (v in d.keys.sortedDescending()) {
                println(d[v])
            }

            // lista de pares chave/valor
            println(d.entries)

            println("I'm ${d['a']}")

            // deletar par chave/valor
            println(d.remove('g'))
            println(d)
        }
    }
}