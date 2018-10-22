package cpateritsas

////////////////////// Part 1 ////////////////////////

class MinMax (var min:Int = Int.MAX_VALUE, var max: Int = -Int.MAX_VALUE) {

    fun update(value: Int): MinMax {
        if (value < min) {
            min = value
        }
        if (value > max) {
            max = value
        }
        return this
    }

    fun diff(): Int {
        //println("min: $min max: $max")
        return max - min
    }
}

fun solvePart1(input: List<List<Int>>) {
    var sum:Int = input.map{ it.fold(MinMax(),
            { minmax, c -> minmax.update(c) })
            .diff()
    }.sum()

    println("part1 solution is $sum")
}

////////////////////// Part 2 ////////////////////////

fun List<Int>.checkDiv(): Int {
    //println("value is $value, list is $list")

    if (this.size == 1)
        return throw(IllegalArgumentException("Not as promised"))

    val first = this[0]

    for(x in this.subList(1, this.size)) {
        if (first < x && (x % first == 0)) {
            return x / first
        } else if (first % x == 0) {
            return first / x
        }
    }

    return this.subList(1, this.size).checkDiv()
}


fun solvePart2(input: List<List<Int>>) {

    var sum:Int = input.map{ it.checkDiv() }.sum()

    println("part2 solution is $sum")
}

//////////////////////////////////////////////////////

fun main(args: Array<String>) {

    var input = getInput()

    solvePart1(input)

    solvePart2(input)

    //1st part : 43074, 2nd part 280

}

fun getInput() : List<List<Int>> {
    return listOf(listOf(157,564,120,495,194,520,510,618,244,443,471,473,612,149,506,138),
            listOf(1469,670,47,604,1500,238,1304,1426,54,749,1218,1409,60,51,1436,598),
            listOf(578,184,2760,3057,994,167,2149,191,2913,2404,213,1025,1815,588,2421,3138),
            listOf(935,850,726,155,178,170,275,791,1028,75,781,138,176,621,773,688),
            listOf(212,977,297,645,229,194,207,640,804,509,833,726,197,825,242,743),
            listOf(131,43,324,319,64,376,231,146,382,162,464,314,178,353,123,446),
            listOf(551,121,127,155,1197,288,1412,1285,557,137,145,1651,1549,1217,681,1649),
            listOf(1723,1789,5525,4890,3368,188,3369,4842,3259,2502,4825,163,146,2941,126,5594),
            listOf(311,2420,185,211,2659,2568,2461,231,2599,1369,821,506,2227,180,220,1372),
            listOf(197,4490,141,249,3615,3314,789,4407,169,352,4383,5070,5173,3115,132,3513),
            listOf(4228,2875,3717,504,114,2679,165,3568,3002,116,756,151,4027,261,4813,2760),
            listOf(651,3194,2975,2591,1019,835,3007,248,3028,1382,282,3242,296,270,3224,3304),
            listOf(1858,1650,1720,1848,95,313,500,1776,207,1186,72,259,281,1620,79,77),
            listOf(3841,3217,440,3481,3643,940,3794,4536,1994,4040,3527,202,193,1961,230,217),
            listOf(2837,2747,2856,426,72,78,2361,96,2784,2780,98,2041,2444,1267,2167,2480),
            listOf(411,178,4263,4690,3653,162,3201,4702,3129,2685,3716,147,3790,4888,79,165))
}

fun getInputTest() : List<List<Int>> {
    return listOf(listOf(5, 1, 9, 5),
            listOf(7, 5, 3),
            listOf(2, 4, 6, 8))
}

fun getInputTest2() : List<List<Int>> {
    return listOf(listOf(5, 9, 2, 8),
            listOf(9, 4, 7, 3),
            listOf(3, 8, 6, 5))
}
