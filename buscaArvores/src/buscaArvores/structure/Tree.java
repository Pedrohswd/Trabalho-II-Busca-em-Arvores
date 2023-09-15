/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pedro
 */
public class Tree {

    List<SearchResult> listResult = new ArrayList<>();
    Map<String, SearchResult> mapa = new HashMap<>();

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
        return rebalance(node);
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
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

    public int readTxt(List<String> wordsList) {
        int cont = 0;

        for (String word : wordsList) {
            if (!word.isEmpty()) {
                SearchResult sr = searchAlphabetical(word);
                if (sr.isSearch() == false) {
                    insert(word);
                    sr.setWord(word);
                    sr.setOccurrences(1);
                    mapa.put(word, sr);
                    cont += sr.getComparisons();
                } else {
                    sr = mapa.get(word);
                    sr.setOccurrences(sr.getOccurrences() + 1);
                    mapa.put(word, sr);
                    cont += mapa.get(word).getComparisons();
                }
            }
        }

        return cont;
    }

    public List<SearchResult> resultText() {
        listResult = new ArrayList<>(mapa.values());
        return listResult;
    }

    public SearchResult searchAlphabetical(String word) {
        return searchAlphabetical(root, word, new SearchResult(0, 0));
    }

    private SearchResult searchAlphabetical(Tree.Node node, String word, SearchResult result) {
        if (node == null) {
            return result; // A palavra não foi encontrada, retorna o resultado atual
        }

        String nodeWord = node.word; // Pega a primeira palavra na lista do nó

        // Incrementa o contador de comparações
        result = new SearchResult(result.getComparisons() + 1, false);

        int comparisonResult = word.compareTo(nodeWord);

        if (comparisonResult == 0) {
            // A palavra foi encontrada, incrementa o contador de ocorrências
            result.setSearch(true);
            return result;
        }

        if (comparisonResult < 0) {
            return searchAlphabetical(node.left, word, result); // Busca na subárvore esquerda
        } else {
            return searchAlphabetical(node.right, word, result); // Busca na subárvore direita
        }
    }
}
