/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_5;
 import java.util.Scanner;
/**
 *
 * @author renuj
 */

    
   

public class OptimizedInsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            swapped = false;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                swapped = true;
            }

            arr[j + 1] = key;

            // Optimization: Stop if no shifting occurred
            if (!swapped) {
                continue;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("\nOriginal Array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);

        sc.close();
    }
}
    

