import cofetarie.Client;
import cofetarie.Cofetarie;
import cofetarie.Comanda;
import cofetarie.Prajitura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AlegePrajitura {
        private final Cofetarie cof=Cofetarie.getInstance();
        private JPanel panel;
        private JList list1;
        private JTextField numePrajitura;
        private JButton adaugaButton;
        private JLabel titlu;
        private JLabel mesaj;
        private JLabel info;
        private JButton confirmaButton;
        private boolean flag=false;
        public AlegePrajitura(Comanda com){
                JFrame frame=new JFrame("Cofetarie");
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                String s = "Meniu  " + cof.getNume();
                titlu.setText(s);
                Vector prajituri =new Vector(cof.getMeniuCofetarie());
                list1.setListData(prajituri);
                list1.setBackground(Color.pink);
                adaugaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               String nume = numePrajitura.getText();
                                Prajitura p=Operatii.verificaPrajitura(cof,nume);
                                //validare nume si cautare
                                if(p!=null) {
                                        com.adaugarePrajitura(p);
                                        flag=true;
                                        mesaj.setText("Prajitura a fost adaugata in comanda.");
                                }
                                else mesaj.setText("Prajitura nu exista in meniu.");
                        }
                });
                confirmaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if(flag==false){
                                        JOptionPane.showMessageDialog(null, "Comanda nu are prajituri.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                        com.suma();
                                        System.out.println(com.toString());
                                        frame.dispose();
                                        Read r=new Read();
                                        r.scriereComanda(com);
                                        JOptionPane.showMessageDialog(null,"Comanda a fost plasata cu succes.",
                                                "Confirmare comanda",JOptionPane.PLAIN_MESSAGE);
                                }

                        }
                });

                //daca nu se adauga nici o prajitura atunci sa se stearga ref la comanda
        }
}
