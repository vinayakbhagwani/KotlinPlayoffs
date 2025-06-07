
fun main() {
    val nestedGreet = object : Outer.NestedGreet() {
        override fun greet() = "Hello"
    }
    println("${nestedGreet.greet()} World")
}


class Outer {
    private val outerMsg = "Hello from Outer"
    //anonymous nested class
    abstract class NestedGreet {

        abstract fun greet(): String
    }
}