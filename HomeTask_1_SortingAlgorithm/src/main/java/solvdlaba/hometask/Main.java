package solvdlaba.hometask;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = {5, 400, 33, -2, 100, 0};
        quickSort(array1);
        System.out.println(Arrays.toString(array1));

        Character[] array2 = {'d', 'z', 'b', 'y'};
        quickSort(array2);
        System.out.println(Arrays.toString(array2));
    }

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int minIndex, int maxIndex) {
        // Base case for recursion
        if (minIndex >= maxIndex) return;

        T pivot = array[maxIndex];
        int minPtr = minIndex;
        int maxPtr = maxIndex - 1;

        // Rearrange array elements based on the pivot value
        while (minPtr < maxPtr) {
            while (array[minPtr].compareTo(pivot) <= 0 && minPtr < maxPtr) {
                minPtr++;
            }
            while (array[maxPtr].compareTo(pivot) >= 0 && maxPtr > minPtr) {
                maxPtr--;
            }
            swap(array, minPtr, maxPtr);
        }
        if (array[minPtr].compareTo(array[maxIndex]) > 0) {
            swap(array, minPtr, maxIndex);
        } else {
            minPtr = maxIndex;
        }

        // Recursive calls to quickSort
        quickSort(array, minIndex, minPtr - 1);
        quickSort(array, minPtr + 1, maxIndex);
    }

    // Helper function for quickSort
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}