package cpaidarakis

fun main(args: Array<String>) {
    val input = ""

    val count = input.count()
    var sum = 0
    for (i in 0..count-1) {
        if (input[i] == input[(i+1)%count]) {
            sum = sum + input[i].toString().toInt()
        }
    }
    print(sum)
}

