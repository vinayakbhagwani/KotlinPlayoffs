

fun main() {
    val clickObj = object : ClickListener("ABCD") {
        override fun onClick() {
            println("Button Clicked")
        }
    }
    clickObj.greet()
    setClickListener(clickObj)
}

abstract class ClickListener(val greeting: String) {

    abstract fun onClick()

    fun greet() {
        println("Hello $greeting")
    }
}

fun setClickListener(listener: ClickListener) {
    listener.onClick()
}
