package com.melshconsult;

public class Main {

    public static void main(String[] args) {
        int[] myArray = ArraySort.getIntegers();

        int[] sortedArray = ArraySort.sortArray(myArray);
        ArraySort.printArray(sortedArray);

        System.out.println();

        int[] sortedArrayDesc = ArraySort.sortArrayDescending(myArray);
        ArraySort.printArray(sortedArrayDesc);
    }
}
