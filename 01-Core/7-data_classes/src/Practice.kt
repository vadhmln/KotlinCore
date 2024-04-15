fun main() {
    val manager1 = Manager("Manager1", 20)
    val manager2 = Manager("Manager1")

    if (manager1 == manager2) {
        println("true")
    } else println("false")

    val address = Address("Main St", "Springfield", "USA")
    val person1 = PersonNext("John Doe", address)
    val person2 = person1.copy()  // Поверхностное копирование

    println("Исходный объект Address $address")
    println("Исходный объект person1 $person1")
    println("Исходный объект person2 $person2")

    person2.address.street = "NewStreet"
    person2.address.city = "NewCity"
    person2.address.country = "NewCityCountry"

    println("Address после изменений $address")
    println("person1 после изменений $person1")
    println("person2 после изменений $person2")

    person1.address.street = "NewStreet1"
    person1.address.city = "NewCity1"
    person1.address.country = "NewCityCountry1"

    println("Address после изменений $address")
    println("person1 после изменений $person1")
    println("person2 после изменений $person2")

    // componentN +++
// we can name variables however we want
    val visited = listOf("Spain", "Morocco", "India")
    val (first, second, third) = visited
    println("$first $second $third") // Spain Morocco India

    val trip = Trip(mapOf(
        first to "Gran Canaria",
        second to "Taghazout",
        third to "Rishikesh"
    ))

    for ((country, city) in trip.places) {
        println("We loved $city in $country")
        // We loved Gran Canaria in Spain
        // We loved Taghazout in Morocco
        // We loved Rishikesh in India
    }
}

data class Manager(val name: String,) {
    constructor(name: String, age: Int,) : this(name,)
}

data class Address(var street: String, var city: String, var country: String)
data class PersonNext(val name: String, val address: Address)
data class Trip(val places: Map<String, String>)

