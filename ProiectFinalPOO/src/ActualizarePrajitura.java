import cofetarie.Cofetarie;
import cofetarie.Prajitura;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarePrajitura {
        private JLabel titlu;
        private JPanel panel;
        private JButton numeButton;
        private JButton pretButton;
        private JTextField nume;
        private JTextField pretField;
        private JButton confirmaButton;
        private JLabel numetxt,prettxt;
        private int pret;
        private Cofetarie cof;

        public ActualizarePrajitura(Prajitura p){
                JFrame frame = new JFrame("Cofetarie");
                ImageIcon image = new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500, 500);
                frame.setVisible(true);
                nume.setText(p.getNume());
                pretField.setText(String.valueOf(p.getPret()));
                numeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                cof=Cofetarie.getInstance();
                                String s = nume.getText();
                                if(s.equals(""))
                                        numetxt.setText("Va rugam introduceti un nume.");
                                else {
                                        if (!Operatii.verifica(cof,s)) {
                                                p.setNume(s);
                                                numetxt.setText("Nume actualizat cu succes.");
                                        }
                                        else numetxt.setText("Prajitura deja exista in meniu.Va rugam alegeti alt nume.");
                                }
                        }
                });
                pretButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try{
                                        pret = Integer.parseInt(pretField.getText());
                                }catch (NumberFormatException ex){
                                        prettxt.setText("Pretul este incorect.Va rugam incercati din nou.");
                                }
                                if(pret<1)
                                        prettxt.setText("Pretul este incorect.Va rugam incercati din nou.");
                                else {
                                        p.setPret(pret);
                                        prettxt.setText("Pret actualizat cu succes.");
                                }
                        }
                });
                confirmaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                        }
                });
        }



}
