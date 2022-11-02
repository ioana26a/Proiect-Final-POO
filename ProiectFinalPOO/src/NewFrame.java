import cofetarie.Cofetarie;
import cofetarie.Prajitura;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame {
        private JLabel titlu;
        private JButton initializareMeniuButton;
        private JButton vizualizareMeniuButton;
        private JButton adaugarePrajituraButton;
        private JButton numarulDePrajituriButton;
        private JButton actualizarePrajituraButton;
        private JPanel newPanel;
        private JLabel nrPrajituri;
        private JTextField nrInit;
        private JTextField actualizare;
        private JLabel locatie;
        private JButton inapoi;
        private JButton initializarePrajituriButton;
        private JLabel mesaj;
        private static int  n=0;
        private Cofetarie cof=Cofetarie.getInstance();
        private boolean flag=false;
        public NewFrame(Cofetarie cof){                   //MENIU
                JFrame frame=new JFrame("Cofetarie");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(newPanel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                titlu.setText("Cofetaria " + cof.getNume());
                locatie.setText(cof.getLocatie());
                initializareMeniuButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if(flag==false){
                                        int prajituri = cof.getMeniuCofetarie().size();
                                        try {
                                                n = Integer.parseInt(nrInit.getText());
                                        } catch (NumberFormatException ex) {
                                                JOptionPane.showMessageDialog(null, "Introduceti un numar.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        if (n < 1 || n > 20) {
                                                JOptionPane.showMessageDialog(null, "Va rugam introduceti un numar cuprins intre 1 si 20.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                        } else if (prajituri == 0) {
                                                InitMeniuCofetarie i = new InitMeniuCofetarie();
                                                i.action(cof,n);
                                        } else if (prajituri!=n) {
                                                InitMeniuCofetarie i = new InitMeniuCofetarie();
                                                i.action(cof,n-prajituri);
                                        } else {
                                                JOptionPane.showMessageDialog(null, "Meniul este deja initializat.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                                initializareMeniuButton.setEnabled(false);
                                        }
                                }
                                else {
                                        JOptionPane.showMessageDialog(null, "Meniul este deja initializat.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        initializareMeniuButton.setEnabled(false);
                                }

                        }
                });
                vizualizareMeniuButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                AfisareMeniu a=new AfisareMeniu(cof);
                        }
                });
                adaugarePrajituraButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                AdaugaPrajitura p=new AdaugaPrajitura();
                                flag=true;
                        }
                });
                numarulDePrajituriButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                StringBuffer s=new StringBuffer("In cofetarie exista ");
                                s.append(Prajitura.getNrPrajituri() + " prajituri. ");
                                nrPrajituri.setText(String.valueOf(s));
                        }
                });
                actualizarePrajituraButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String nume = actualizare.getText();
                                Prajitura p=cautare(nume);
                                if (nume.equals(""))
                                        JOptionPane.showMessageDialog(null, "Nu ati introdus numele.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                else if(cautare(nume)!=null){
                                        ActualizarePrajitura a = new ActualizarePrajitura(p);
                                }
                                else JOptionPane.showMessageDialog(null, "Prajitura nu exista",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                        }
                });
                inapoi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Optiune op=new Optiune();
                                frame.dispose();
                        }
                });
                initializarePrajituriButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Read r=new Read();
                                r.citirePrajituri(cof);
                                if(Prajitura.getNrPrajituri()!=0){
                                        flag=true;
                                        mesaj.setText("Prajiturile au fost adaugate cu succes.");
                                }
                                else mesaj.setText("Eroare la citirea fisierului cu prajituri");
                        }
                });
        }
        public Prajitura cautare(String nume){
                for (Prajitura p:cof.getMeniuCofetarie()) {
                        if(p.getNume().equals(nume))
                                return p;
                }
                return null;
        }
}
