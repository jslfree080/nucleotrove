package com.jslfree080.nucleotrove

fun main() {
    val genome = "ANTGGTTNCAACNGTAANTGCTGANNNACATGTNCGCGTGTA".toCharArray()

    var it = 0

    while (it != genome.size) {
        if (genome[it] == 'N')
            genome[it] = 'A'
        it++
    }
    // Modified genome: AATGGTTACAACAGTAAATGCTGAAAAACATGTACGCGTGTA
    println("Modified genome: ${genome.joinToString(separator = "")}")
}