package control_flow

import java.util.*

fun main(args: Array<String>) { // Основная функция программы
    val input = Scanner(System.`in`) // Создание объекта Scanner для чтения ввода
    val n = input.nextInt() // Чтение размера сетки
    val grid = Array(n) { input.next().toCharArray() } // Чтение сетки
    val visited = Array(n) { BooleanArray(n) } // Создание массива для отслеживания посещенных ячеек
    val dx = arrayOf(-1, 0, 1, 0) // Массив для изменения координаты x при движении вверх, вправо, вниз и влево
    val dy = arrayOf(0, 1, 0, -1) // Массив для изменения координаты y при движении вверх, вправо, вниз и влево

    fun isValid(x: Int, y: Int, target: Char): Boolean { // Функция для проверки, является ли ячейка допустимой для следующего шага
        return x in 0 until n && y in 0 until n && !visited[x][y] && grid[x][y] == target // Ячейка допустима, если она находится в пределах сетки, еще не была посещена и содержит целевой символ
    }

    fun dfs(x: Int, y: Int, target: Char): Boolean { // Функция для выполнения поиска в глубину (DFS)
        if (target > 'z') return true // Если целевой символ больше 'z', значит, мы нашли всю последовательность и возвращаем true
        for (i in 0..3) { // Перебор всех четырех направлений движения
            val nx = x + dx[i] // Вычисление новой координаты x
            val ny = y + dy[i] // Вычисление новой координаты y
            if (isValid(nx, ny, target)) { // Если новая ячейка допустима
                visited[nx][ny] = true // Отмечаем ее как посещенную
                if (dfs(nx, ny, target + 1)) return true // Если DFS из новой ячейки возвращает true, возвращаем true
                visited[nx][ny] = false // Если DFS из новой ячейки возвращает false, отмечаем ее как непосещенную
            }
        }
        return false // Если мы не можем найти полную последовательность из текущей ячейки, возвращаем false
    }

    for (i in 0 until n) { // Перебор всех ячеек сетки
        for (j in 0 until n) {
            if (grid[i][j] == 'a') { // Если ячейка содержит 'a'
                visited[i][j] = true // Отмечаем ее как посещенную
                if (dfs(i, j, 'b')) { // Если DFS из этой ячейки возвращает true
                    for (x in 0 until n) { // Перебор всех ячеек сетки
                        for (y in 0 until n) {
                            if (!visited[x][y]) grid[x][y] = '-' // Если ячейка не была посещена, заменяем ее содержимое на '-'
                        }
                    }
                    for (row in grid) { // Вывод итоговой сетки
                        println(row.joinToString(""))
                    }
                    return // Завершение программы
                }
                visited[i][j] = false // Если DFS из этой ячейки возвращает false, отмечаем ее как непосещенную
            }
        }
    }
    println("No solution found") // Если мы не можем найти полную последовательность в сетке, выводим сообщение
}
