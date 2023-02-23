package com.jslfree080.nucleotrove

fun main() {
    val genome = "ANTGGTTNCAACNGTAANTGCTGANNNACATGTNCGCGTGTA".toCharArray()

    var it = 0
    val itEnd = genome.size

    while (it != itEnd) {
        if (genome[it] == 'N')
            genome[it] = 'A'
        it++
    }
    // Modified genome: AATGGTTACAACAGTAAATGCTGAAAAACATGTACGCGTGTA
    println("Modified genome: ${genome.joinToString(separator = "")}")
}