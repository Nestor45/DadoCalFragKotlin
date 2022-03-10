package com.example.dado2

import kotlin.random.Random

class Dado(val lados: Int = 6) {
    fun lanzar():Int {
        return Random.nextInt(1,this.lados+1)
//        return (1..this.lados).random()
    }
}