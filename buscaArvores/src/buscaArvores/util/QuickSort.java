/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.util;

import java.util.List;

/**
 *
 * @author pedro
 */
public class QuickSort {

    public static void quickSort(String[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(String[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(String[] arr, int left, int right) {
        String pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String chave = arr[i];
            int j = i - 1;

            // Move os elementos do arr[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j].compareTo(chave) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = chave;
        }
    }
}
