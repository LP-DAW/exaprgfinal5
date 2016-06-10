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

      jl1 = new JLabel("Id Examen");
      jl2 = new JLabel("Nombre examen");
      jl3 = new JLabel("Id Curso");
      jl4 = new JLabel("Nombre curso");

      jp2 = new JPanel();
      jp2.setLayout(new GridLayout(4, 0));
      jp2.add(jl1);
      jp2.add(jl2);
      jp2.add(jl3);
      jp2.add(jl4);

      jtf1 = new JTextField(4);
      jtf2 = new JTextField(25);
      jtf3 = new JTextField(4);
      jtf4 = new JTextField(25);
      jtf4.setEnabled(false);

      jp3 = new JPanel();
      jp3.add(jtf1);
      jp3.add(jtf2);
      jp3.add(jtf3);
      jp3.add(jtf4);
      jp3.setLayout(new GridLayout(4, 0));

      jp1 = new JPanel();
      jp1.setLayout(new FlowLayout(0, 2, 2));
      add(jp1);
      jp1.add(jp2);
      jp1.add(jp3);

      jb1 = new JButton("Grabar");
      jb2 = new JButton("Salir");
      jp4 = new JPanel();
      jp4.setLayout(new FlowLayout(0, 2, 2));
      jp4.add(jb1);
      jp4.add(jb2);

      jp5 = new JPanel();
      add(jp5);
      jp5.setLayout(new GridLayout(2, 0));
      jp5.add(jp1);
      jp5.add(jp4);

      setSize(500, 200); // Ancho, Alto
      setLocationRelativeTo(null);
      //setVisible(true);
      //pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra Aplicacion

   }

   public JButton getjb1() {
      return jb1;
   }

   public JButton getjb2() {
      return jb2;
   }

   public JTextField getjtf1() {
      return jtf1;
   }

   public JTextField getjtf2() {
      return jtf2;
   }

   public JTextField getjtf3() {
      return jtf3;
   }

   public JTextField getjtf4() {
      return jtf4;
   }

}
