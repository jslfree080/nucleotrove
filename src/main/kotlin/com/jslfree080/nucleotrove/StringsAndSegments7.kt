package com.jslfree080.nucleotrove

import java.time.Duration
import java.time.Instant

/* How should we use Stringbuilder()? */
fun main() {
    val num = 10000000u // When this value is large enough, former is faster than latter.

    val elapsed1: Duration
    val str1 = StringBuilder(num.toInt()) // set the initial capacity to num.toInt()
    val start1: Instant = Instant.now()
    repeat(num.toInt()) {
        str1.append('A')
    }
    elapsed1 = Duration.between(start1, Instant.now())
    println("Strategy Exact() took: ${elapsed1.toMillis()} ms\n") // Not sure of this. Take this matter later.

    val elapsed2: Duration
    val str2 = StringBuilder() // uses the generous allocation strategy
    val start2 = Instant.now()
    repeat(num.toInt()) {
        str2.append('A')
    }
    elapsed2 = Duration.between(start2, Instant.now())
    println("Strategy Generous() took: ${elapsed2.toMillis()} ms\n") // Not sure of this. Take this matter later.
}