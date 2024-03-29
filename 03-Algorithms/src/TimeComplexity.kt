/*
программисты используют нотацию, известную как Big O нотоция, для представления
различных величин временной сложности.
 */

/*
Временная сложность - это мера времени, необходимого для запуска алгоритма по
мере увеличения размера входных данных.
 */

/*
Алгоритм (a constant time) с постоянным временем - это алгоритм, который имеет одинаковое время выполнения независимо от
размера входных данных.
 */

fun checkFirst(names: List<String>) {
    if (names.firstOrNull() != null) {
        println(names.first())
    } else {
        println("no names")
    }
}

/*
Размер names не влияет на время выполнения этой функции. Содержат ли names
10 элементов или 10 миллионов элементов, эта функция проверяет только первый элемент
списка.
 */

/*
Big O нотация для обозначения постоянного времени равно O(1).
Это одна единица времени, независимо от входных данных. Однако это время необязательно должно быть маленьким.
  Алгоритм все еще может быть медленным, но он одинаково медленный все время.
 */

//Линейное время
fun printNames(names: List<String>) {
    for (name in names) {
        println(name)
    }
}

/*
Эта функция выводит все имена в виде списка строк. По мере увеличения размера входного списка
количество итераций увеличивается на ту же величину.
Такое поведение известно как линейная временная сложность.
По мере увеличения объема данных время выполнения увеличивается на ту же величину.
Big O нотация для линейного времени равно O(n).
 */