/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pedro
 */
public class NotTree {

    public class Node {

        String word;
        int height;
        Node left;
        Node right;
        TreeSet<String> words;
        public String getValue;
        private String value;

        Node(String word) {
            this.word = word;
        }

    }

    private Node root;

    public void insert(String word) {
        root = insert(root, word);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, String word) {
        TreeSet<String> words = new TreeSet<>();
        if (node == null) {
            return new Node(word);
        } else {
            words.add(word);
            words.add(node.word);
        }
        if (!words.first().equals(node.word)) {
            node.left = insert(node.left, word);
        } else if (words.first().equals(node.word)) {
            node.right = insert(node.right, word);
        } else {
            throw new RuntimeException("Duplicate letter!");
        }
        return node;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    public void printDictionary(Node node) {
        if (node != null) {
            printDictionary(node.left);
            System.out.print(node.word);
            System.out.println();
            printDictionary(node.right);
        }
    }

    public void print() {
        printDictionary(root);
    }

    public void verifica(String caminho) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminho));
            String line = reader.readLine();
            int lineNumber = 1;
            int emptyLineCount = 0;
            while (line != null) {
                if (line.isEmpty()) {
                    System.out.println("Linha vazia encontrada na linha " + lineNumber);
                    emptyLineCount++;
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
            System.out.println("Número total de linhas vazias: " + emptyLineCount);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
            e.printStackTrace();
        }
    }

    public void readTxt(List<String> wordsList) {
        int cont = 0;
        for (String word : wordsList) {
            if (!word.isEmpty()) {  // Verifica se a palavra não está vazia
                insert(word);
                cont++;
            }
        }
        System.out.println("Total de palavras inseridas na árvore: " + cont);
        System.out.println("");

    }

    public SearchResult searchAlphabetical(String word) {
        return searchAlphabetical(root, word, new SearchResult(0, 0));
    }

    private SearchResult searchAlphabetical(NotTree.Node node, String word, SearchResult result) {
        if (node == null) {
            return result; // A palavra não foi encontrada, retorna o resultado atual
        }

        String nodeWord = node.word; // Pega a primeira palavra na lista do nó

        // Incrementa o contador de comparações
        result = new SearchResult(result.getComparisons() + 1, result.getOccurrences());

        int comparisonResult = word.compareTo(nodeWord);

        if (comparisonResult == 0) {
            return result;
        }

        if (comparisonResult < 0) {
            return searchAlphabetical(node.left, word, result); // Busca na subárvore esquerda
        } else {
            return searchAlphabetical(node.right, word, result); // Busca na subárvore direita
        }
    }
}
