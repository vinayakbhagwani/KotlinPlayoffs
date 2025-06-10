
class FindUseCaseProg<T>(
    private val list: List<T>,
    private val searchValue: T
) {
    fun isValueThere(): T? {
        return list.find { it == searchValue }
    }
}

fun main() {
    val list = listOf("Hello","World","Kotlin", 1, 54.5F, 25)
    var abc = "Not"
    var inputValue: Any = "Kot"
    println(list.toString())
    println("$inputValue found? ${FindUseCaseProg(list, inputValue).isValueThere() ?: abc} found in the list")

    inputValue = "Kotlin"
    println(list.toString())
    println("$inputValue found? ${FindUseCaseProg(list, inputValue).isValueThere() ?: abc} found in the list")

    inputValue = 54.5F
    println(list.toString())
    println("$inputValue found? ${FindUseCaseProg(list, inputValue).isValueThere() ?: abc} found in the list")
}