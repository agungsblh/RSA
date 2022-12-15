package kriptografi

fun main (){
    var p: Long //Large primes
    var q: Long //Large primes
    var e: Long //Public exponent e
    val d: Long //Private key d
    val n: Long //n = p*q
    val phi: Long //phi(n) = (p-1)*(q-1)

    do {
        print("Masukkan bilangan prima p: ")
        p = readln().toLong()
    }while (!isPrime(p))
    do {
        print("Masukkan bilangan prima q: ")
        q = readln().toLong()
    }while (!isPrime(q))

    n = p*q
    phi = (p-1)*(q-1)

    println("n=$p x $q = $n")
    println("phi($n)=($p-1)x($q-1)=$phi")

    do {
        print("\nMasukkan public eksponen (e): ")
        e = readln().toLong()
    }while (!checkGcd(e,phi))

    d = privateKeyD(e,phi)

    println("\nNilai n = $n")
    println("Nilai e = $e")
    println("Private Key (d) = $d")
    println("Public Key = ($n,$e)")
}

private fun isPrime(bil:Long):Boolean{
    if(bil<2){
        print("$bil bukan bilangan prima, coba lagi\n")
        return false
    }
    for(i in 2..bil/2){
        if((bil%i).toInt()==0){
            print("$bil bukan bilangan prima, coba lagi\n")
            return false
        }
    }
    return true
}
private fun checkGcd(e:Long, phi:Long):Boolean{
    var gcd = 1
    var i = 1

    if (e>=phi){
        println("Angka yang dipilih lebih besar dari nilai phi, coba lagi")
        return false
    }
    while (i<=e){
        if((e%i).toInt() == 0 && (phi%i).toInt()==0){
            gcd = i
        }
        ++i
    }
    if (gcd==1){
        return true
    }else{
        println("GCD -> $gcd != 1, silahkan pilih angka lain")
        return false
    }
}

private fun privateKeyD(e: Long,phi: Long):Long{
    for (i in 1..Int.MAX_VALUE){
        if (((e*i) % phi).toInt() ==1){
            println("Private key d = $i")
            return i.toLong()
        }
    }
    return 0
}