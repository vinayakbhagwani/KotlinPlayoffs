import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {
    val user = UserDto(id = 1, email = "test@example.com")
    val nm = "     Alice    "
//    println(nm)
    user.name = nm
//    println(user.name)
    user.name = "    Bob      "

}

class TrimmedStringDelegate(private var value: String = "") {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = newValue.trim()
    }
}

data class UserDto(
    var id: Int = 0,
    var email: String = ""
) {
//    var name: String by TrimmedStringDelegate()

    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        kotlin.io.println("Property '${prop.name}' changed from '$old' to '$new'")
    }

    constructor(id: Int = 0, email: String = "", name: String): this(id, email) {
        this.name = name
    }
}






