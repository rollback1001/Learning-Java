package com.melshconsult;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraySort {
	private static final Scanner scanner = new Scanner(System.in);

	public static int[] getIntegers() {
		int[] arrayIntegers;
		System.out.print("Enter number of integers: ");
		int numIntegers = scanner.nextInt();

		arrayIntegers = new int[numIntegers];

		System.out.println("Enter integers");
		for (int i = 0; i < arrayIntegers.length; i++) {
			arrayIntegers[i] = scanner.nextInt();
		}

		return arrayIntegers;
	}

	public static int[] sortArray(int[] array) {
		int[] sortedArray = new int[array.length];
		boolean flag = true;

		System.arraycopy(array, 0, sortedArray, 0, array.length);

		while (flag) {
			flag = false;
			int temp;

			for (int i = 0; i < sortedArray.length - 1; i++) {
				if (sortedArray[i] < sortedArray[i + 1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i + 1];
					sortedArray[i + 1] = temp;
					flag = true;
				}
			}
		}

		return sortedArray;
	}

	public static int[] sortArrayDescending(int[] array) {
		int[] sortedArrayDesc = new int[array.length];
		boolean flag = true;

		System.arraycopy(array, 0, sortedArrayDesc, 0, array.length);

		while (flag) {
			flag = false;
			int temp;

			//10, 98, 45, 23, 9
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true;
					continue;
				}
				sortedArrayDesc[i] = array[i];
			}
		}
		return sortedArrayDesc;
	}

	public static void printArray(int[] array) {
		System.out.print("Elements in array are ");
		for (int element : array)
			System.out.print(element + " ");
	}
}
