package ru.herobrine1st.practice

class Singleton private constructor() {
    companion object {
        @JvmStatic
        val INSTANCE by lazy { Singleton() }
    }
    
    fun helloWorld() {
        println("Hello World!")
    }
}

fun main() {
    Singleton.INSTANCE.helloWorld()
}