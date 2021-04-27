package com.melshconsult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of integers: ");
        int numIntegers = scanner.nextInt();

        int[] userInputArray = FindMinimum.readIntegers(numIntegers);

        int minimumNumber = FindMinimum.findMinimumInteger(userInputArray);

        System.out.printf("Minimum number is %d", minimumNumber);
    }
}
