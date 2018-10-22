package nchalkidou

fun main(args: Array<String>) {
    problem1()

    problem2()
}

fun problem1() {
    val text = "..."
    var sum = 0
    for (i in 0..text.length - 1) {
        var first = text[i]
        var second = if (i + 1 >= text.length) text[0] else text[i + 1]
        if (first == second) {
            sum = sum + first.toString().toInt()
        }
    }
    println(sum)
}


fun problem2() {
    val text = "..."
    val half = text.length / 2

    var sum = 0
    for (i in 0..text.length / 2 - 1) {
        var first = text[i]
        var second = text[i + half]
        if (first == second) {
            sum = sum + first.toString().toInt() * 2
        }

    }
    println(sum)
}