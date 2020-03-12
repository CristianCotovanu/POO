package Main;

import Task1.PasswordMaker;
import Task3.MyImmutableArray;

import java.util.ArrayList;

public class Main {
    private static void printArray(ArrayList<Integer> array) {
        System.out.println("Elements: ");
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void fillArray(ArrayList<Integer> array) {
        for (int i = 0; i < 10; i++) {
            array.add((int) (Math.random() * 100));
        }
    }

    public static void main(String[] args) {
        PasswordMaker pswd = new PasswordMaker("RandomString");
        System.out.println();
        System.out.println(pswd.getPassword());

        ArrayList<Integer> myArray = new ArrayList<>();
        fillArray(myArray);

        ArrayList<Integer> secondArray = new ArrayList<>();
        fillArray(secondArray);

        MyImmutableArray immutableArray = new MyImmutableArray(myArray);
        immutableArray = new MyImmutableArray(secondArray);

        String a = "a";
        String b = "b";
        a = b;
        a = "b";
        System.out.println(a + " " + b);

        printArray(myArray);
        printArray(secondArray);
        printArray(immutableArray.getArray());
    }
}
