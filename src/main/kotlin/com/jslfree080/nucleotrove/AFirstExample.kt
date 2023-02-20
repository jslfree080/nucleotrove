package com.jslfree080.nucleotrove

fun computeLocalScore(subText: String, pattern: String): Int {
    var localScore = 0
    // iteration over the pattern for character comparison
    for (i in pattern.indices) {
        if (subText[i] == pattern[i]) {
            localScore++
        }
    }
    return localScore
}

fun computeScore(text: String, pattern: String): IntArray {
    /* create an IntArray of size (text.length - pattern.length + 1) */
    val score = IntArray(text.length - pattern.length + 1)
    // computation of the similarities
    // iteration over the text (outer loop)
    for (i in 0 until text.length - pattern.length + 1) {
        score[i] = computeLocalScore(text.substring(i, i + pattern.length), pattern)
    }
    return score
}

fun main() {
    // initialization
    val text = "This is an awesome tutorial to get to know nucleotrove!"
    val pattern = "tutorial"
    val score = computeScore(text, pattern)

    println(text) // This is an awesome tutorial to get to know nucleotrove!
    println(pattern) // tutorial
    // 1 0 1 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1 0 8 0 1 0 0 0 0 2 0 1 0 0 1 0 3 0 1 0 1 0 1 0 0 0 1 0 1 1 1
    println(score.joinToString(separator = " "))
    println(score.indexOf(score.max())) // 19
    // (2; 1) (5; 1) (12; 1) (17; 1) (19; 8) (21; 1) (26; 2) (28; 1) (31; 1) (33; 3) (35; 1) (37; 1) (39; 1) (43; 1) (45; 1) (46; 1) (47; 1)
    println(
        score
            .mapIndexed { index, value -> Pair(index, value) }
            .filter { (index, _) -> index > 0 }
            .filter { (_, value) -> value > 0 }
            .joinToString(separator = " ") { (index, value) -> "($index; $value)" }
    )

    // And now for a protein pattern
}