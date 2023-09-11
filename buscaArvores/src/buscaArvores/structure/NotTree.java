/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author pedro
 */
public class NotTree {

    public class Node {

        char letter;
        int height;
        Node left;
        Node right;
        String value;
        TreeSet<String> words;  // Use TreeSet for alphabetical order

        Node(char letter) {
            this.letter = letter;
            this.words = new TreeSet<>();  // Initialize as a TreeSet
        }
    }

    private Node root;

    public Node find(char letter) {
        Node current = root;
        while (current != null) {
            if (current.letter == letter) {
                break;
            }
            current = current.letter < letter ? current.right : current.left;
        }
        return current;
    }

    public void insert(char letter, String word) {
        Node node = find(letter);
        if (node == null) {
            root = insert(root, letter);
            node = find(letter);
        }
        node.value = word;
        node.words.add(word);
    }

    public void delete(char letter, String word) {
        Node node = find(letter);
        if (node != null) {
            node.words.remove(word);
            if (node.words.isEmpty()) {
                root = delete(root, letter);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, char letter) {
        if (node == null) {
            return new Node(letter);
        } else if (node.letter > letter) {
            node.left = insert(node.left, letter);
        } else if (node.letter < letter) {
            node.right = insert(node.right, letter);
        } else {
            throw new RuntimeException("Duplicate letter!");
        }
        return node;
    }

    private Node delete(Node node, char letter) {
        if (node == null) {
            System.out.println("passei aqui");
            return node;
        } else if (node.letter > letter) {
            node.left = delete(node.left, letter);
        } else if (node.letter < letter) {
            node.right = delete(node.right, letter);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.letter = mostLeftChild.letter;
                node.right = delete(node.right, node.letter);
            }
        }
        System.out.println("passei aqui");
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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
            System.out.print(node.letter + ": ");
            for (String word : node.words) {
                System.out.println(word);
            }
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
                char firstLetter = word.charAt(0);
                insert(firstLetter, word);
                cont++;
            }
        }
        System.out.println("Total de palavras inseridas na árvore: " + cont);
        System.out.println("");

    }

    public SearchResult searchAlphabetical(String word) {
        return searchAlphabetical(root, word, new SearchResult(0, 0));
    }

    private SearchResult searchAlphabetical(Node node, String word, SearchResult result) {
        if (node == null) {
            return result; // A palavra não foi encontrada, retorna o resultado atual
        }

        String nodeWord = node.words.first(); // Pega a primeira palavra na lista do nó

        // Incrementa o contador de comparações
        result = new SearchResult(result.getComparisons() + 1, result.getOccurrences());

        int comparisonResult = word.compareTo(nodeWord);

        if (comparisonResult == 0) {
            // A palavra foi encontrada, incrementa o contador de ocorrências
            result = new SearchResult(result.getComparisons(), result.getOccurrences() + node.words.size());
        }

        if (comparisonResult < 0) {
            return searchAlphabetical(node.left, word, result); // Busca na subárvore esquerda
        } else {
            return searchAlphabetical(node.right, word, result); // Busca na subárvore direita
        }
    }
}
