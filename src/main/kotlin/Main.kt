package ru.herobrine1st.practice

class Singleton private constructor() {
    companion object {
        @JvmStatic
        val INSTANCE by lazy { Singleton() }
    }
    
    fun helloWorld() {
        println("Hello World from $this!") // outputs a hashcode to verify it is the same instance of this class
    }

    fun helloUser() {
        println("Hello User from $this!")
    }
}

fun main() {
    Singleton.INSTANCE.helloWorld()
    Singleton.INSTANCE.helloUser()
}