@file:Suppress("UNREACHABLE_CODE")

package control_flow

import java.util.*

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val random = Random()
    var isGameOn = true

    // game loop
    while (isGameOn) {
        var highestMountain = 0
        var highestMountainIndex = 0

//        for (i in 0 until 8) {
//            val mountainH = random.nextInt(8)
//
//            if (mountainH > highestMountain) {
//                highestMountainIndex = i
//                highestMountain = mountainH
//            }
//            if (i == 7) {
//                isGameOn = false
//            }
//
//        }

        val index = (0 until 8).maxBy { random.nextInt(8) }
        if (index == 7) {
            isGameOn = false
        }

        println("maxBy = $index")

//        println(highestMountainIndex)
    }

    //next solution
    while (isGameOn) {
        val index = (0 until 8).maxBy { random.nextInt(8) }

        println("maxBy = $index")
    }

    //next
    data class Mountain(val index: Int, val height: Int)
    while (true) {

        val mountains = (0 until 8).map { Mountain(it, input.nextInt()) }.sortedByDescending { it.height }
        println(mountains.first().index)

    }

    //next
    while (true) {
        val heights = mutableListOf<Int>()
        for (i in 0..7) {
            heights.add(input.nextInt()) // represents the height of one mountain.
        }

        println(heights.indexOf(heights.max()))
    }

    //next
    while (true)
        println((0..7).maxBy { input.nextInt() })

    //next
    while (true) {
        val mountains = List(8) {input.nextInt()}
        val highest = mountains.max()
        val index = mountains.indexOf(highest)
        println(index)

    }

    //next
    while (true) {
        val mountains = IntArray(8) { input.nextInt() }
        println(mountains.indexOf(mountains.max()))
    }

    //next
    while (true) {
        val arr = Array(8, {0})
        for (i in 0 until 8) {
            arr[i] = input.nextInt()
        }
        println(arr.indices.maxBy{arr[it]})
    }
}