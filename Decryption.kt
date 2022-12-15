package kriptografi

import kotlin.math.pow

fun main(){
    var d : Long
    var n : Long
    var y : Long

    print("Masukkan nilai y = ")
    y = readln().toLong()
    print("Masukkan nilai d (private key) = ")
    d = readln().toLong()
    print("Masukkan nilai n = ")
    n = readln().toLong()
    var values = y.toDouble().pow(d.toInt()).toLong() % n

    println("\nHasil Dekripsi X = $values")
}