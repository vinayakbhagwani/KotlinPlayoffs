interface Producer {

    fun produce(): String
}

class ProducerImpl : Producer {

    override fun produce() = "ProducerImpl"
}

class EnhancedProducer(private val delegate: Producer) : Producer by delegate {

    fun addMoreString() = "${produce()} and Enhanced"

    override fun produce() = "${delegate.produce()} and EnhancedProducer"
}

fun main() {
    val producer = EnhancedProducer(ProducerImpl())
    println(producer.addMoreString())
}