/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sdksamples;

public class QuickSort {
    public static void main (String[] args){
        int[] myArray = { 20, 3, 35, 14, 28, 39, 8, 25 };
        System.out.print(" Array Before Sorting = ");
	printArray(myArray);
        int first = 0;
	int last = myArray.length - 1;
        quickSort(myArray, first, last);
        System.out.print(" Array After Sorting = ");
        printArray(myArray);
    }
    
    private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

    
public static void quickSort(int[] arr, int first, int last) {
                int pivot = arr[first];
                int i = first+1, j = last;
                while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
                            }
                    }
                
                 int temp1 = arr[j];
		     arr[j] = arr[first];
		     arr[first] = temp1; 
                if (first < j)
		  quickSort(arr, first, j-1);
 
		if (last > i)
		  quickSort(arr, i, last);

}
}