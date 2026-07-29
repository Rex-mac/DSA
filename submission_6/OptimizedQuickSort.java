/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_6;
import java.util.Scanner;

/**
 *
 * @author renuj
 */

public class OptimizedQuickSort {

    private static final int THRESHOLD = 10;

    public static void insertionSort(int[] arr, int low, int high) {

        for (int i = low + 1; i <= high; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static int medianOfThree(int[] arr, int low, int high) {

        int mid = (low + high) / 2;

        if (arr[low] > arr[mid])
            swap(arr, low, mid);

        if (arr[low] > arr[high])
            swap(arr, low, high);

        if (arr[mid] > arr[high])
            swap(arr, mid, high);

        swap(arr, mid, high - 1);

        return arr[high - 1];
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = medianOfThree(arr, low, high);

        int i = low;
        int j = high - 1;

        while (true) {

            while (arr[++i] < pivot);

            while (arr[--j] > pivot);

            if (i >= j)
                break;

            swap(arr, i, j);
        }

        swap(arr, i, high - 1);

        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low + THRESHOLD > high) {
            insertionSort(arr, low, high);
        } else {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int[] arr) {

        for (int x : arr)
            System.out.print(x + " ");

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

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);

        sc.close();
    }
}
    

