package array;

import java.util.Arrays;
import java.util.List;

public class ArrayJava extends Object {
    public static void main(String[] args) {
        class LazyInitializedSingleton {
            private static LazyInitializedSingleton instance;
            private LazyInitializedSingleton(){}
            public static LazyInitializedSingleton getInstance(){
                if(instance == null){
                    instance = new LazyInitializedSingleton();
                }
                return instance;
            }
        }


        // declaration and initialization
        int[] numbers;         // declaring an array reference variable
        numbers = new int[5];  // create an array and assign its address to the numbers variable
        numbers[0] = 1;        // access and set the first element value at 0 index with 1

        int[] days = {25, 26, 27, 28, 29, 30, 31}; // declares the reference variable days and stores initial values

        //iterating elements of the array

        // enhanced for (can't assign values)
        for (int number : numbers) {
//            System.out.println(number);
        }

        // for loop (can assign values)
        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
        }

        String[][] array = {
                {"Apple", "Apricot", "Avocado"},
                {"Banana", "Broccoli", "Beetroot"},
                {"Cherry", "Carrot"}
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "New value";
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }

        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        stooges.add("New");
        System.out.println(stooges);



    }


}
