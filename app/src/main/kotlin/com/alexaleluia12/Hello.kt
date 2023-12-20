package com.alexaleluia12


fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args.last() else "World"

    println("Hello $name")
}

