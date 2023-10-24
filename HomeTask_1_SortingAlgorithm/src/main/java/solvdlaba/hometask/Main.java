package solvdlaba.hometask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[] {5, 400, 33, -2, 100, 0};
        quickSort(array1);
        System.out.println(Arrays.toString(array1));

        char[] array2 = new char[] {'d', 'z', 'b', 'y'};
        quickSort(array2);
        System.out.println(Arrays.toString(array2));
    }

    // Method overloading to reduce arguments needed to call the quickSort function
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(char[] characters) {
        quickSort(characters, 0, characters.length - 1);
    }

    public static void quickSort(int[] array, int minIndex, int maxIndex) {
        // Base case for recursion
        if (minIndex >= maxIndex) return;

        int pivot = array[maxIndex];
        int minPtr = minIndex;
        int maxPtr = maxIndex - 1;

        // Rearrange array elements based on the pivot value
        while (minPtr < maxPtr) {
            while (array[minPtr] <= pivot && minPtr < maxPtr) {
                minPtr++;
            }
            while (array[maxPtr] >= pivot && maxPtr > minPtr) {
                maxPtr--;
            }
            swap(array, minPtr, maxPtr);
        }
        if (array[minPtr] > array[maxIndex]) {
            swap(array, minPtr, maxIndex);
        } else {
            minPtr = maxIndex;
        }

        // Recursive calls to quickSort
        quickSort(array, minIndex, minPtr - 1);
        quickSort(array, minPtr + 1, maxIndex);
    }

    public static void quickSort(char[] array, int minIndex, int maxIndex) {
        if (minIndex >= maxIndex) return;

        int pivot = array[maxIndex];
        int minPtr = minIndex;
        int maxPtr = maxIndex - 1;

        while (minPtr < maxPtr) {
            while (array[minPtr] <= pivot && minPtr < maxPtr) {
                minPtr++;
            }
            while (array[maxPtr] >= pivot && maxPtr > minPtr) {
                maxPtr--;
            }
            swap(array, minPtr, maxPtr);
        }
        if (array[minPtr] > array[maxIndex]) {
            swap(array, minPtr, maxIndex);
        } else {
            minPtr = maxIndex;
        }

        quickSort(array, minIndex, minPtr - 1);
        quickSort(array, minPtr + 1, maxIndex);
    }
    
    // Helper function for quickSort
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void swap(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}