package stzifa

import java.util.*
import kotlin.streams.*

class Day1KotlinProject {

    fun sumDigitsInSequence(streamSize: Long): Int{
        val sequence = createRandomInput(streamSize).joinToString("")

        return sumDigitsGivenSeries(sequence)
    }

    fun sumDigitsGivenSeries(streamLine: String): Int{

        return (streamLine + streamLine[0])
                .filter { isDigitIdentify(it) }
                .zipWithNext { a, b -> if (a == b) a.toString().toInt() else 0 }
                .sum()
    }

    fun sumDigitsGivenSeriesWithMiddle(streamLine: String): Int{

        val chunkedList = streamLine.toList().chunked(streamLine.length.div(2))

        return (chunkedList[0] zip chunkedList[1])
                .map { Pair(Integer.parseInt(it.first.toString()), Integer.parseInt(it.second.toString()))}
                .map { if (it.first == it.second) it.first * 2 else 0 }
                .sum()


    }

    fun createRandomInput(streamSize: Long): List<Int> {

        return Random().ints(streamSize, 0, 9).asSequence().toList()
    }

    fun isDigitIdentify(character: Char): Boolean {

        if (character.isDigit()) return true else throw IllegalArgumentException()
    }

}