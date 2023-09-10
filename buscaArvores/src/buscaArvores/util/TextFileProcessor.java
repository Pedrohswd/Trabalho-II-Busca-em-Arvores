/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 *
 * @author pedro
 */
public class TextFileProcessor {

    public static List<String> verification(String fileName) {
        Set<String> stopwords = loadStopwords("./src/buscaArvores/stopwords/stopwords.txt");
        List<String> wordsList = processTextFile(fileName, stopwords);

//        for (String word : wordsList) {
//            System.out.println(word);
//        }
        return wordsList;
    }

    private static Set<String> loadStopwords(String stopwordsFile) {
        Set<String> stopwords = new HashSet<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(stopwordsFile))) {
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
        try ( BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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

    public static String[] listToArray(List<String> list) {
        if (list == null) {
            return null;
        }
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
