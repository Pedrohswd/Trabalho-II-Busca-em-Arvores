/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import buscaArvores.SearchResult.SearchResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedBlackTree {

    public class Node {

        String key;
        Node parent;
        Node left;
        Node right;
        int color; // 0 para preto, 1 para vermelho

        public Node(String key) {
            this.key = key;
            this.color = 1; // Ao inserir, o novo nó é sempre vermelho
        }
    }
    private Node root;
    private Node TNULL;
    List<SearchResult> listResult = new ArrayList<>();
    Map<String, SearchResult> mapa = new HashMap<>();

    public Node getRoot() {
        return root;
    }
    // Inicializa a árvore com um nó nulo.
    public RedBlackTree() {
        TNULL = new Node("");
        TNULL.color = 0;
        root = TNULL;
    }

    // Preorder
    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.key + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // Inorder
    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.key + " ");
            inOrderHelper(node.right);
        }
    }

    // Pós-ordem
    private void postOrderHelper(Node node) {
        if (node != TNULL) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.key + " ");
        }
    }

    // Busca
    private Node searchTreeHelper(Node node, String key) {
        if (node == TNULL || key.equals(node.key)) {
            return node;
        }
        
        if (key.compareTo(node.key) < 0) {
            return searchTreeHelper(node.left, key);
        } else{
            return searchTreeHelper(node.right, key);
        }
    }

    // Encontra o nó mínimo
    private Node findMin(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    // Encontra o nó máximo
    private Node findMax(Node node) {
        while (node.right != TNULL) {
            node = node.right;
        }
        return node;
    }

    // Rotaciona à esquerda
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // tio
                if (u.color == 1) {
                    // Caso 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // Caso 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Caso 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // tio

                if (u.color == 1) {
                    // Caso 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // Caso 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Caso 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }
    
    public List<SearchResult> resultText() {
        listResult = new ArrayList<>(mapa.values());
        return listResult;
    }

    public SearchResult searchAlphabetical(String word) {
        return searchAlphabetical(root, word, new SearchResult(0, 0));
    }

    private SearchResult searchAlphabetical(RedBlackTree.Node node, String word, SearchResult result) {
        if (node == null) {
            return result; // A palavra não foi encontrada, retorna o resultado atual
        }

        String nodeWord = node.key; // Pega a primeira palavra na lista do nó

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

    // Insere um novo nó
    // Isso basicamente segue o procedimento de inserção em uma árvore binária de busca,
    // em seguida, chama o fixInsert para corrigir possíveis violações.
    public void insert(String key) {
        // Inicialização com um novo nó.
        Node node = new Node(key);
        node.parent = null;
        node.key = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // Novo nó deve ser vermelho
        Node y = null;
        Node x = this.root;

        // Encontrando o local correto para o novo nó.
        while (x != TNULL) {
            y = x;
            if (node.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y é pai de x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key.compareTo(y.key) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        // Se o novo nó for uma raiz, não há necessidade de chamar o fixInsert.
        if (node.parent == null) {
            node.color = 0;
            return;
        }

        // Corrigindo possíveis violações
        if (node.parent != null && node.parent.parent != null) {
            fixInsert(node);
        }
    }

    // Rotaciona à direita
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Rotaciona à esquerda
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Retorna o sucessor de um nó
    private Node findSuccessor(Node x) {
        if (x.right != TNULL) {
            return findMin(x.right);
        }

        Node y = x.parent;
        while (y != TNULL && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // Corrige a árvore após a remoção de um nó
    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    // Caso 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    // Caso 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        // Caso 3.3
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    // Caso 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    // Caso 3.1
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    // Caso 3.2
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        // Caso 3.3
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    // Caso 3.4
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    // Remove o nó com a chave 'key'
    public void delete(String key) {
        // Encontra o nó a ser removido e o substitui pelo nó 'y'
        Node z = TNULL;
        Node x, y;
        Node nodeToDelete = searchTreeHelper(this.root, key);

        if (nodeToDelete == TNULL) {
            System.out.println("A chave não foi encontrada na árvore");
            return;
        }

        z = nodeToDelete;

        int yOriginalColor = z.color;
        if (z.left == TNULL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = findMin(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    // Transplanta um nó 'u' por um nó 'v'
    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Busca
     public boolean searchTree(String k) {
        if (searchTreeHelper(this.root, k).key.compareTo(k) == 0){
            return true;
        }
        return false;
    }

    // Preorder
    public void preOrder() {
        preOrderHelper(this.root);
    }

    // Inorder
    public void inOrder() {
        inOrderHelper(this.root);
    }

    // Pós-ordem
    public void postOrder() {
        postOrderHelper(this.root);
    }

    // Encontra o nó mínimo
    public Node findMin() {
        return findMin(this.root);
    }

    // Encontra o nó máximo
    public Node findMax() {
        return findMax(this.root);
    }

    public void printRedBlackTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }

            String color = (node.color == 1) ? "RED" : "BLACK";
            System.out.println(node.key + " (" + color + ")");

            printRedBlackTree(node.left, indent, false);
            printRedBlackTree(node.right, indent, true);
        }
    }

}