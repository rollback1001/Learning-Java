package com.melshconsult;

import java.util.Scanner;

public class FindMinimum {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] readIntegers(int numIntegers) {
        int[] userInputArray = new int[numIntegers];

        System.out.println("Enter the integers");

        for (int i = 0; i < numIntegers; i++) {
            userInputArray[i] = scanner.nextInt();
        }
        return userInputArray;
    }

    public static int findMinimumInteger(int[] data) {
        int minimumInteger = 0;
        boolean flag = true;

        while (flag) {
            int temp;
            flag = false;

            // 10, 5, 60, 1, 2
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] < data[i + 1]) {
                    temp = data[i];
                    data[i+1] = temp;
                    data[i] = data[i+1];
                    flag = true;
                }
            }
            minimumInteger = data[data.length-1];
        }
        return minimumInteger;
    }
}
