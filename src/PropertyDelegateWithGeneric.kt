import kotlin.reflect.KProperty

class DefaultIfNullOrBlank<T : Any>(
    private val defaultValue: T
) {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (val v = value) {
            is String -> if (v.isBlank()) defaultValue else v as T
            null -> defaultValue
            else -> v
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: T?) {
        value = newValue
    }
}

class UserResDto {
    var name: String by DefaultIfNullOrBlank("Unknown")
    var email: String by DefaultIfNullOrBlank("no-reply@example.com")
    var age: Int by DefaultIfNullOrBlank(0)
}

fun main() {
    val user = UserResDto()
    println(user.name)  // ➜ Unknown
    println(user.email) // ➜ no-reply@example.com
    println(user.age)   // ➜ 0

    user.name = "   "   // blank string
    println(user.name)  // ➜ Unknown

    user.age = 25
    println(user.age)   // ➜ 25
}