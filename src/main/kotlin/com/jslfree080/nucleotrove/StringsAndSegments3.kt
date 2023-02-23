package com.jslfree080.nucleotrove

fun main() {
    val nucleotides = "AGTCGTGNNANCT".toCharArray()
    val lesser = mutableListOf<Char>()
    val greater = mutableListOf<Char>()

    /* compare characters using their Unicode values */
    nucleotides.forEach {
        if (it < 'G') {
            lesser.add(it)
        } else if (it > 'G') {
            greater.add(it)
        }
    }
    println("Lesser nucleotides: ${lesser.joinToString(separator = "")}") // Lesser nucleotides: [A, C, A, C]
    println("Greater nucleotides: ${greater.joinToString(separator = "")}") // Greater nucleotides: [T, T, N, N, N, T]
}