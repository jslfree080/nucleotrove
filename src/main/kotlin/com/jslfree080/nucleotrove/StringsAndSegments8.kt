package com.jslfree080.nucleotrove

// Function to print simple alignment between two sequences with the same length
// .. for two sequences of different types
fun <TText1: CharSequence, TText2: CharSequence> printAlign(genomeFragment: TText1, read: TText2) {
    println("Alignment ")
    println("  genome : $genomeFragment")
    println("  read   : $read")
}

fun main() {
    // We have given a genome sequence
    val genome = "ATGGTTTCAACGTAATGCTGAACATGTCGCGT"
    // A read sequence
    val read = "TGGTNTCA"
    // And the begin position of a given alignment between the read and the genome
    val beginPosition = 1

    // Get the corresponding substring sequence of genome
    val genomeFragment = genome.substring(beginPosition, beginPosition + read.length)

    // Call of our function to print the simple alignment
    printAlign(genomeFragment, read)
}
/*
Alignment
  genome : TGGTTTCA
  read   : TGGTNTCA
*/