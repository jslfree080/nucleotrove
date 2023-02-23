package com.jslfree080.nucleotrove

import kotlin.text.StringBuilder

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
    // [7, 100, 172, 272]
    val alignPosList = List(readList.size) { index -> maxOnly(computeScore(chr1And2, readList[index])) }

    // 2. Bisulfite conversion
    // Assume chr1 is being bisulfate treated: Copy chr1 to a new genome bsChr1And2 and exchange every 'C' with a 'T'
    val bsChr1And2 = StringBuilder()
    for (base in chr1And2) {
        bsChr1And2.append(if (base == 'C') 'T' else base)
    }

    // 3. Print alignments of the reads with chr1 (or bsChr1And2) sequence using the function printAlign
    // and the positions in alignPosList.
    // To do that, you have to create a copy of the fragment in chr1 (bsChr1And2) that is aligned to the read.

    println("\n Print alignment: ")
    readList.indices.forEach {
        // Begin position beginPosition of a given alignment between the read and the genome
        val beginPosition = alignPosList[it]

        // Genome fragment using substring sequence of genome
        val genomeFragment = chr1And2.substring(beginPosition, beginPosition + readList[it].length)

        // Call of our function to print the simple alignment
        printAlign(genomeFragment, readList[it])
    }
    /*
     Read list:
    TTGCTATCGCGATATCGCTAGCTAGCTACGGATTATGCGCTCTGCGATATATCGCGCT
    TCGATTAGCGTCGATCATCGATCTATATTAGCGCGCGGTATCGGACGATCATATTAGCGGTCTAGCATT
    AGCCTGCGTACGTTGCAGTGCGTGCGTAGACTGTTGCAAGCCGGGGGTTCATGTGCGCTGAAGCACACATGCACA
    CGTGCACTGCTGACGTCGTGGTTGTCACATCGTCGTGCGTGCGTACTGCTGCTGACA

     Print alignment:
    Alignment
      genome : TTGCTATCGCGATATCGCTAGCTAGCTACGGATTATGCGCTCTGCGATATATCGCGCT
      read   : TTGCTATCGCGATATCGCTAGCTAGCTACGGATTATGCGCTCTGCGATATATCGCGCT
    Alignment
      genome : TCGATTAGCGTCGATCATCGATCTATATTAGCGCGCGGTATCGGACGATCATATTAGCGGTCTAGCATT
      read   : TCGATTAGCGTCGATCATCGATCTATATTAGCGCGCGGTATCGGACGATCATATTAGCGGTCTAGCATT
    Alignment
      genome : AGCCTGCGTACGTTGCAGTGCGTGCGTAGACTGTTGCAAGCCGGGGGTTCATGTGCGCTGAAGCACACATGCACA
      read   : AGCCTGCGTACGTTGCAGTGCGTGCGTAGACTGTTGCAAGCCGGGGGTTCATGTGCGCTGAAGCACACATGCACA
    Alignment
      genome : CGTGCACTGCTGACGTCGTGGTTGTCACATCGTCGTGCGTGCGTACTGCTGCTGACA
      read   : CGTGCACTGCTGACGTCGTGGTTGTCACATCGTCGTGCGTGCGTACTGCTGCTGACA
    */
}