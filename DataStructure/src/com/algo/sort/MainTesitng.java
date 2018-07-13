package com.algo.sort;

public class MainTesitng {

	public static void main(String[] args) {
		int arr[] = {64,25,12,22,11};
		int arr1[] = {64,25,12,22,11};
		int arr2[] = {64,25,12,22,11};
		SortingInterface sortingInterface = new BubbleSort();
		printArray(sortingInterface.sort(arr));
		sortingInterface = new SelectionSort();
		printArray(sortingInterface.sort(arr1));
		sortingInterface = new Insertionsort();
		printArray(sortingInterface.sort(arr2));
	}

	private static void printArray(int[] sort) {
		for(int i: sort) {
			System.out.print(i+"   ");
		}
		System.out.println();
	}
	

}
