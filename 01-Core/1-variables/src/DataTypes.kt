fun main() {
    //Integer - целочисленные: Byte, Short, Int, Long
    val lowLevelFileProcessing: Byte = 1 // низкоуровневая обработка файлов
    val bigArrayList: Short = 2 // для больших массивов
    val mostSituations: Int = 3 // в большинстве ситуаций
    val numberOfCitizensOfThePlanet: Long = 8000000000L // для больших чисел

    //Boolean - Логический: принимает два значения:
    val myTrue: Boolean = true
    val myFalse: Boolean = false

    //Char - Символьный
    val aChar: Char = 'a'
    val unicodeEscapeSequenceSyntax: Char = '\uFF00'

    // escape sequences:
    // \t – tab, \b – backspace, \n – new line (LF),
    // \r – carriage return (CR)
    // \' – single quotation mark, \" – double quotation mark,
    // \\ – backslash, \$ – dollar sign

    // List (список) - упорядоченная индексированная динамическая коллекция
    // дубликаты могут быть
    // реализация по умолчанию ArrayList
    val immutableList: List<String> = listOf("Tea", "Coffee", "Tea")
    val valMutableList: MutableList<String> = mutableListOf("Tea", "Coffee")
    var varMutableList: MutableList<String> = mutableListOf("Tea", "Coffee")

    // Set (множество) - коллекция уникальных элементов.
    // Порядок не имеет значения. Дубликатов нет.
    // null — тоже уникальный элемент.
    // Реализация по умолчанию LinkedHashSet - порядок вставки.
    // immutableSet имеет: [chocolate, vanilla]
    val immutableSet = setOf("chocolate", "vanilla", "chocolate")
    val mutableSet = mutableSetOf("chocolate", "strawberry")
    // Реализацию можно создать напрямую:
    val hashSet: HashSet<String> = HashSet()

    // Map (ассоциативный список) – набор из пар "ключ-значение".
    // Ключи уникальны. Значения могут иметь дубликаты.
    // Связь между ключами и значениями через (инфиксный вызов) to.
    // Реализация по умолчанию LinkedHashMap - порядок вставки.
    // Для хранения логических связей между объектами: ID->должность
    val immutableMap = mapOf("name" to "Tom", "rank" to "captain")
    val mutableMap = mutableMapOf("name" to "Ben", "rank" to "captain")
    // Реализацию можно создать напрямую:
    val hashMap: HashMap<String, String> = HashMap()

    // Array (массив) – упорядоченная статическая последовательность значений.
    // Обычно одного и того же типа.
    val arraySame = arrayOf(1, 2, 100)
    val arrayNotSame = arrayOf(1, "Book", 'a')

    // Sequences (последовательности) – похожи на List.
    // Разница в обработке элементов при применении к ним набора операций.
    val sequenceNumbers = sequenceOf(1, 2, 3, 4)

    // String (строка) – контейнер реализуется, как массив символов.
    // Строки являются неизменяемыми.
    // Преобразующие операции возвращают новый объект String.
    val string = "String"
    // Создается и выводится новый объект String
    val upperCaseString = string.uppercase()
    println(upperCaseString) // STRING
    println(string) // String исходная строка остается прежней
}