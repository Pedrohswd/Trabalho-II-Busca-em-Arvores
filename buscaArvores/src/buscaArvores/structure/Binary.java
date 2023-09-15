/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import buscaArvores.util.QuickSort;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Binary {

    public static SearchResult search(String[] arr, String word) {
        int comparisons = 0;
        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            int result = word.compareTo(arr[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new SearchResult(comparisons, found);
    }
}
