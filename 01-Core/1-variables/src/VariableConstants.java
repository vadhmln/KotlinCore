
public class VariableConstants {
    // Java 10 определяет var как идентификатор - можем определить переменную, параметр или метод с именем var:
    public void var() {
        // do something
    }

    public void method(int var) {
        // do something

    }

    public void method() {
        int var = 1;
        // do something
    }

    public static void main(String[] args) {

        int length = 72;

        // объявление начинается с типа
        int intMyNumber;

        // Если переменные имеют один и тот же тип, они могут быть объявлены вместе
        int intNumber1, intNumber2, intNumber3;

        // Переменные часто имеют начальные значения. Вы можете объявить переменную
        // и инициализировать ее за один шаг
        int ab = 1; // = int ab; ab = 1;

        // Также можно использовать сокращенную форму для совместного объявления и
        // инициализации переменных одного и того же типа
        int q = 1, w = 9;

        // тип локальных переменных можно не указывать, если их тип может быть получен
        // на основе присваемого значения
        var number = 3; // java 10

//        var myVariable; // Cannot infer type: 'var' on variable without initializer
//        myVariable = 1;

        // переменная, объявленная с помощью var в Java, может быть изменяемой или финальной:
        var mutableInt = 1;
        final var immutableInt = 1;

        System.out.println(number);

        int testNumber, cv = 2;
        testNumber = returnTestNumber(10);

//        System.out.println(testNumber);

        testNumber = 12 + returnTestNumber(9);

//        System.out.println(testNumber);

        var number1 = 5;
        var number2 = 5;

        testNumber = returnTestNumber(5) + sumTwoNumbers(number1, number2);

//        System.out.println(testNumber);

        //
        int x, y, z;
        x = y = z = 100; // установить значения для трех переменных = 100

        //неявное преобразование
        byte byteNumber = 1;
        short shortNumber = 2;
        int intNumber = 3;
        long longNumber = 4L;
        double doubleNumber = 3.14;
        float floatNumber = 4.88f;

        //без потери точности
//        shortNumber = byteNumber;
        intNumber = shortNumber;
//        longNumber = intNumber;
        doubleNumber = intNumber;
        doubleNumber = floatNumber;

        //c потерей точности
        floatNumber = intNumber;
        floatNumber = longNumber;
        doubleNumber = longNumber;

        //явное преобразование
        byteNumber = (byte) intNumber;
        intNumber = (int) doubleNumber;
        shortNumber = (short) floatNumber;

        //Усечение рациональных чисел до целых
//        double a = 56.9898;
//        int b = (int) a;
//        System.out.println(b); // 56

        //функция округления
        double a = 56.9898;
        int b = (int) Math.round(a);
        System.out.println(b); // 57
    }

    static int returnTestNumber(int number) {
        return number;
    }

    static int sumTwoNumbers(int number1, int number2) {
        return number1 + number2;
    }

    static void printDouble(double number) {
        System.out.println(number);
    }
}
