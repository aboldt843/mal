package aboldt.kmal

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    rep()
}

private fun read(): String {
    val input = readLine() ?: exitProcess(0)
    return input
}

private fun eval(s: String): String {
    return s
}

private fun rep(): Nothing {
    while (true) {
        print("user> ")
        val input = read()

        val output = eval(input)

        println(output)
    }
}
