import cofetarie.Cofetarie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaPrajitura {   //Singleton
        private JButton confirma;
        private JTextField textField1;
        private JTextField textField2;
        private JPanel panel;
        private JLabel titlu;
        private JLabel mesaj;
        private String nume;
        private int pret;
        private JFrame frame;
        private static AdaugaPrajitura instance;
        private Cofetarie cof=Cofetarie.getInstance();
        private AdaugaPrajitura() {
                frame = new JFrame("Cofetarie");
                ImageIcon image = new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500, 500);
                frame.setVisible(true);

                confirma.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                nume=textField1.getText();
                                if (nume.equals(""))
                                        JOptionPane.showMessageDialog(null, "Nu ati introdus numele.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                else {
                                        nume = textField1.getText();
                                }
                                try {
                                        pret = Integer.parseInt(textField2.getText());
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Introduceti un pret.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                }
                                if (!Operatii.verifica(cof,nume)) {
                                        Operatii.add(cof, textField1, textField2, nume, pret);
                                        mesaj.setText("Prajitura a fost adaugata cu succes!");
                                }
                                else mesaj.setText("Prajitura deja exista in meniu.Va rugam alegeti alt nume.");
                        }
                });
        }
        public static AdaugaPrajitura getInstance(){
                if(null==instance)
                        instance=new AdaugaPrajitura();
                return instance;
        }
}