interface Validator {
    fun validate(): Boolean
}

class UserValidator(val name: String, val age: Int) : Validator {
    override fun validate(): Boolean {
        if (name.isEmpty() || age < 18) {
            println("Validation failed: Name cannot be empty and age must be 18 or above.")
            return false
        }
        println("Validation successful!")
        return true
    }
}

class User(name: String, age: Int) : Validator by UserValidator(name, age)

fun main() {
    val user = User("John", 25)
    if (user.validate()) {
        println("Proceed with database operations.")
    }
}






