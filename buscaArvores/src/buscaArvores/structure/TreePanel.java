/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author pedro
 */

public class TreePanel extends JPanel {
    private Tree.Node root;

    public TreePanel(Tree.Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Use a implementação da árvore AVL para desenhar os nós e conexões da árvore.
        drawTree(g, getWidth() / 2, 30, root);
    }

    private void drawTree(Graphics g, int x, int y, Tree.Node node) {
        if (node == null) {
            return;
        }

        int circleSize = 30;

        // Desenhe o nó atual
        g.drawOval(x - circleSize / 2, y - circleSize / 2, circleSize, circleSize);
        g.drawString(node.letter + ": ", x - circleSize / 2, y - circleSize / 2);
        int i = 0;
        circleSize = 30*(i*2);
        for (String word : node.words) {
            g.drawString(word, x - circleSize / 2*2+15*(i+1), y - circleSize / 2 + 15 * (i + 1));
            i++;
        }

        // Calcule as coordenadas para os filhos
        int xOffset = 100; // Espaçamento horizontal entre os nós
        int yOffset = 60;  // Espaçamento vertical entre os níveis da árvore

        // Desenhe as conexões e nós da esquerda e direita
        if (node.left != null) {
            g.drawLine(x, y, x - xOffset, y + yOffset);
            drawTree(g, x - xOffset, y + yOffset, node.left);
        }
        if (node.right != null) {
            g.drawLine(x, y, x + xOffset, y + yOffset);
            drawTree(g, x + xOffset, y + yOffset, node.right);
        }
    }
}
