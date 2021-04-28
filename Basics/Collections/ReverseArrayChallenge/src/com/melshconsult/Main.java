package com.melshconsult;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7,8, 9, 10};

        System.out.print("Original array elements: ");

        for (int ele : array)
            System.out.print(ele + " ");

        System.out.println();

        ReverseArray.reverse(array);
        System.out.print("Reversed array elements: ");

        for (int ele : array)
            System.out.print(ele + " ");
    }
}
