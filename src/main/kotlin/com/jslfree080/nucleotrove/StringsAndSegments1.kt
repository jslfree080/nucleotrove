package com.jslfree080.nucleotrove

import kotlin.system.exitProcess

fun getRevCompl(nucleotide: Char): Char {
    return when (nucleotide) {
        'A' -> 'T'
        'T' -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        'N' -> 'N'
        else -> 'X'
    }
}

fun main() {
    val genome = "TATATACGCGCGAGTCGT"
    println(genome) // TATATACGCGCGAGTCGT
    println(genome.reversed().map { getRevCompl(it) }.joinToString(separator = "")) // ACGACTCGCGCGTATATA
    exitProcess(0)
}