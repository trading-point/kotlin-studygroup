package cpapadopoulos

data class Symbol(val symbol: Int, val sum: Int)
data class SymbolPair(val symbols: Pair<Int, Int>, val sum: Int)


fun getCaptchaPart1(string: String): Int {
    val chars = stringToIntArray(string)

    val value = (chars + listOf(chars[0])).map { Symbol(it, 0) }
            .reduce { x, y ->
                if (x.symbol == y.symbol)
                    Symbol(x.symbol, x.sum + x.symbol)
                else
                    Symbol(y.symbol, x.sum)
            }

    return value.sum
}

fun getCaptchaPart2(string: String): Int {
    val chars = stringToIntArray(string)

    if (chars.size % 2 != 0) throw IllegalArgumentException("Size of input list of numbers should be even")

    val chunked = chars.chunked(chars.size / 2)

    val result = (chunked[0] zip chunked[1])
            .map { SymbolPair(it, 0) }
            .map { if (it.symbols.first == it.symbols.second) it.symbols.first + it.symbols.second else 0 }
            .sum()

    return result
}

fun stringToIntArray(string: String): List<Int> {
    val chars = string.split("")
            .filter { it.isNotBlank() }
            .map { it.toInt() }
            .toList()
    return chars
}