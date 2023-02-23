package com.jslfree080.nucleotrove

fun lexical(a: String, b: String): Int {
    if (a.length != b.length) { println("Not comparable!"); return 0 }
    var valueOfA = 0
    var valueOfB = 0
    for (i in a.indices) {
        if (a[i] < b[i]) { valueOfB++ }
        else if (a[i] > b[i]) { valueOfA++ }
        else { continue }
    }
    return valueOfB - valueOfA
}

fun isLess(value: Int): Boolean {
    if (value > 0) { return true }
    return false
}

fun isGreater(value: Int): Boolean {
    if (value < 0) { return true }
    return false
}

fun main() {
    val nucleotidesList = ArrayList<String>()
    val str1 = "ATATANGCGT"
    val str2 = "AAGCATGANT"
    val str3 = "TGTTTNTGAC"
    nucleotidesList.add(str1)
    nucleotidesList.add(str2)
    nucleotidesList.add(str3)

    val lesser = ArrayList<String>()
    val greater = ArrayList<String>()
    val ref = "GATGCATGAT"

    // For each String of the ArrayList:
    for (i in nucleotidesList.indices) {
        // Compare the String with the given reference string
        // The result of the comparison is stored in comp
        val comp = lexical(nucleotidesList[i], ref)
        println(comp)
        // The function isLess checks only the stored result
        // without comparing the sequences again
        if (isLess(comp))
            lesser.add(nucleotidesList[i])
        else if (isGreater(comp))
            greater.add(nucleotidesList[i])
    }
    // Print the results
    println("Lesser sequences: ")
    for (seq in lesser) {
        print("$seq, ") // ATATANGCGT, AAGCATGANT,
    }
    println()
    println("Greater sequences: ")
    for (seq in greater) {
        print("$seq, ") // TGTTTNTGAC,
    }
}