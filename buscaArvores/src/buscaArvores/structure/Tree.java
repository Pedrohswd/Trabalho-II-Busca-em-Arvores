/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package buscaArvores.structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author pedro
 */
public class Tree {

    public class Node {

        char letter;
        int height;
        Node left;
        Node right;
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
        return rebalance(node);
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
        if (node != null) {
            node = rebalance(node);
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

    public boolean search(String word) {
        char firstLetter = word.charAt(0);
        Node node = find(firstLetter);
        if (node != null) {
            for (String w : node.words) {
                if (w.equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

}
