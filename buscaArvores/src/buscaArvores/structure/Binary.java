/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Binary {

    public static SearchResult binarySearchCount(String[] sortedArray, String key) {
        int left = 0;
        int right = sortedArray.length - 1;
        int comparisons = 0; // Inicializa o contador de comparações
        int occurrences = 0; // Inicializa o contador de ocorrências

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = key.compareTo(sortedArray[mid]);
            comparisons++; // Incrementa o contador de comparações

            if (comparisonResult == 0) {
                occurrences++; // Incrementa o contador de ocorrências
                // Continue a busca binária para verificar mais ocorrências
                int leftIndex = mid - 1;
                int rightIndex = mid + 1;

                while (leftIndex >= 0 && sortedArray[leftIndex].equals(key)) {
                    occurrences++;
                    leftIndex--;
                }

                while (rightIndex < sortedArray.length && sortedArray[rightIndex].equals(key)) {
                    occurrences++;
                    rightIndex++;
                }

                return new SearchResult(comparisons, occurrences); // Retorna o resultado
            } else if (comparisonResult < 0) {
                right = mid - 1; // A chave está à esquerda
            } else {
                left = mid + 1; // A chave está à direita
            }
        }

        return new SearchResult(comparisons, occurrences); // Retorna o resultado (0 ocorrências)
    }
}
