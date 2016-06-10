/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaExamen extends JFrame {

   private JPanel jp1;
   private JPanel jp2;
   private JPanel jp3;
   private JPanel jp4;
   private JPanel jp5;

   private JLabel jl1;
   private JLabel jl2;
   private JLabel jl3;
   private JLabel jl4;

   private JButton jb1;
   private JButton jb2;

   private JTextField jtf1;
   private JTextField jtf2;
   private JTextField jtf3;
   private JTextField jtf4;

   public VistaExamen() {
      super("Examen");
      initComponents();
   }

   private void initComponents() {

      //TODO

      setSize(500, 200); // Ancho, Alto
      setLocationRelativeTo(null);
      //setVisible(true);
      //pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra Aplicacion

   }
}
