package nlinakis

import java.io.File

fun main(args: Array<String>) {

    println("Advent of Code - Day 2")
    println("a) ${day2a()}")
    println("a) ${day2b()}")
}

fun day2a(): Int =
        parseInput()
                // https://blog.kotlin-academy.com/effective-kotlin-use-sequence-for-bigger-collections-with-more-than-one-processing-step-649a15bb4bf
                .asSequence()
                .map { it.sorted() }
                .map { if (it.size > 1) it.last() - it.first() else it.first() }
                .sum()

fun day2b(): Int =
        parseInput()
                .asSequence()
                .map { it.sorted() }
                .map { recursiveCheck(it.first(), it.subList(1, it.size)) }
                .sum()

fun recursiveCheck(check: Int, against: List<Int>): Int {

    for (item in against) {
        val diff = evenlyDividedDistance(check, item)
        if (diff != 0) return diff
    }

    return if (against.size == 1) 0 else recursiveCheck(against.first(), against.subList(1, against.size))
}

fun evenlyDividedDistance(a: Int, b: Int): Int {
    if (a != b && a.rem(b) == 0) {
        return b - a
    }
    return 0
}

fun parseInput(): List<List<Int>> =
        File("/Users/bororo/Development/kotlin-study/advent-of-code-2017/src/input.txt")
                .readLines()
                .map { line ->
                    line.trim()
                            .split("\t")
                            .map {
                                it.toInt()
                            }
                }