import java.util.*

// TreeMap keeps the entries sorted by keys.

fun main() {
    val studentScores = TreeMap<String, Int>()

    studentScores["Zara"] = 88
    studentScores["Alex"] = 95
    studentScores["Mike"] = 75
    studentScores["Bob"] = 82

    println("Student Scores (Sorted by Name):")
    for ((name, score) in studentScores) {
        println("$name -> $score")
    }

    // Retrieve a specific value
    val zaraScore = studentScores["Zara"]
    println("\nZara's Score: $zaraScore")

    // Remove an entry
    studentScores.remove("Mike")

    // Print after removal
    println("\nAfter removing Mike:")
    for ((name, score) in studentScores) {
        println("$name -> $score")
    }

    // Check if map contains a key or value
    println("\nContains key 'Alex': ${studentScores.containsKey("Alex")}")
    println("Contains value 100: ${studentScores.containsValue(100)}")

    // Get first and last keys
    println("\nFirst key: ${studentScores.firstKey()}")
    println("Last key: ${studentScores.lastKey()}")

    println("       ")
    println("---------------------------")
    println("       ")

    val words = listOf("apple", "banana", "apple", "orange", "banana", "apple")

    // Create a TreeMap to store word frequencies
    val wordCount = TreeMap<String, Int>()

    for (word in words) {
        wordCount[word] = wordCount.getOrDefault(word, 0) + 1
    }

    // Print the TreeMap (sorted by word)
    println("Word frequencies (sorted):")
    for ((word, count) in wordCount) {
        println("$word -> $count")
    }
}