package stzifa

import java.io.File

class Day2KotlinProject {

    fun solve1(): Int{

        return File("C://XMProjects/Dev/KotlinProject/src/main/resources/input.txt").readLines()
                .map { it.split("\t").map { it.toInt() } }
                .sumBy { it.max()!! - it.min()!! }
    }

    fun solve2(): Int{

        return File("C://XMProjects/Dev/KotlinProject/src/main/resources/input.txt").readLines()
                .map { it.split("\t").map { it.toInt() }}
                .map{executeDifferences(it)}
                .sum()

    }

    fun executeDifferences(list: List<Int>): Int{

        list.sorted().forEach { listElement ->
            (list.sorted().asReversed().forEach { listElementReversed ->(
                    if (listElementReversed != 0 && listElement % listElementReversed == 0 && listElement!= listElementReversed)
                        return listElement.div(listElementReversed)
                    )
            })}

        return 0
    }

}

fun main(args: Array<String>){

//    var sum = Day2KotlinProject().solve1()
//    println(sum)

    var summary = Day2KotlinProject().solve2()
    println(summary)

}