package array

import java.util.*
import java.io.*
import java.math.*

fun main(args : Array<String>) {
    val input = Scanner(System.`in`)
    val n = input.nextInt()
    val stringArray2d = mutableListOf<MutableList<String>>()
    var alphaBet = "abcdefghijklmnopqrstuvwxyz0"
    val answer = mutableListOf<MutableList<String>>()
    val rowList = mutableListOf<String>()
    var firstString: String
    var nextString: String
    var isNotA = true
    var prevRowIndex = 0
    var prevItemIndex = 0
    var matchedItemRowIndex = 0
    var matchedItemItemIndex = 0

    for (i in 0 until n) {
        rowList.add(input.next())
    }

    for (row in rowList.indices) {
        stringArray2d.add(rowList[row].split("").drop(1).dropLast(1).toMutableList())
    }

    for (row in stringArray2d.indices) {
        answer.add(rowList[row].split("").drop(1).dropLast(1).toMutableList())
    }

    for (row in answer.indices) {
        for (item in answer[row].indices) {
            answer[row][item] = "-"
        }
    }

    for ((rowIndex, value) in stringArray2d.withIndex()) {
        for ((itemIndex, itemValue) in stringArray2d[rowIndex].withIndex()) {
            val previewsRowIndex = prevRowIndex
            val previewsItemIndex = prevItemIndex
            prevRowIndex = rowIndex
            prevItemIndex = itemIndex

            val upOfCurrentItem = if (rowIndex == 0 && itemIndex in (0..stringArray2d.size))
                stringArray2d[rowIndex][itemIndex]
            else
                stringArray2d[rowIndex - 1][itemIndex]
            val leftOfCurrentItem = if (rowIndex in (0..stringArray2d.size) && itemIndex == 0)
                stringArray2d[rowIndex][itemIndex]
            else
                stringArray2d[rowIndex][itemIndex - 1]
            val rightOfCurrentItem =
                if (rowIndex in (0..stringArray2d.size) && itemIndex == stringArray2d.lastIndex)
                    stringArray2d[rowIndex][itemIndex]
                else
                    stringArray2d[rowIndex][itemIndex + 1]
            val downOfCurrentItem =
                if (rowIndex == stringArray2d.lastIndex && itemIndex in (0..stringArray2d.size))
                    stringArray2d[rowIndex][itemIndex]
                else
                    stringArray2d[rowIndex + 1][itemIndex]

            val upOfMatchedItem = if (matchedItemRowIndex == 0 && matchedItemItemIndex in (0..stringArray2d.size))
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
            else
                stringArray2d[matchedItemRowIndex - 1][matchedItemItemIndex]
            val leftOfMatchedItem = if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex == 0)
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
            else
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex - 1]
            val rightOfMatchedItem =
                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex == stringArray2d.lastIndex)
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
                else
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex + 1]
            val downOfMatchedItem =
                if (matchedItemRowIndex == stringArray2d.lastIndex && matchedItemItemIndex in (0..stringArray2d.size))
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
                else
                    stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex]

            if (alphaBet.first().toString() == "0") {
                break
            }

            firstString = alphaBet.first().toString()
            nextString = alphaBet[1].toString()

            if (isNotA) {
                if (itemValue == firstString && upOfCurrentItem == nextString ||
                    itemValue == firstString && downOfCurrentItem == nextString ||
                    itemValue == firstString && leftOfCurrentItem == nextString ||
                    itemValue == firstString && rightOfCurrentItem == nextString
                ) {
                    answer[rowIndex][itemIndex] = itemValue
                    alphaBet = alphaBet.drop(1)
                    isNotA = false
                    matchedItemRowIndex = rowIndex
                    matchedItemItemIndex = itemIndex
                }
            } else if (upOfMatchedItem == firstString ||
                downOfMatchedItem == firstString ||
                leftOfMatchedItem == firstString ||
                rightOfMatchedItem == firstString
            ) {
                if (downOfMatchedItem == firstString) {
                    if (previewsRowIndex == stringArray2d.lastIndex) {
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        answer[matchedItemRowIndex + 1][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemRowIndex += 1
                    }
                } else if (rightOfMatchedItem == firstString) {
                    if (previewsItemIndex == stringArray2d.lastIndex) {
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        answer[matchedItemRowIndex][matchedItemItemIndex + 1] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemItemIndex += 1
                    }
                } else if (leftOfMatchedItem == firstString) {
                    if (matchedItemItemIndex == 0) {
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        answer[matchedItemRowIndex][matchedItemItemIndex - 1] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemItemIndex -= 1
                    }
                } else if (upOfMatchedItem == firstString) {
                    if (previewsRowIndex == 0) {
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        answer[matchedItemRowIndex - 1][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemRowIndex -= 1
                    }
                }
            } else {
                isNotA = true
                alphaBet = "abcdefghijklmnopqrstuvwxyz0"
                for (row in answer.indices) {
                    for (item in answer[row].indices) {
                        answer[row][item] = "-"
                    }
                }
            }


        }
    }

    for (row in answer) {
        for (item in row) {
            print(item)
        }
        println()
    }
}