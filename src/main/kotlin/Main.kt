// this enum class represents the 20 common amino acids found in proteins
enum class AminoAcid {
    A, R, N, D, C, Q, E, G, H, I, L, K, M, F, P, S, T, W, Y, V
}

/*
this generic function swaps the first and second elements of a mutable list str
of any type T as long as the size of the list is greater than or equal to 2
*/
fun <T> exchangeFirstValues(str: MutableList<T>) {
    if (str.size < 2) {
        return
    }
    val temp = str[0]
    str[0] = str[1]
    str[1] = temp
}

fun main() {
    val aminoStr = mutableListOf(AminoAcid.A, AminoAcid.R, AminoAcid.N)
    exchangeFirstValues(aminoStr)
    println(aminoStr) // prints [R, A, N]
}