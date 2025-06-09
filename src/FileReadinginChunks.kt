// FileReading in Chunks

import java.io.File
import java.util.concurrent.ConcurrentHashMap

fun main() {
    runBlocking {
        fastCopyToAnotherFile()
    }
}

suspend fun fastCopyToAnotherFile() {
    val inputFile = "C:/Users/vinay/Desktop/inputfile.txt"
    val outputFile = "C:/Users/vinay/Desktop/outputfile.txt"
    val lines = File(inputFile).readLines()

    val resultMap = ConcurrentHashMap<Int, Int>()

    val numCoroutines = 4
    val chunkSize = lines.size / numCoroutines

    val jobs = mutableListOf<Job>()

    for (i in 0 until numCoroutines) {
        val start = i * chunkSize
        val end = if (i == numCoroutines - 1) lines.size else (i + 1) * chunkSize

        val job = CoroutineScope(Dispatchers.Default).launch {
            for (j in start until end) {
                val wordCount = lines[j].split("\\s+".toRegex()).filter { it.isNotBlank() }.size
                resultMap[j] = wordCount
            }
        }
        jobs.add(job)
    }

    jobs.forEach { it.join() }

    // Write results (sorted by line number)
    File(outputFile).bufferedWriter().use { writer ->
        resultMap.entries.sortedBy { it.key }.forEach { (lineNumber, wordCount) ->
            writer.write("Line $lineNumber: $wordCount words\n")
        }
    }

    println("Finished writing to $outputFile")
}
