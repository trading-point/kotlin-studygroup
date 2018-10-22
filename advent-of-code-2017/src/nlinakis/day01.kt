package nlinakis

val input = ""

fun main(args: Array<String>) {
    println(problem2())
}

fun problem2() {
    val list = (input + input[0])        // make a pseudo circular list

    list
            .zip(list.substring(list.length / 2, list.length - 1))
            .filter { it.first == it.second }
            .map { it.first.asDigit() * 2 }        // we could just add first + second but we know they are the same ;)
            .sum()
}

fun Char.asDigit(): Int = if (this.isDigit()) this - '0' else 0