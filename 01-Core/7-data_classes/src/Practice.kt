/*
### Упражнения
1. **Декомпозиция объектов с помощью `componentN`**
   Создайте `data class User(val id: Int, val name: String, val age: Int)`.
   Напишите функцию, которая принимает объект `User`, извлекает его свойства с помощью декомпозиции и
   возвращает строку в формате: `"ID: {id}, Name: {name}, Age: {age}"`.

2. **Копирование с изменением отдельных свойств (`copy`)**
   Создайте `data class Product(val id: Int, val name: String, val price: Double)`.
   Создайте объект `Product`, а затем создайте его копию с измененной ценой.

3. **Представление данных с `toString()`**
   Создайте `data class Order(val orderId: Int, val items: List<String>, val total: Double)`.
   Создайте объект `Order` и выведите его в консоль.

4. **Использование дата-классов в `Set` и `Map`**
   Создайте `data class Point(val x: Int, val y: Int)`.
   Создайте множество (`Set`) из трех объектов `Point`, где один из объектов является дубликатом, и выведите множество.

5. **Значения по умолчанию для свойств**
   Создайте `data class Config(val url: String, val timeout: Int = 30, val retries: Int = 3)`.
   Создайте объект `Config`, задав только URL, и выведите объект.

6. **Использование в `when` для сопоставления с образцом**
   Создайте `sealed class Shape` с двумя наследниками: `data class Circle(val radius: Double)`
   и `data class Rectangle(val width: Double, val height: Double)`.
   Напишите функцию `calculateArea`, которая принимает `Shape` и возвращает площадь фигуры.

7. **Сравнение содержимого объектов**
   Создайте два объекта `data class Address(val street: String, val city: String)` с одинаковыми значениями.
   Сравните их с помощью `==` и выведите результат.

8. **Передача данных через Intent или Bundle**
   Создайте `@Parcelize data class User(val id: Int, val name: String) : Parcelable`.
   Напишите код для передачи этого объекта через Intent.

9. **Использование вложенных дата-классов**
   Создайте `data class ApiResponse(val status: String, val data: Data)`, где `Data` содержит два свойства:
   `id` и `attributes`, а `Attributes` — два свойства: `name` и `age`.
   Создайте объект `ApiResponse` с вложенными данными и выведите его.

10. **Использование дата-классов для результатов операций (Result classes)**
    Создайте `data class Result<T>(val value: T?, val error: String?)`.
    Напишите функцию, которая принимает ID пользователя и возвращает `Result` с данными или ошибкой.

11. **Создание иммутабельных объектов**
    Создайте неизменяемый объект `data class ImmutableUser(val id: Int, val name: String)` и продемонстрируйте
    его неизменяемость.

12. **Создание универсальных утилит для обработки данных**
    Создайте `data class Pair<A, B>(val first: A, val second: B)`.
    Напишите функцию, которая принимает объект `Pair` и возвращает строку в формате: `"First: {first}, Second: {second}"`.
 */


fun main() {

}

data class Manager(val name: String,) {
    constructor(name: String, age: Int,) : this(name,)
}

data class Address(var street: String, var city: String, var country: String)
data class PersonNext(val name: String, val address: Address)
data class Trip(val places: Map<String, String>)

