/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.structure;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RedBlackTreePanel extends JPanel {

    private RedBlackTree.Node key;
    double i = 1;

    public RedBlackTreePanel(RedBlackTree.Node key) {
        this.key = key;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Use a implementação da árvore rubro-negro para desenhar os nós e conexões da árvore.
        int panelWidth = getWidth(); // Largura do painel
        int panelHeight = getHeight(); // Altura do painel

        int startX = panelWidth / 2;
        int startY = 30;

        int fontSize = 14; // Tamanho da fonte inicial
        g.setFont(new Font("Arial", Font.PLAIN, fontSize)); // Define a fonte inicial

        drawTree(g, startX, startY, panelWidth / 4, fontSize, key); // Dividindo a largura por 4 para ajustar o espaçamento
    }

    private void drawTree(Graphics g, int startX, int startY, int i, int fontSize, RedBlackTree.Node key) {
        if (key == null) {
            return;
        }

        int circleSize = 30;

        // Desenhe o nó atual
        //g.drawOval(x - circleSize / 2, y - circleSize / 2, circleSize, circleSize);
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        //g.drawString(node.word, x - circleSize / 2 + 15, y - circleSize / 2 + 15);

        // Calcule as coordenadas para os filhos
        int yOffset = 60; // Espaçamento vertical entre os níveis da árvore

        // Reduza o tamanho da fonte à medida que você desce na árvore
        if (i % 2 == 0) {
            i++;
            fontSize -= 1; // Valor de redução de tamanho da fonte
        }
        // Desenhe as conexões e nós da esquerda e direita
        if (key.left != null) {
            //int childWidth = width / 2;
            //g.drawLine(x, y, x - childWidth, y + yOffset);
            //drawTree(g, x - childWidth, y + yOffset, childWidth, fontSize, node.left);
        }
        if (key.right != null) {
            //int childWidth = width / 2;
            //g.drawLine(x, y, x + childWidth, y + yOffset);
            //drawTree(g, x + childWidth, y + yOffset, childWidth, fontSize, node.right);

        }
    }
}
