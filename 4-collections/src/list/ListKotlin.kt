package list

import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap
import kotlin.collections.LinkedHashSet

fun main() {
    //неизменяемый список (нельзя добавлять новые элементы, после инициализации)
    val list = listOf("Tea", "Coffee")
    val setArray = setOf(1, 2)
    val mapArray = mapOf("key1" to 1, "key2" to 2)
    val nonNulls = listOfNotNull("a", null, "b", "c")

    //при создании пустой коллекции - ее тип указывается явно
    val listEmpty = listOf<String>()
    val setArrayEmpty = setOf<Int>()
    val mapArrayEmpty = mapOf<String, Int>()
    val emptyList = emptyList<String>()
    val emptySet = emptySet<Int>()
    val emptyMap = emptyMap<String, Int>()

    //изменяемый список (можно добавлять новые элементы, после инициализации)
    val mutableList = mutableListOf("Tea", "Coffee")
    val mutableSet = mutableSetOf(3, 4)
    val mutableMap = mutableMapOf("key1" to 1, "key2" to 2)
    val arrayList = arrayListOf(45, 32, 2)

    //при создании пустой коллекции - ее тип указывается явно
    val mutableListEmpty = mutableListOf<String>()
    val mutableSetEmpty = mutableSetOf<Int>()
    val mutableMapEmpty = mutableMapOf<String, Int>()
    val arrayListEmpty = arrayListOf<Int>()

    //Функция-инициализатор для списков
    val listConstructor = List(3, { it + 1 })
    val mutableListConstructor = MutableList(10, { it * 1 })

    //Конструкторы конкретных типов
    val arrayListConstructor = ArrayList<String>()
    val linkedList = LinkedList<String>()
    val linkedHashSetConstructor = LinkedHashSet<Int>()
    val hashSetConstructor = HashSet<String>()
    val linkedHashMapConstructor = LinkedHashMap<String, Int>()
    val hashMapConstructor = HashMap<String, Int>()
    
    //инициализация ArrayList неизменяемым списком = изменяемый
    val arrayListConstructorNuance = ArrayList<String>(listOf("1", "2"))
    arrayListConstructorNuance.add("3")
    println(arrayListConstructorNuance) // [1, 2, 3]


    //asReversed()
    val names = listOf("Tom", "Ben", "Nick", "Anna")
//    println(names.asReversed()) // [Anna, Nick, Ben, Tom]

    //
    val planets = listOf(
        Planet("Mercury", 57910000),
        Planet("Venus", 108200000),
        Planet("Earth", 149600000),
        Planet("Mars", 227940000),
        Planet("Jupiter", 778330000),
        Planet("Saturn", 1424600000),
        Planet("Uranus", 2873550000),
        Planet("Neptune", 4501000000),
        Planet("Pluto", 5945900000)
    )
    planets.zip(arrayOf(4800, 12100, 12750, 6800, 142800, 120660, 51800, 49500, 3300)).forEach {
        val (planet, diameter) = it
//        println("${planet.name}'s diameter is $diameter km")
    }

    //foldRight
    val reversePlanetName = planets.foldRight(StringBuilder()) { planet, builder ->
        builder.append(planet.name)
        builder.append(";")
    }
//    println(reversePlanetName)

    //
    val amount = listOf(
        ShoppingItem("1", "Intel i7-950 Quad-Core Processor", BigDecimal("319.76"), 1),
        ShoppingItem("2", "Samsung 750 EVO 250 GB 2.5 inch SDD", BigDecimal("71.21"), 1)
    )
        .foldRight(BigDecimal.ZERO) { item, total ->
            total + BigDecimal(item.quantity) * item.price
        }
//    println(amount) //390.97

    //преобразовать список в другой тип
    val chars = listOf('a', 'd', 'c', 'd', 'a')
    val array = chars.toTypedArray()
    val arrayBetter = chars.toCharArray()
    val set = chars.toSet() //[a,d,c]
    val charsMutable = chars.toMutableList()

    //конвертировать другие коллекции в списки
    val arrayFilter = arrayOf(1, 2, 3, 4)
    arrayFilter.toList()
    arrayFilter.toMutableList()
    arrayFilter.toSet()
    arrayFilter.toMutableSet()
    arrayFilter.toSortedSet()

    //Доступ к элементам - Использование свойств и методов
    val players = mutableListOf("Alice", "Bob", "Cindy", "Dan")
//    print(players.isEmpty()) // false
    if (players.size < 2) {
        println("We need at least two players!")
    } else {
//        println("Let's start!")
    }
    var currentPlayer = players.first()
//    println(currentPlayer) // > Alice
//    println(players.last()) // > Dan
    val minPlayer = players.minOrNull()
    minPlayer.let {
//        println("$minPlayer will start") // > Alice will start
    }
    val maxPlayer = players.maxOrNull()
    if (maxPlayer != null) {
//        println("$maxPlayer is the MAX") // > Dan is the MAX
    }
    val upcomingPlayersSlice = players.slice(1..2)
//    println(upcomingPlayersSlice.joinToString()) // > Bob, Cindy
    players.slice(1..3).contains("Alice") // false
    players.add("Eli")
    players += "Gina"
    players.add(5, "Frank")
    val wasPlayerRemoved = players.remove("Gina")
//    println("It is $wasPlayerRemoved that Gina was removed") // > It is true that Gina was removed
    val removedPlayer = players.removeAt(2)
//    println("$removedPlayer was removed") // > Cindy was removed
    val indexOfDan = players.indexOf("Dan")
//    println(players.joinToString())
//    println(indexOfDan) // 2
    players[4] = "Franklin"
//    println(players.joinToString()) // Alice, Bob, Dan, Eli, Franklin
    players[3] = "Anna"
    players.sort()
//    println(players.joinToString()) // > "Alice", "Anna", Bob", "Dan", "Franklin"
    val scores = listOf(2, 2, 8, 6, 1)
    for (player in players) {
//        println(player)
    }
    for ((index, player) in players.withIndex()) {
        print("${index + 1}. $player ") // 1. Alice 2. Anna 3. Bob 4. Dan 5. Franklin
    }
//    println(sumOfElements(scores)) // 19
//    println(scores.sum()) // 19
    var nullableList: List<Int>? = listOf(1, 2, 3, 4)
    nullableList = null
    var listOfNullables: List<Int?> = listOf(1, 2, null, 4)
//    listOfNullables = null // Error: Null can not be a value of a non-null type
    var nullableListOfNullables: List<Int?>? = listOf(1, 2, null, 4)
    nullableListOfNullables = null


}

fun sumOfElements(list: List<Int>): Int {
    var sum = 0
    for (number in list) {
        sum += number
    }
    return sum
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) { //цикл по всем элементам исходной коллекции
        target.add(item)     //добавляем элемент в изменяемую целевую коллекцию
    }
}

data class Planet(val name: String, val distance: Long)
data class ShoppingItem(val id: String, val name: String, val price: BigDecimal, val quantity: Int)
