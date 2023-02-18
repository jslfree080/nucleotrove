package com.jslfree080.nucleotrove

fun main() {
    // initialization
    val text = "This is an awesome tutorial to get to know SeqAn!"
    val pattern = "tutorial"
    /* create an IntArray of size (text.length - pattern.length + 1) */
    val score = IntArray(text.length - pattern.length + 1)

    // computation of the similarities
    // iteration over the text (outer loop)
    for (i in 0 until text.length - pattern.length + 1) {
        var localScore = 0
        // iteration over the pattern for character comparison
        for (j in pattern.indices) {
            if (text[i + j] == pattern[j]) {
                localScore++
            }
        }
        score[i] = localScore
    }

    // prints 1 0 1 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1 0 8 0 1 0 0 0 0 2 0 1 0 0 1 0 3 0 1 0 1 0 0 0 0
    for (s in score) {
        print("$s ")
    }
    println()
}