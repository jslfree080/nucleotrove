package com.jslfree080.nucleotrove

import kotlin.text.StringBuilder

// Function to print simple alignment between two sequences with the same length
fun <TText1, TText2> printAlign(genomeFragment: TText1, read: TText2) {
    println("Alignment")
    println("  genome : $genomeFragment")
    println("  read   : $read")
}

fun main() {
    // Build reads and genomes
    val chr1 =
        "TATAATATTGCTATCGCGATATCGCTAGCTAGCTACGGATTATGCGCTCTGCGATATATCGCGCTAGATGTGCAGCTCGATCGAATGCACGTGTGTGCGATCGATTAGCGTCGATCATCGATCTATATTAGCGCGCGGTATCGGACGATCATATTAGCGGTCTAGCATTTAG"

    // Build List containing all reads
    val readList = mutableListOf(
        "TTGCTATCGCGATATCGCTAGCTAGCTACGGATTATGCGCTCTGCGATATATCGCGCT",
        "TCGATTAGCGTCGATCATCGATCTATATTAGCGCGCGGTATCGGACGATCATATTAGCGGTCTAGCATT",
        "AGCCTGCGTACGTTGCAGTGCGTGCGTAGACTGTTGCAAGCCGGGGGTTCATGTGCGCTGAAGCACACATGCACA",
        "CGTGCACTGCTGACGTCGTGGTTGTCACATCGTCGTGCGTGCGTACTGCTGCTGACA"
    )

    // Append a second chromosome sequence fragment to chr1
    val chr2 =
        "AGCCTGCGTACGTTGCAGTGCGTGCGTAGACTGTTGCAAGCCGGGGGTTCATGTGCGCTGAAGCACACATGCACACGTCTCTGTGTTCCGACGTGTGTCACGTGCACTGCTGACGTCGTGGTTGTCACATCGTCGTGCGTGCGTACTGCTGCTGACACATGCTGCTG"
    val chr1And2 = chr1 + chr2

    // Print readlist
    println("\n Read list:")
    readList.forEach { println(it) }

    // 1. Assume we have mapped the 4 reads to chr1 (and chr2) and now have the mapping start positions (no gaps).
    // Store the start position in a List alignPosList: 7, 100, 172, 272
    val alignPosList = listOf(7, 100, 172, 272)

    // 2. Bisulfite conversion
    // Assume chr1 is being bisulfate treated: Copy chr1 to a new genome bsChr1 and exchange every 'C' with a 'T'
    val bsChr1 = StringBuilder()
    for (c in chr1And2) {
        bsChr1.append(if (c == 'C') 'T' else c)
    }

    // 3. Print alignments of the reads with chr1 (or bsChr1) sequence using the function printAlign
    // and the positions in alignPosList.
    // To do that, you have to create a copy of the fragment in chr1 (bsChr1) that is aligned to the read.

    println("\n Print alignment: ")
    for (i in readList.indices) {
        // Begin position beginPosition of a given alignment between the read and the genome
        val beginPosition = alignPosList[i]

        // Genome fragment
        val genomeFragment = StringBuilder()

        // We have to create a copy of the corresponding fragment of the genome, where the read aligns to
        for (j in readList[i].indices) {
            genomeFragment.append(chr1And2[beginPosition + j])
        }

        // Call of our function to print the simple alignment
        printAlign(genomeFragment, readList[i])
    }
}