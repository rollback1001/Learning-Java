package com.melshconsult;

public class ReverseArray {
    protected static void reverse(int[] arrayToReverse) {
        int[] reverseArray = new int[arrayToReverse.length];
        int counter = 0;

        for (int i = arrayToReverse.length - 1; i >= 0; i--) {
            reverseArray[counter] = arrayToReverse[i];
            counter++;
        }
        System.arraycopy(reverseArray, 0, arrayToReverse, 0, reverseArray.length);
    }
}
