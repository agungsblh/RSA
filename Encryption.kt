package kriptografi

import kotlin.math.pow

fun main(){
    var x : Long //message
    var n : Long //n = p*q
    var e : Long //Public exponent e/public key
    var y : Long //return value enkripsi

    print("Masukkan nilai pesan x (angka) = ")
    x = readln().toLong()
    print("Masukkan nilai n = ")
    n = readln().toLong()
    print("Masukkan nilai e = ")
    e = readln().toLong()

    y = x.toDouble().pow(e.toInt()).toLong() % n

    println("\nHasil enkripsi y=$y")
}