
fun main(args: Array<String>) {
    rep()
}

private fun eval(s: String): String {
    return s
}

private fun rep() {
    while (true) {
        print("user> ")
        val input = readLine() ?: return
        val output = eval(input)
        println(output)
    }
}