import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    // Зачем нужны асинхронность и параллельные вычисления?
    // Параллельные вычисления позволяют выполнять несколько задач одновременно,
    // а асинхронность позволяет не блокировать основной ход приложения.
    // В Kotlin поддержка асинхронности и параллельности - корутины (coroutine).
    // Usecase - вынести продолжительную работу - в корутину
    // Между корутинами и потоками нет прямого соответствия.
    // Корутина не привязана к конкретному потоку.
    // Может быть приостановлена в одном потоке - сохраняется в памяти,
    // а когда завершается запущенная задача возобновить выполнение в другом.

    // Методы асинхронного программирования
    // проблема — как предотвратить блокировку приложений:
    // Потоки (нити), Коллбэки (обратные вызовы),
    // Futures (фьючерс), обещания и другое,
    // Реактивные расширения, Корутины

    // Корутина вызываться только в контексте корутины (coroutine scope), который
    // имеет жизненный цикл и сама управляет жизненным циклом внутри нее корутин.
    // coroutineScope() - создает объект интерфейса CoroutineScope
    // coroutineScope() не блокирует вызывающий поток:
    suspend fun doWork()= coroutineScope{
        launch{
            for(i in 0..5){
                println(i)
                delay(400L)
            }
        }
    }

    // Запуск нескольких корутин
    // coroutineScope() ожидает завершения всех определенных в этой области корутин
    // функция main завршит выполнение, когда будут завершены обе корутины
    coroutineScope {
        launch{
            for(i in 0..5){
                delay(400L)
                println(i)
            }
        }
        launch{
            for(i in 6..10){
                delay(400L)
                println(i)
            }
        }
    }

    // runBlocking() -  создание coroutine scope
    // блокирует вызывающий поток,
    // runBlocking { пока все корутины не завершат свое выполнение }
    runBlocking {
        launch{
            for(i in 0..5){
                delay(400L)
                println(i)
            }
        }
    }

    // Вложенные корутины
    // внешние корутины определяют scope для вложенных корутин
    // и управляют их жизненным циклом.
    coroutineScope {
        launch{
            println("Outer coroutine")
            launch{
                println("Inner coroutine")
                delay(400L)
            }
        }
    }

    // Builders корутин
    // launch() - когда нам не надо возвращать результат из корутины
    // и когда нам ее надо выполнять одновременно с другим кодом


    // Job

    //
    data class Item(val item: Item?)
    data class Token(val get: String)
    data class Post(val token: Token, val item: Item)

//    fun preparePost(): Token {
//        // делает запрос и, следовательно, блокирует основной поток
//        return Token("")
//    }

    fun submitPost(token: Unit, item: Item): Post {
        TODO("Not yet implemented")
    }

    fun processPost(post: Post) {
        TODO("Not yet implemented")
    }

//    fun postItem(item: Item) {
//        val token = preparePost()
//        val post = submitPost(token, item)
//        processPost(post)
//    }

    // Потоки - недостатки:
    // Потоки недешевые - требуют переключения контекста, что является дорогостоящим.
    // Количество потоков ограничено базовой операционной системой.
    // Отладка потоков, избежание состояния гонки (конкуренции).

    // Коллбэки - передать одну функцию в качестве параметра
    // другой функции и вызвать ее после завершения процесса.
//    fun preparePostAsync(callback: (Token) -> Unit) {
//        // делает запрос и немедленно возвращается
//        // организует коллбэк для последующего вызова
//    }

    fun submitPostAsync(token: Token, item: Item, post: (Post) -> Unit) {
        TODO("Not yet implemented")
    }

//    fun postItem(item: Item) {
//        preparePostAsync { token ->
//            submitPostAsync(token, item) { post ->
//                processPost(post)
//            }
//        }
//    }

    // Коллбэки - несколько проблем:
    //Сложность вложенных коллбэков. Обычно функция,
    // которая используется в качестве коллбэка, часто заканчивается тем,
    // что ей требуется собственный обратный вызов.
    // Это приводит к серии вложенных обратных вызовов - код становится малопонятным.
    // Обработка ошибок сложна.

    // Futures (фьючерс), обещания и другое
    // когда мы совершаем вызов, нам обещают,
    // он вернет объект - Promise (обещание) - с ним и работаем
    class Promise<T> {
        fun thenCompose(token: (Token) -> Unit) {
            TODO("Not yet implemented")
        }
    }

    fun Any.thenAccept(any: (Post) -> Unit) {
        TODO("Not yet implemented")
    }

    fun preparePostAsync(): Promise<Token> {
        // делает запрос и возвращает обещание, которое будет выполнено позже
        return Promise()
    }

//    fun postItem(item: Item) {
//        preparePostAsync()
//            .thenCompose { token ->
//                submitPostAsync(token, item) {}
//            }
//            .thenAccept { post ->
//                processPost(post)
//            }
//    }

    // Futures (фьючерс) - проблемы:
    // Другая модель программирования. Подобно коллбэкам, модель программирования
    // отходит от подхода сверху вниз к композиционной модели с цепными вызовами;
    // Структуры, как циклы, обработка исключений и т.д., не применимы в этой модели;
    // Различные API - такие, как thenCompose или thenAccept;
    // Возвращаемый тип отличается от фактических данных, которые нам нужны,
    // и вместо этого возвращает новый тип Promise, который необходимо проанализировать;
    // Обработка ошибок может быть сложной.

    // Reactive Extensions, Rx - так называемым observable streams (наблюдаемые потоки),
    // благодаря которым теперь мы думаем о данных как о потоках (бесконечных объемах данных),
    // и эти потоки можно наблюдать. Rx - это просто шаблон наблюдателя с рядом расширений,
    // которые позволяют оперировать данными.
    // Похожи на фьючерс, но можно думать о фьючере как о возврате дискретного элемента,
    // тогда как Rx возвращают поток.
    // Проблемы - как и фьючерс, совершенно новый взгляд на модель программирования:
    // "всё - поток, который можно наблюдать"
    // ++: согласованный API и более приятный подход к обработке ошибок.

    // Корутины (сопрограммы-coroutines) -
    // представляют собой идею приостанавливаемых вычислений,
    // функция может приостановить свое выполнение и возобновить позже.
    // ++: синхронный код сверху вниз.
    // циклы, обработка исключений и т.д., нет необходимости изучать полный набор API.
    suspend fun preparePost() {
        // делает запрос и приостанавливает выполнение корутины возвращает
//        suspendCoroutine { /* ... */ }
    }

    // код запустит длительную операцию, не блокируя основной поток.
    // функция будет приостанавливать выполнение и возобновлять.
    suspend fun postItem(item: Item) {
        coroutineScope {
            launch {
                val token = preparePost()
                val post = submitPost(token, item)
                processPost(post)
            }
        }

    }

    // async - can be used to start another coroutine with request
    // and wait for its result to arrive later with - await
//    fun showNews() {
//        viewModelScope.launch {
//            val config = async { getConfigFromApi() }
//            val news = async { getNewsFromApi(config.await()) }
//            val user = async { getUserFromApi() }
//            view.showNews(user.await(), news.await())
//        }
//    }



}




