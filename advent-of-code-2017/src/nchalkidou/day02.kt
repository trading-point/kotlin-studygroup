package nchalkidou

val input = listOf("")

fun main(args: Array<String>) {
    println("Part 1: " + checkSumWithDiff(input))
    println("Part 2: " + checkSumWithDevide(input))
}

fun checkSumWithDiff(input: List<String>): Int {
    var sum = 0
    input.forEach {
        val lineInput = it.split("[\t ]".toRegex()).map(String::toInt)
        sum += (lineInput.max()!! - lineInput.min()!!)
    }
    return sum
}

fun checkSumWithDevide(input: List<String>): Int {
    var sum = 0
    input.forEach {
        val lineInput = it.split("[\t ]".toRegex()).map(String::toInt).sortedDescending()
        for (numA in lineInput) {
            for (numB in lineInput) {
                if (numA != numB && numA % numB == 0) {
                    sum += numA / numB
                }
            }
        }
    }
    return sum
}