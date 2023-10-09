/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package buscaArvores.view;

import buscaArvores.SearchResult.SearchResult;
import buscaArvores.structure.BTree;
import buscaArvores.structure.Binary;
import buscaArvores.structure.NotTree;
import buscaArvores.structure.NotTreePanel;
import buscaArvores.structure.RedBlackTree;
import buscaArvores.structure.Tree;
import buscaArvores.structure.TreePanel;
import buscaArvores.util.QuickSort;
import buscaArvores.util.TextFileProcessor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class vision extends javax.swing.JFrame {

    Tree tree = new Tree();
    NotTree notTree = new NotTree();
    RedBlackTree rbTree = new RedBlackTree();
    //BTree bTree = new BTree(0);

    /**
     * Creates new form vision
     */
    public vision() {
        initComponents();
        setLocationRelativeTo(null);
        jTextField1.setEditable(false);
        jTextArea2.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButtonImport = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButtonGenerate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableOcorrencias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonImport.setText("Importar");
        jButtonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jButtonGenerate.setText("Gerar");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButton3.setText("Visualizar Árvore AVL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableOcorrencias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableOcorrencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Palavra", "Frequencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableOcorrencias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableOcorrencias.setGridColor(new java.awt.Color(0, 0, 0));
        jTableOcorrencias.setRowHeight(50);
        jTableOcorrencias.setShowGrid(true);
        jTableOcorrencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOcorrenciasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableOcorrencias);

        jButton1.setText("Visualizar Árvore Não AVL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonImport, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(52, 52, 52)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);
        File arquivo = fc.getSelectedFile();

        jTextField1.setText(arquivo + "");
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        jTextArea2.setText("");
        //Comparator<SearchResult> comparator = (result1, result2) -> result1.getWord().compareToIgnoreCase(result2.getWord());
        List<SearchResult> searchResults = new ArrayList<>();
        TextFileProcessor tFProcessor = new TextFileProcessor();
        String caminho = jTextField1.getText();
        if ("null".equals(caminho) || jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escolha um arquivo primeiro");
            return;
        }
        List<String> wordList = tFProcessor.verification(jTextField1.getText());

        //binária
        long ti, tf;
        long ni, nf;
        double tt, nt;
        long comparacoes = 0;
        ti = System.nanoTime();
        ni = System.nanoTime();
        comparacoes = tFProcessor.listToArray(wordList);
        tf = System.nanoTime();
        nf = System.nanoTime();
        tt = (tf - ti) / 1000000000.0;
        nt = nf - ni;
        String segundosFormatados = String.format("%.8f", tt);
        String milisegundosFormatados = String.format("%.2f", nt);
        String saida = ("Busca Binária\n"
                + " Comparações: " + comparacoes + "\n"
                + " Segundos: " + segundosFormatados + "\n"
                + " Nanosegundos: " + milisegundosFormatados);
        ti = 0;
        ni = 0;
        tf = 0;
        nf = 0;

        //arvore sem balanceamento
        System.out.println("ARVORE SEM BALANCEAMENTO");
        comparacoes = 0;
        ti = System.nanoTime();
        ni = System.nanoTime();
        comparacoes = notTree.readTxt(wordList);
        System.out.println("COMPARAÇÕES: " + comparacoes);
        tf = System.nanoTime();
        nf = System.nanoTime();
        tt = (tf - ti) / 1000000000.0;
        nt = nf - ni;
        segundosFormatados = String.format("%.8f", tt);
        milisegundosFormatados = String.format("%.2f", nt);
        saida += ("\n\nBusca Arvore\n"
                + " Comparações: " + comparacoes + "\n"
                + " Segundos: " + segundosFormatados + "\n"
                + " Nanosegundos: " + milisegundosFormatados);
        ti = 0;
        ni = 0;
        tf = 0;
        nf = 0;

        //arvore AVL
        comparacoes = 0;
        ti = System.nanoTime();
        ni = System.nanoTime();
        comparacoes = tree.readTxt(wordList);
        System.out.println("COMPARAÇÕES: " + comparacoes);
        tf = System.nanoTime();
        nf = System.nanoTime();
        tt = (tf - ti) / 1000000000.0;
        nt = nf - ni;
        segundosFormatados = String.format("%.8f", tt);
        milisegundosFormatados = String.format("%.2f", nt);
        saida += ("\n\nBusca Arvore AVL\n"
                + " Comparações: " + comparacoes + "\n"
                + " Segundos: " + segundosFormatados + "\n"
                + " Nanosegundos: " + milisegundosFormatados);

        ti = 0;
        ni = 0;
        tf = 0;
        nf = 0;
        //arvore RB
        comparacoes = 0;
        ti = System.nanoTime();
        ni = System.nanoTime();
        comparacoes = rbTree.readTxt(wordList);
        System.out.println("COMPARAÇÕES: " + comparacoes);
        tf = System.nanoTime();
        nf = System.nanoTime();
        tt = (tf - ti) / 1000000000.0;
        nt = nf - ni;
        segundosFormatados = String.format("%.8f", tt);
        milisegundosFormatados = String.format("%.2f", nt);
        saida += ("\n\nBusca Arvore Rubro-Negra\n"
                + " Comparações: " + comparacoes + "\n"
                + " Segundos: " + segundosFormatados + "\n"
                + " Nanosegundos: " + milisegundosFormatados);
        

    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jTableOcorrenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOcorrenciasMouseClicked

    }//GEN-LAST:event_jTableOcorrenciasMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        SwingUtilities.invokeLater(() -> {
            Tree.Node root = tree.getRoot();
            TreePanel treePanel = new TreePanel(root);
            JFrame frame = new JFrame("Árvore AVL Alfabética");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(treePanel);
            frame.setSize(1920, 1080);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        SwingUtilities.invokeLater(() -> {
            NotTree.Node root = notTree.getRoot();
            NotTreePanel nottreePanel = new NotTreePanel(root);
            JFrame frame = new JFrame("Árvore Não AVL");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(nottreePanel);
            frame.setSize(1920, 1080);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonImport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableOcorrencias;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
