package list

fun main() {

    //Collection transformation operations:

    // map - преобразовать исходную коллекцию путём применения заданной
    // лямбда-функции к каждому её элементу, объединяя результаты в новую коллекцию
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 }) // [3, 6, 9]
    println(numbers.mapIndexed { idx, value -> value * idx }) // [0, 2, 6]
    println(numbers) // исходная коллекция сохраняется [1, 2, 3]

    // mapNotNull() - Если какой-либо элемент или элементы могут быть преобразованы в значение равное null
    val numbersNotNull = setOf(1, 2, 3)
    println(numbersNotNull.mapNotNull {
        if (it == 2) null else it * 3
    }) // [3, 9]
    println(numbersNotNull.mapIndexedNotNull { idx, value ->
        if (idx == 0) null else value * idx
    }) // [2, 6]
    println(numbersNotNull.mapNotNull {
        if (it == 3) null else it
    }) // [1, 2]

    // mapKeys() - преобразует ключи
    // mapValues() - преобразует значения
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() }) // {KEY1=1, KEY2=2, KEY3=3, KEY11=11}
    println(numbersMap.mapValues { it.value + it.key.length }) // {key1=5, key2=6, key3=7, key11=16}
    println(numbersMap) // {key1=1, key2=2, key3=3, key11=11}

    // zip() - берёт два списка и создаёт из их элементов пары
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    val twoAnimals = listOf("fox", "bear")
    // Если коллекции имеют разные размеры, то zip() вернёт новую коллекцию, длина которой равняется
    // минимальной из исходных коллекций; последние элементы большей коллекции будут отсечены.
    println(colors.zip(twoAnimals)) // [(red, fox), (brown, bear)]
    //Также zip() можно вызывать в инфиксной форме a zip b
    println(colors zip animals) // [(red, fox), (brown, bear), (grey, wolf)]
    val myZip = colors zip animals
    println("My Zip!!! = ${myZip.mapNotNull { 
        if (it.first == "red" && it.second == "fox") null else it
    }}")

    /*
     Вместе с коллекцией zip() можно передать функцию преобразования, которая принимает два параметра:
     элемент коллекции-получателя и элемент коллекции-аргумента, при этом оба элемента располагаются в
     своих коллекциях по одинаковому индексу. В этом случае вернётся List с содержимым из результатов
     вычисления функции преобразования.
     */
    println(colors.zip(animals) { color, animal ->
        "The ${animal.replaceFirstChar { it.uppercase() }} is $color"
    }) // [The Fox is red, The Bear is brown, The Wolf is grey]

    // unzip() - разбирает пары на два отдельных списка:
    //В первый список помещаются первые элементы каждого объекта Pair
    //Во второй список помещаются вторые элементы каждого объекта Pair
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip()) // ([one, two, three, four], [1, 2, 3, 4])

    // associateWith() - создаёт Map, в которой элементы исходной коллекции являются ключами, а значения
    // вычисляются с помощью функции преобразования. Если встречаются два равных элемента, то в ассоциативный
    // список попадёт только последний из них.
    val numbersMapOfTwo = listOf("one", "two", "three", "four")
    println(numbersMapOfTwo.associateWith { it.length }) // {one=3, two=3, three=5, four=4}

    // associateBy() - создания ассоциативного списка, в котором элементы коллекции будут выступать в роли значений
    // Также associateBy() можно вызвать с функцией, преобразующей значения.
    println(numbersMapOfTwo.associateBy { it.first().uppercaseChar() }) // {O=one, T=three, F=four}
    println(numbersMapOfTwo.associateBy(
        keySelector = { it.first().uppercaseChar() },
        valueTransform = { it.length }
    )) // {O=3, T=5, F=4}

    // associate() - ключи и значения тем или иным образом создаются на основе элементов коллекции.
    // Принимает лямбда-функцию, которая возвращает объект Pair. Этот объект и представляет собой пару "ключ-значение"
    /*
       Обратите внимание, что associate() создаёт недолговечные объекты Pair, которые могут повлиять на
       производительность. Поэтому используйте associate() только тогда, когда производительность для вас не критична,
       либо если эта функция предпочтительнее остальных. Примером последнего является ситуация, когда ключ и значение
       для него создаются одновременно на основе элемента.
     */
    data class FullName (val firstName: String, val lastName: String)

    fun parseFullName(fullName: String): FullName {
        val nameParts = fullName.split(" ")
        if (nameParts.size == 2) {
            return FullName(nameParts[0], nameParts[1])
        } else throw Exception("Wrong name format")
    }

    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name ->
        parseFullName(name).let { it.lastName to it.firstName }
    }) // {Adams=Alice, Brown=Brian, Campbell=Clara}
    //В примере выше сначала вызывается функция преобразования элемента, а затем происходит создание
    // пары на основе полученного от этой функции результата.

    // flatten() - возвращает объединённый List, состоящий из всех элементов всех вложенных коллекций
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten()) // [1, 2, 3, 4, 5, 6, 1, 2]

    // flatMap() - возвращает объединённый список из всех обработанных элементов.
    // По сути flatMap() ведёт себя как вызов map()
    // (с возвращением коллекции в качестве результата маппинга) и flatten()
    data class StringContainer(val values: List<String>)
    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values }) // [one, two, three, four, five, six, seven, eight]

    // joinToString() - на основе предоставленных аргументов объединяет элементы коллекции в строку.
    // joinTo() -  делает то же самое, но добавляет результат к переданному объекту Appendable
    val numbersToString = listOf("one", "two", "three", "four")

    println(numbersToString) // [one, two, three, four]
    println(numbersToString.joinToString()) // one, two, three, four

    val listString = StringBuffer("The list of numbers: ")
    numbersToString.joinTo(listString)
    println(listString) // The list of numbers: one, two, three, four

    /*
       Можете кастомизировать строковое представление коллекции, указав необходимые вам параметры
       при помощи специальных аргументов - separator, prefix, и postfix. Преобразованная строка будет
       начинаться с префикса (prefix) и заканчиваться постфиксом (postfix). А separator будет добавлен
       после каждого элемента, кроме последнего
     */
    val numbersCustom = listOf("one", "two", "three", "four")
    println(numbersCustom.joinToString(
        separator = " | ",
        prefix = "start: ",
        postfix = ": end"
    )) // start: one | two | three | four: end

    /*
      Если коллекция большая, то вы можете указать limit - количество элементов, которые будут включены в результат.
      При этом все элементы, превышающие limit, будут заменены одним значением аргумента truncated
     */
    val numbersBigList = (1..100).toList()
    println(numbersBigList.joinToString(
        limit = 10,
        truncated = "<...>")
    ) // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, <...>

    // чтобы кастомизировать представление самих элементов, передайте в качестве аргумента функцию transform
    val numbersForm = listOf("one", "two", "three", "four")
    println(numbersForm.joinToString {
        "Element: ${it.uppercase()}"
    }) // Element: ONE, Element: TWO, Element: THREE, Element: FOUR












}