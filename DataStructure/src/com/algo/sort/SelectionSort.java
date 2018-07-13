package com.algo.sort;

public class SelectionSort implements SortingInterface{

	
	public int[] sort(int[] arr) {
		for(int i= 0 ;i< arr.length-1;i++) {
			int index = i;
			for(int j= i+1 ;j < arr.length;j++) {
				if(arr[j] < arr[index]) 
					index = j;
			}	
				int temp = arr[i]; 
				arr[i] = arr[index];
				arr[index] = temp;	
		}
		return arr;
	}
	
}
