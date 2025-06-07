fun main(): Unit
//runBlocking
{

//    launch {
//        takeOrder("Customer 1")
//        cookOrder("Customer 1")
//        deliverIt("Customer 1")
//    }
//
//    launch {
//        takeOrder("Customer 2")
//        cookOrder("Customer 2")
//        deliverIt("Customer 2")
//    }
}


suspend fun takeOrder(name: String) {
    println("taking order - $name")
}

suspend fun cookOrder(name: String) {
    println("cooking order - $name")
//    delay(4000)
}

suspend fun deliverIt(name: String) {
    println("delivering order - $name")
}
