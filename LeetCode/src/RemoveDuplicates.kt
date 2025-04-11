fun main() {
    val numbers = intArrayOf(1, 1, 1, 2, 2, 2)

//    fun removeDuplicates(nums: IntArray): Int {
//        if (nums.isEmpty()) return 0
//
//        var writePointer = 1  // указатель для записи уникальных элементов
//
//        // проходим по массиву, начиная со второго элемента
//        for (readPointer in 1 until nums.size) {
//            // если текущий элемент отличается от предыдущего
//            if (nums[readPointer] != nums[readPointer - 1]) {
//                // копируем его в позицию writePointer
//                nums[writePointer] = nums[readPointer]
//                writePointer++
//            }
//        }
//
//        return writePointer // возвращаем количество уникальных элементов
//    }

//    fun removeDuplicates(nums: IntArray): Int {
//        var writePointer = 1
//        var countOfCurrentNumber = 1
//
//        for (readPointer in 1 until nums.size) {
//            if (nums[readPointer] == nums[readPointer - 1]) {
//                countOfCurrentNumber++
//                if (countOfCurrentNumber <= 2) {
//                    nums[writePointer] = nums[readPointer]
//                    writePointer++
//                } else continue
//            } else if (nums[readPointer] != nums[readPointer - 1]) {
//                countOfCurrentNumber = 1
//                nums[writePointer] = nums[readPointer]
//                writePointer++
//            }
//        }
//
//        return writePointer
//    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var writePointer = 2 // начинаем с индекса 2
        for (readPointer in 2 until nums.size) {
            if (nums[writePointer - 2] != nums[readPointer]) {
                nums[writePointer++] = nums[readPointer]
            }
        }
        return writePointer
    }

    val uniqueCount = removeDuplicates(numbers)

    println("Количество уникальных элементов: $uniqueCount")
    println("Массив до удаления дубликатов: ${numbers.joinToString()}")
    println("Массив после удаления дубликатов: ${numbers.take(uniqueCount)}")
}
