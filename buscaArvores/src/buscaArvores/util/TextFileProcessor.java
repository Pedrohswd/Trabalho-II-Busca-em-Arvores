/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.util;

import buscaArvores.SearchResult.SearchResult;
import buscaArvores.structure.Binary;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class TextFileProcessor {

    public static List<String> verification(String fileName) {
        Set<String> stopwords = loadStopwords("./src/buscaArvores/stopwords/stopwords.txt");
        List<String> wordsList = processTextFile(fileName, stopwords);
        return wordsList;
    }

    private static Set<String> loadStopwords(String stopwordsFile) {
        Set<String> stopwords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(stopwordsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stopwords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopwords;
    }

    private static List<String> processTextFile(String fileName, Set<String> stopwords) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remover pontuação e converter para minúsculas
                line = line.replaceAll("[\\p{Punct}]", "").toLowerCase();

                // Dividir a linha em palavras usando espaços como separadores
                String[] words = line.split("\\s+");

                // Processar cada palavra
                for (String word : words) {
                    // Verificar se a palavra não é uma stopword
                    if (!stopwords.contains(word)) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }

    public int listToArray(List<String> list) {
        if (list == null) {
            return 0;
        }
        String[] dynamicArray = new String[1];
        Map<String, SearchResult> mapa = new HashMap<>();
        int size = 0;
        int cont = 0;

        // Adicionar elementos ao vetor
        for (String word : list) {

            SearchResult sr = null;
            String teste = dynamicArray[0];
            if (teste == null) {
                sr = new SearchResult(1, false);
            } else {
                QuickSort.quickSort(dynamicArray);
                sr = Binary.search(dynamicArray, word);
            }

            if (sr.isSearch() == false) {
                if (size == dynamicArray.length) {
                    String[] newDynamicArray = new String[dynamicArray.length * 1]; // Dobrar o tamanho
                    System.arraycopy(dynamicArray, 0, newDynamicArray, 0, size);
                    dynamicArray = newDynamicArray;
                }
                dynamicArray[size] = word;
                sr.setWord(word);
                sr.setOccurrences(1);
                mapa.put(word, sr);
                cont += sr.getComparisons();
                size++;
            } else {
                sr = mapa.get(word);
                sr.setOccurrences(sr.getOccurrences() + 1);
                mapa.put(word, sr);
                cont += mapa.get(word).getComparisons();
            }

        }
        return cont;

    }

}
