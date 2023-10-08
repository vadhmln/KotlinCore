package control_flow

import java.util.*
import kotlin.math.abs

/*
 *Write a program that prints the temperature closest to 0 among input data. If two numbers are equally close
 * to zero, positive integer has to be considered closest to zero (for instance, if the temperatures are -5 and 5,
 * then display 5).
 */

val input = Scanner(System.`in`)
fun main(args: Array<String>) {
    val n = input.nextInt() // the number of temperatures to analyse
    var temperatureClosestTo0 = 5530

    val temperatureTo0 = if (n != 0) {
        (0 until n).map { input.nextInt() }.minBy { abs(it - 1) }
    } else 0


//    for (i in 0 until n) {
//        var t = input.nextInt() // a temperature expressed as an integer ranging from -273 to 5526
//
//        if (abs(t) < abs(temperatureClosestTo0)) {
//            temperatureClosestTo0 = t
//        } else if (abs(t) == abs(temperatureClosestTo0) && t > temperatureClosestTo0) {
//            temperatureClosestTo0 = t
//        }
//    }


//    if (n == 0) {
//        println(0)
//    } else println(temperatureClosestTo0)

//        if (n == 0) {
//        println(0)
//    } else println(temp)

    println(temperatureTo0)

    //next
//    println(
//        Array(input.nextInt()) { input.nextInt() }
//            .minWith(compareBy{it*(it-1)})?:0
//    )

    //next
    readlnOrNull()
    println(readln()
        .split(" ")
        .filter(String::isNotEmpty)
        .map(String::toInt)
        .sorted()
        .reversed()
        .minBy { abs(it) } ?: 0)

    //next
    val temperature0 = if (n != 0) {
        (0 until n).map { input.nextInt() }.minBy { abs(it - 1) }
    } else 0

    println(temperature0)

}

// next solution
//fun main(args: Array<String>) = println(
//    (0 until input.nextInt())
//        .map { input.nextInt() }
//        .minBy { abs(it - 1) } ?: 0
//)