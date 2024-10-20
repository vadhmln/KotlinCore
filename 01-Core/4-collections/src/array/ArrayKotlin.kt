package array

fun main() {
    //library functions - declaration and initialization
    //таким образом можно создать массив любого типа
    val intsArray = arrayOf(3, 4, 5, 6, 8)
    val shortsArray: Array<Short> = arrayOf(3, 4, 5, 6, 8)
    val bytesArray: Array<Byte> = arrayOf(3, 4, 5, 6, 8)
    val longsArray = arrayOf(1100000004789, 11000000049909, 1100000004089)
    val doublesArray = arrayOf(3.3, 4.1, 6.0)
    val floatsArray = arrayOf(3.3f, 4.1f, 6.0f)
    val stringsArray = arrayOf("Dog", "Cat", "Mouse")
    val charsArray = arrayOf('S', 'B', 'e')
    val booleansArray = arrayOf(true, false, true)
    val animalsArray = arrayOf(Animal(), Animal(), Animal())

    //функции для создания массивов примитивных типов
    val intsArrayPrimitive = intArrayOf(3, 4, 5, 6, 8)
    val shortsArrayPrimitive = shortArrayOf(3, 4, 5, 6, 8)
    val bytesArrayPrimitive = byteArrayOf(3, 4, 5, 6, 8)
    val longsArrayPrimitive = longArrayOf(1100000004789, 11000000049909, 1100000004089)
    val doublesArrayPrimitive = doubleArrayOf(3.3, 4.1, 6.0)
    val floatsArrayPrimitive = floatArrayOf(3.3f, 4.1f, 6.0f)
    val charsArrayPrimitive = charArrayOf('S', 'B', 'e')
    val booleansArrayPrimitive = booleanArrayOf(true, false, true)

    //создание массива заданного размера, заполненного значениями null
    val arrayOfNulls = arrayOfNulls<Int>(100)

    //создание пустого массива без размера
    val arrayEmpty = emptyArray<Int>()

    //constructor of Array<T> class - инициализация значений по умолчанию
    val intsArrayConstructor = Array<Int?>(3) { it -> 0 }
    val shortsArrayConstructor = Array<Short?>(3) { it -> 0 }
    val bytesArrayConstructor = Array<Byte?>(3) { it -> 0 }
    val longsArrayConstructor = Array<Long?>(3) { it -> 0 }
    val doublesArrayConstructor = Array<Double?>(3) { it -> 0.0 }
    val floatsArrayConstructor = Array<Float?>(3) { it -> 0.0f }
    val stringsArrayConstructor = Array<String?>(3) { it -> "" }
    val charsArrayConstructor = Array<Char?>(3) { it -> 'c' }
    val booleansArrayConstructor = Array<Boolean?>(3) { it -> false }
    val animalsArrayConstructor = Array<Animal?>(3) { it -> null }

    //конструктор для создания массивов примитивных типов
    val intsArrayPrimitiveConstructor = IntArray(3) //[0, 0, 0]
    val shortsArrayPrimitiveConstructor = ShortArray(3) { 1 } //[1, 1, 1]
    val bytesArrayPrimitiveConstructor = ByteArray(3) { (it * 1).toByte() } // [0, 1, 2]
    val longsArrayPrimitiveConstructor = LongArray(3) //[0, 0, 0]
    val doublesArrayPrimitiveConstructor = DoubleArray(3) //[0.0, 0.0, 0.0]
    val floatsArrayPrimitiveConstructor = FloatArray(3) //[0.0f, 0.0f, 0.0f]
    val charsArrayPrimitiveConstructor = CharArray(3) { 'c' } //[c, c, c]
    val booleansArrayPrimitiveConstructor = BooleanArray(3) //[false, false, false]

    //преобразование обертки в массив примитивного типа
    val intsArrayToPrimitive = arrayOf(3, 4, 5, 6, 8).toIntArray()
    val longsArrayToPrimitive = arrayOf(1100000004789, 11000000049909, 1100000004089).toLongArray()
    val doublesArrayToPrimitive = arrayOf(3.3, 4.1, 6.0).toDoubleArray()
    val floatsArrayToPrimitive = arrayOf(3.3f, 4.1f, 6.0f).toFloatArray()
    val charsArrayToPrimitive = arrayOf('S', 'B', 'e').toCharArray()
    val booleansArrayToPrimitive = arrayOf(true, false, true).toBooleanArray()
//    val shortsArrayToPrimitive: Array<Short> = arrayOf(3, 4, 5, 6, 8).toShortArray() ???
//    val bytesArrayToPrimitive: Array<Byte> = arrayOf(3, 4, 5, 6, 8).toByteArray() ???

//    val intsArrayConstructorToPrimitive = Array<Int?>(3) { it -> 0 }.toIntArray() ???

    //оператор доступа к массиву []
    val arrayAccess = intArrayOf(3, 4, 2)
    val thirdElement = arrayAccess[2]

    //функции get
    val arrayAccessGet = intArrayOf(3, 4, 2)
    val secondElement = arrayAccess.get(2)

    //функции расширения
    val arrayExtension = intArrayOf(3, 4, 2)
    val firstLang = arrayExtension.component1()
    val secLang = arrayExtension.component2()
    val firstItem = arrayExtension.elementAt(0)
    val secItem = arrayExtension.elementAt(0)
    val tenthItem = arrayExtension.elementAtOrElse(9) { _ -> 1 }
    val eleventhItem = arrayExtension.elementAtOrNull(10)
    val lastElement = arrayExtension.last()
    val lastElementIndex = arrayExtension.lastIndex

    //обход элементов массива по индексу цикл for
    val arrayForLoop = arrayOf("Get", "Net", "Set", "Let", "red", "wed", "ked")
    for (i in arrayForLoop.indices) {
        if (i % 2 == 0) {
//            print(arrayForLoop[i] + " ")
        } else {
//            print(arrayForLoop[i].uppercase(Locale.getDefault()) + " ") //делаем заглавными каждый нечетный индекс
        }
    } //Get NET Set LET red WED ked

    //обход элементов массива по индексу и значению элемента цикл for
    val arrayForLoopWithIndex = arrayOf("Get", "Net", "Set", "Let", "red", "wed", "ked")
    for ((index, value) in arrayForLoopWithIndex.withIndex()) {
        if (index % 2 == 0) {
//            println("The element at $index is $value")
        } else {
//            println("The element at $index is ${value.uppercase(Locale.getDefault())}")
        }
    }

    //обход элементов массива по значению элемента цикл for
    val arrayForLoopValues = arrayOf("Get", "Net", "Set", "Let", "red", "wed", "ked")
    for (element in arrayForLoopValues) {
//        print("$element ")
    } // Get Net Set Let red wed ked

    //обход элементов массива - использование итератора
//    val numbers = arrayOf("one", "two", "three", "four")
//    val numbersIterator = numbers.iterator()
//    while (numbersIterator.hasNext()) {
////        print("${numbersIterator.next()} ")// one two three four
//    }

    //обход элементов массива по значению - функция расширения forEach
    arrayForLoopValues.forEach {
//        println("Strings in Upper Case - ${it.uppercase(Locale.getDefault())}")
    }

    //обновление элементов в массиве - оператор доступа []
    val arrayForLoopSetOperator = arrayOf("Get", "Net", "Set", "Let", "red", "wed", "ked")
    arrayForLoopSetOperator[0] = "rat"
    arrayForLoopSetOperator[1] = "Fet"
    arrayForLoopSetOperator.forEach {
//        print("$it ")
    }// rat Fet Set Let red wed ked

    //обновление элементов в массиве - функция set
    val arrayForLoopSetFun = arrayOf("Get", "Net", "Set", "Let", "red", "wed", "ked")
    arrayForLoopSetFun.set(0, "rat")
    arrayForLoopSetFun.set(1, "Fet")
    arrayForLoopSetFun.forEach {
//        print("$it ")
    }// rat Fet Set Let red wed ked

    //обновление элементов в массиве - функции расширения
    //???

    //Получение длины массива
    val arrayGetSize = arrayOf(4, 6, 2, 9, 4)
//    println(arrayGetSize.size) // 5

    //создание двумерного массива
    val arrayOfArrayDeclaring = arrayOf<Array<Int>>()
    val arrayOfArrayInit = arrayOf(arrayOf(1, 2, 3), arrayOf(3, 4, 2))
    val arrayOfArrayPrimitive = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 6, 7))
    val arrayOfDoublesArraysPrimitive = arrayOf(IntArray(3) { 1 }, IntArray(3))
    val stringArray = List(10) { mutableListOf<String>() }

    //доступ к элементам дочернего массива - берется весь дочерний массив
    val food = arrayOf(
        arrayOf("Apple", "Apricot", "Avocado"),
        arrayOf("Banana", "Broccoli", "Beetroot"),
        arrayOf("Cherry", "Carrot")
    )
    val row1 = food[0] //Apple Apricot Avocado
    val row2 = food[1] //Banana Broccoli Beetroot
    val row3 = food[2] //Cherry Carrot

    //берется только указанный элемент дочернийего массива
    val firstFoodWithA = row1[0] //Apple
    val firstFoodWithB = row2[0] //Banana
    val firstFoodWithС = row3[0] //Cherry

    //доступ к определенному элементу дочернего массива через его индекс
//    println(food[0][1]) //Apricot
//    println(food[1][1]) //Broccoli
//    println(food[2][1]) //Carrot

    //обновление дочернего массива
    food[0] = arrayOf("Date", "Damson", "Durian")

    //обновление определенного значения дочернего массива
    food[2][1] = "Coconut" // Carrot to Coconut

    //обновление всех значений массива
    for (row in food.indices) {
        for (item in food[row].indices) {
            food[row][item] = "New value"
        }
    }

    //обход элементов двумерного массива и вывод их значений
    for (row in food) {
        for (item in row) {
//            print("$item ")
        }
//        println()
    }

    //найти элемент коллекции с максимальным значением свойства класса - в ручную
//    val people = arrayOf(Person("Bob", 34), Person("Anna", 45))
//    findTheOldest(people) //Person(name=Anna, age=45)

    //поиск с помощью лямбда-выражения
//    val people = arrayOf<Person>(Person("Bob", 34), Person("Anna", 45))
//    println(people.maxBy { it.age }) //Person(name=Anna, age=45

    //ссылка на метод при делегировании работы лямбды функции или свойству
//    people.maxBy(Person::age)

    //функция filter
    val arrayFilter = arrayOf(1, 2, 3, 4)
//    println(arrayFilter.filter { it % 2 == 0 }) // [2, 4] - только четные

    //находим людей старше 30
//    val people = arrayOf<Person>(Person("Tom", 34), Person("Anna", 25))
//    println(people.filter { it.age > 30 }) // [Person(name=Tom, age=34)]

    //функция map
    val arrayMap = arrayOf(1, 2, 3, 4)
//    println(arrayMap.map { it * it }) // [1, 4, 9, 16]

    //просто вывести список имен
//    val people = arrayOf(Person("Tom", 34), Person("Anna", 25))
//    println(people.map { it.name }) // [Tom, Anna]

    //вывести имена всех, кто старше 30
//    val people = arrayOf(Person("Tom", 34), Person("Anna", 25))
//    println(people.filter { it.age > 30 }.map { it.name }) // [Tom]

    //имена самых взрослых людей в группе — повторяет процесс поиска максимального возраста для каждого человека
    val people = arrayOf(
        Person("Tom", 34),
        Person("Anna", 25),
        Person("Penny", 34),
        Person("Sam", 33)
    )

    println(people.filter {
        it.age == people.maxBy(Person::age).age
    }) // [Person(name=Tom, age=34), Person(name=Penny, age=34)]

    //имена самых взрослых людей в группе — повторяет процесс поиска максимального возраста один раз
//    val people = arrayOf(
//        Person("Tom", 34),
//        Person("Anna", 25),
//        Person("Penny", 34),
//        Person("Sam", 33)
//    )
//    val maxAge = people.maxBy(Person::age).age
//    println(people.filter { it.age == maxAge }) // [Person(name=Tom, age=34), Person(name=Penny, age=34)]

    //проверка всех элементов коллекции на соответствие определенному условию
    val canBeInClub27 = { p: Person -> p.age <= 27 }
//    val people = arrayOf(
//        Person("Tom", 34),
//        Person("Anna", 25),
//        Person("Penny", 34),
//        Person("Sam", 33)
//    )
//    println(people.any(canBeInClub27)) // true

    //сколько элементов удовлетворяет предикату
//    val canBeInClub27 = { p: Person -> p.age <= 27 }
//    val people = arrayOf(
//        Person("Tom", 34),
//        Person("Anna", 25),
//        Person("Penny", 34),
//        Person("Sam", 33)
//    )
//    println(people.filter(canBeInClub27).size) // 1

    //найти элемент, удовлетворяющий предикату
//    val canBeInClub27 = { p: Person -> p.age <= 27 }
//    val people = arrayOf(
//        Person("Tom", 34),
//        Person("Anna", 25),
//        Person("Penny", 34),
//        Person("Sam", 33)
//    )
//    println(people.firstOrNull(canBeInClub27)) // Person(name=Anna, age=25)

    //разделить на группы по критерию
//    val canBeInClub27 = { p: Person -> p.age <= 27 }
//    val people = arrayOf(
//        Person("Tom", 34),
//        Person("Anna", 25),
//        Person("Penny", 34),
//        Person("Sam", 33)
//    )
//    println(people.groupBy { it.age }) //{34=[Person(name=Tom, age=34), Person(name=Penny, age=34)],
//                                       // 25=[Person(name=Anna, age=25)], 33=[Person(name=Sam, age=33)]}

    //группировать строки по первому символу
//    val arrayFirstStringGroup = arrayOf("a", "ab", "b")
//    println(arrayFirstStringGroup.groupBy(String::first)) // {a=[a, ab], b=[b]}

    //множество всех авторов в библиотеке
//    val books = arrayOf(
//        Book("Thursday Next", arrayListOf("Jasper Fforde")),
//        Book("Mort", arrayListOf("Terry Pratchett")),
//        Book("Good Omens", arrayListOf("Terry Pratchett", "Neil Gaiman"))
//    )
//    println(books.flatMap { it.authors }.toSet()) //[Jasper Fforde, Terry Pratchett, Neil Gaiman]

    //несколько списков в один - flatMap
    val arrayStringsFlatMap = listOf("abc", "def")
//    println(arrayStringsFlatMap.flatMap { it.toList() }) // [a, b, c, d, e, f]

    //плоская коллекция, без преобразований - flatten()
//    val arrayOfArray = arrayOf(
//        arrayOf("abc", "def"),
//        arrayOf("ghi", "jkl"),
//        arrayOf("mno", "pqr"),
//    )
//    println(arrayOfArray.flatten()) // [abc, def, ghi, jkl, mno, pqr]

    //функция drop
    val arrayDrop = IntArray(20) { it -> it + 1 }
//    println("${arrayDrop.drop(5)}")     // [6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
//    println("${arrayDrop.dropLast(5)}") // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

    //функция take
//    val arrayTake = IntArray(100) { it * 10 }
//    println("${arrayTake.take(10)}") // (1) [0, 10, 20, 30, 40, 50, 60, 70, 80, 90]
//    println("${arrayTake.takeLast(10)}") // (2) [900, 910, 920, 930, 940, 950, 960, 970, 980, 990]
//    println("${arrayTake.takeWhile { it <= 50 }}") // (3) [0, 10, 20, 30, 40, 50]
//    println("${arrayTake.takeLastWhile { it >= 900 }}") // (4) [900, 910, 920, 930, 940, 950, 960, 970, 980, 990]

    //функция zip
//    val names = arrayOf("Chandra", "Rivu", "Nick", "Ahmed")
//    val ages = arrayOf(30, 27, 35, 19)
//    println(names.zip(ages)) // [(Chandra, 30), (Rivu, 27), (Nick, 35), (Ahmed, 19)]

    //оператор + = с массивом
    var array = arrayOf(1, 2, 3)
    array += 4
//    println(array.joinToString()) // > 1, 2, 3, 4

    // среднее значение чисел в массиве
    val arrayAverage = arrayOf(1, 3, 5)
    println(array.average()) // 3.0
}

// среднее значение чисел - собственная реализация
fun getAverage(list: List<Int>): Double {
    var sum: Long = 0
    for (element in list) {
        sum += element.toLong()
    }
    return if (list.isNotEmpty()) sum.toDouble() / list.size else 0.0
}

//Свой сеттер для конкретной реализации двумерного массива
private operator fun Array<Array<String>>.set(i: Int, value: String) {
    this[i] = this[i] + value
}

class Animal

class Book(val title: String, val authors: ArrayList<String>)

data class Person(val name: String, val age: Int)

fun findTheOldest(people: Array<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
//    println(theOldest)
}