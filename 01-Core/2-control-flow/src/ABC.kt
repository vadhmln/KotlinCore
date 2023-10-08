package control_flow

val testString = mutableListOf(
    mutableListOf("lhffafgjvp"),
    mutableListOf("abnzddkfmm"),
    mutableListOf("bcfgpzgwet"),
    mutableListOf("edehhymzie"),
    mutableListOf("zkjijmnynq"),
    mutableListOf("wuuvkloxwv"),
    mutableListOf("iuyvpxpqpu"),
    mutableListOf("yswtxmfrst"),
    mutableListOf("pwxcfyrmum"),
    mutableListOf("bojdaeiqku")
)

val test0String = mutableListOf(
    mutableListOf("lhffafgjvp"),
    mutableListOf("adnzddkfmm"),
    mutableListOf("bcfgpzgwet"),
    mutableListOf("edehhymzie"),
    mutableListOf("zkjijmnynq"),
    mutableListOf("wuuvkloxwv"),
    mutableListOf("iuyvpxpqpu"),
    mutableListOf("yswtxmfrst"),
    mutableListOf("pwxcfyrmum"),
    mutableListOf("bojdaeiqku")
)

val test1String = mutableListOf(
    mutableListOf("vkbjbzmbgb"),
    mutableListOf("abcccpzouv"),
    mutableListOf("fedopwlmcl"),
    mutableListOf("glmnqrszyw"),
    mutableListOf("hkrhiutymj"),
    mutableListOf("ijqcmvwxoc"),
    mutableListOf("pcvlpqzphl"),
    mutableListOf("hsgvoklcxy"),
    mutableListOf("urdjusmbmz"),
    mutableListOf("rchbcausnp")
)

val test2String = mutableListOf(
    mutableListOf("xoikvoybwhvhkqs"),
    mutableListOf("abcdpjzteanhnot"),
    mutableListOf("wonezupfvoeetfc"),
    mutableListOf("qpmfxfndfiqafpb"),
    mutableListOf("rklgqyyltzvnugs"),
    mutableListOf("sjihujprijqzvap"),
    mutableListOf("tsoxsaoraruyqwk"),
    mutableListOf("uwwonqolepmuqyy"),
    mutableListOf("vwxwksnuizgbiht"),
    mutableListOf("feyihffuvkbrfjw"),
    mutableListOf("eezqukiqyzqjies"),
    mutableListOf("uarhhcdjvpfwvck"),
    mutableListOf("drtgqmroaaumyaq"),
    mutableListOf("cbntlwlibaavsdc"),
    mutableListOf("jpvogyiibfawjbn"),
)

val test3String = mutableListOf(
    mutableListOf("qrnwxqufaqpmehg"),
    mutableListOf("gqpsdpeqovfjtbv"),
    mutableListOf("azdizzjbedhsyzt"),
    mutableListOf("mzbegprlfcbaxwv"),
    mutableListOf("hoibquzhgbdrggu"),
    mutableListOf("gynohfmijkdgpqt"),
    mutableListOf("lwemjvulqlmnors"),
    mutableListOf("eckkhvwucrblxwc"),
    mutableListOf("hxunydbmsxdmpkh"),
    mutableListOf("drdzvbronvfjlwz"),
    mutableListOf("npnjnjqkfvupezb"),
    mutableListOf("hvdaqvyrwhdtxbb"),
    mutableListOf("nfpgaffyuefppae"),
    mutableListOf("forhbqkezipkinq"),
    mutableListOf("usxszgnwvwndzrl"),
)

val test4String = mutableListOf(
    mutableListOf("cbatksajbfggzscxlwss"),
    mutableListOf("avotuqnvgvmnghnwchnu"),
    mutableListOf("aceglpwkcwyxqnjxetag"),
    mutableListOf("ilddvpjguotxrnvkznkc"),
    mutableListOf("wnbquhpzgpjjvaxblckl"),
    mutableListOf("blyccpjqkwosrjvcouyt"),
    mutableListOf("dlattqnvvgawdkcyhbhx"),
    mutableListOf("alvpqxspvbeizbxaubby"),
    mutableListOf("xtvxhvgfjiiffcynzfdo"),
    mutableListOf("xlroyrcwaydggabiodrq"),
    mutableListOf("hydaxaveuuextqzcgewo"),
    mutableListOf("dcvbvqmsvebmbghclgbs"),
    mutableListOf("izpesrsutapzuvrapkzg"),
    mutableListOf("ratpfqwmokaujqhihdei"),
    mutableListOf("jaabcvxvwpwozvoiwvya"),
    mutableListOf("pdnedstuxrbxjuqnqfat"),
    mutableListOf("xhgfqrezyiabcrupxwpi"),
    mutableListOf("dijopgmxgezbgnyhwzih"),
    mutableListOf("ceknitwldqjbxdgnbgbu"),
    mutableListOf("yllmerzjxqjzrqlwfjwi"),
)

val stringArray2d = mutableListOf<MutableList<String>>()
var alphaBet = "abcdefghijklmnopqrstuvwxyz0"
val answer = mutableListOf<MutableList<String>>()

fun initializeAnswer() {
    for (row in answer.indices) {
        for (item in answer[row].indices) {
            answer[row][item] = "-"
        }
    }
}

fun main() {
    var firstString: String
    var nextString: String
    var isNotA = true
    var prevRowIndex = 0
    var prevItemIndex = 0
    var matchedItemRowIndex = 0
    var matchedItemItemIndex = 0

    for (row in test0String.indices) {
        for (item in test0String[row].indices) {
            stringArray2d.add(test0String[row][item].split("").drop(1).dropLast(1).toMutableList())
        }
    }

    for (row in test0String.indices) {
        for (item in test0String[row].indices) {
            answer.add(test0String[row][item].split("").drop(1).dropLast(1).toMutableList())
        }
    }

    initializeAnswer()

    for ((rowIndex, value) in stringArray2d.withIndex()) {
        for ((itemIndex, itemValue) in stringArray2d[rowIndex].withIndex()) {
            println("Loop ($rowIndex, $itemIndex)")
            println("stringArray2d.size ${stringArray2d.size}")
            println("stringArray2d.lastIndex ${stringArray2d.lastIndex}")
            val previewsItem = stringArray2d[prevRowIndex][prevItemIndex]
            val previewsRowIndex = prevRowIndex
            val previewsItemIndex = prevItemIndex
            prevRowIndex = rowIndex
            prevItemIndex = itemIndex

            val upOfCurrentItem = if (rowIndex == 0 && itemIndex in (0..stringArray2d.lastIndex))
                stringArray2d[rowIndex][itemIndex]
            else
                stringArray2d[rowIndex - 1][itemIndex]
            val leftOfCurrentItem = if (rowIndex in (0..stringArray2d.lastIndex) && itemIndex == 0)
                stringArray2d[rowIndex][itemIndex]
            else
                stringArray2d[rowIndex][itemIndex - 1]
            val rightOfCurrentItem =
                if (rowIndex in (0..stringArray2d.lastIndex) && itemIndex == stringArray2d.lastIndex)
                    stringArray2d[rowIndex][itemIndex]
                else
                    stringArray2d[rowIndex][itemIndex + 1]
            val downOfCurrentItem =
                if (rowIndex == stringArray2d.lastIndex && itemIndex in (0..stringArray2d.lastIndex))
                    stringArray2d[rowIndex][itemIndex]
                else
                    stringArray2d[rowIndex + 1][itemIndex]

            val upOfMatchedItem = if (matchedItemRowIndex == 0 && matchedItemItemIndex in (0..stringArray2d.lastIndex))
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
            else
                stringArray2d[matchedItemRowIndex - 1][matchedItemItemIndex]
            val leftOfMatchedItem = if (matchedItemRowIndex in (0..stringArray2d.lastIndex) && matchedItemItemIndex == 0)
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
            else
                stringArray2d[matchedItemRowIndex][matchedItemItemIndex - 1]
            val rightOfMatchedItem =
                if (matchedItemRowIndex in (0..stringArray2d.lastIndex) && matchedItemItemIndex == stringArray2d.lastIndex)
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
                else
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex + 1]
            val downOfMatchedItem =
                if (matchedItemRowIndex == stringArray2d.lastIndex && matchedItemItemIndex in (0..stringArray2d.lastIndex))
                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
                else
                    stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex]

//            val upOfUpOfMatchedItem =
//                if (matchedItemRowIndex <= 0 && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex - 2][matchedItemItemIndex]
//            val rightOfUpOfMatchedItem =
//                if (matchedItemRowIndex <= 0 && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex + 1]
//            val leftOfUpOfMatchedItem =
//                if (matchedItemRowIndex <= 0 && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex - 1][matchedItemItemIndex - 1]
//
//            println("leftOfLeftOfMatchedItem!!!")
//            val leftOfLeftOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex <= 0) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex][matchedItemItemIndex - 2]
//            val upOfLeftOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex <= 0) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex - 1][matchedItemItemIndex - 1]
//            val downOfLeftOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex <= 0) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex - 1]
//            println("rightOfRightOfMatchedItem!!!")
//            val rightOfRightOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex >= stringArray2d.lastIndex) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex][matchedItemItemIndex + 2]
//            println("downOfRightOfMatchedItem!!!")
//            val downOfRightOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex >= stringArray2d.lastIndex) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex + 1]
//            println("upOfRightOfMatchedItem!!!")
//            val upOfRightOfMatchedItem =
//                if (matchedItemRowIndex in (0..stringArray2d.size) && matchedItemItemIndex <= stringArray2d.lastIndex) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex - 2][matchedItemItemIndex + 1]
//            println("downOfDownOfMatchedItem!!!")
//            val downOfDownOfMatchedItem =
//                if (matchedItemRowIndex >= stringArray2d.lastIndex && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 2][matchedItemItemIndex]
//            val rightOfDownOfMatchedItem =
//                if (matchedItemRowIndex >= stringArray2d.lastIndex && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex + 1]
//            val leftOfDownOfMatchedItem =
//                if (matchedItemRowIndex >= stringArray2d.lastIndex && matchedItemItemIndex in (0..stringArray2d.size)) {
//                    stringArray2d[matchedItemRowIndex][matchedItemItemIndex]
//                } else stringArray2d[matchedItemRowIndex + 1][matchedItemItemIndex - 1]


            if (alphaBet.first().toString() == "0") {
                break
            }

            firstString = alphaBet.first().toString()
            nextString = alphaBet[1].toString()

            if (isNotA) {
                println("isNotA!!!")
                if (itemValue == firstString && upOfCurrentItem == nextString ||
                    itemValue == firstString && downOfCurrentItem == nextString ||
                    itemValue == firstString && leftOfCurrentItem == nextString ||
                    itemValue == firstString && rightOfCurrentItem == nextString
                ) {
                    println("isA!!!")
                    answer[rowIndex][itemIndex] = itemValue
                    alphaBet = alphaBet.drop(1)
                    isNotA = false
                    matchedItemRowIndex = rowIndex
                    matchedItemItemIndex = itemIndex
                }
            } else if (
                upOfMatchedItem == firstString ||
                rightOfMatchedItem == firstString ||
                downOfMatchedItem == firstString ||
                leftOfMatchedItem == firstString
            ) {
                println("main if!!!")
                if (leftOfMatchedItem == firstString) {
                    if (matchedItemItemIndex == 0) {
                        println("3 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        println("4 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex - 1] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemItemIndex -= 1
                    }
                } else if (downOfMatchedItem == firstString) {
                    if (previewsRowIndex == stringArray2d.lastIndex) {
                        println("7 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        println("8 if!!!")
                        answer[matchedItemRowIndex + 1][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemRowIndex += 1
                    }
                } else if (rightOfMatchedItem == firstString) {
                    if (previewsItemIndex == stringArray2d.lastIndex) {
                        println("5 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        println("6 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex + 1] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemItemIndex += 1
                    }
                } else if (upOfMatchedItem == firstString) {
                    if (previewsRowIndex == 0) {
                        println("1 if!!!")
                        answer[matchedItemRowIndex][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                    } else {
                        println("2 if!!!")
                        answer[matchedItemRowIndex - 1][matchedItemItemIndex] = firstString
                        alphaBet = alphaBet.drop(1)
                        matchedItemRowIndex -= 1
                    }
                }
            } else {
                println("Next A!!!")
                isNotA = true
                alphaBet = "abcdefghijklmnopqrstuvwxyz0"
                initializeAnswer()
            }

            println("Matched Item ($matchedItemRowIndex, $matchedItemItemIndex)")
            println("Current Item $itemValue")
            println("First String $firstString")
            println("Next String $nextString")
            println("UpOfMatchedItem item = $upOfMatchedItem")
            println("LeftOfMatchedItem item = $leftOfMatchedItem")
            println("RightOfMatchedItem item = $rightOfMatchedItem")
            println("DownOfMatchedItem item = $downOfMatchedItem")
            println("UpOfCurrentItem item = $upOfCurrentItem")
            println("LeftOfCurrentItem item = $leftOfCurrentItem")
            println("RightOfCurrentItem item = $rightOfCurrentItem")
            println("DownOfCurrentItem item = $downOfCurrentItem")
//            println("UpOfUpOfMatchedItem item = $upOfUpOfMatchedItem")
//            println("LeftOfLeftOfMatchedItem item = $leftOfLeftOfMatchedItem")
//            println("RightOfRightOfMatchedItem item = $rightOfRightOfMatchedItem")
//            println("DownOfDownOfMatchedItem item = $downOfDownOfMatchedItem")

            for (row in answer) {
                for (item in row) {
                    print(item)
                }
                println()
            }
        }
    }
}

