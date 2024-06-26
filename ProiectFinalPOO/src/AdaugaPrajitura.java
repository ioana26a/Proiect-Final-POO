import cofetarie.Cofetarie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaPrajitura {
        private JButton confirma;
        private JTextField textField1;
        private JTextField textField2;
        private JPanel panel;
        private JLabel titlu;
        private JLabel mesaj;
        private String nume;
        private int pret;
        private JFrame frame;
        private Cofetarie cof=Cofetarie.getInstance();
        public AdaugaPrajitura() {
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
                                nume = textField1.getText();
                                if (nume.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Nu ati introdus numele.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                nume = textField1.getText();
                                if (textField2.getText().equals("")) {
                                        JOptionPane.showMessageDialog(null, "Nu ati introdus pretul.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                try {
                                        pret = Integer.parseInt(textField2.getText());
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Introduceti un pret.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                if (!Operatii.verifica(cof, nume)) {
                                        if(pret<1){
                                                mesaj.setText("Pretul este incorect.Va rugam incercati din nou.");
                                        }else {
                                                Operatii.add(cof,textField1,textField2,nume,pret);
                                                mesaj.setText("Prajitura adaugata cu succes!");
                                        }
                                } else mesaj.setText("Prajitura deja exista in meniu.Va rugam alegeti alt nume.");
                        }
                });
                mesaj.setText("");
                textField1.setText("");
                textField2.setText("");
        }
}