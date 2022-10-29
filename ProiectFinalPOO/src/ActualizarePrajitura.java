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
        private JTextField textField1;
        private JTextField textField2;
        private JButton confirmaButton;
        private JLabel numetxt,prettxt;
        private int pret;

        public ActualizarePrajitura(Prajitura p){
                JFrame frame = new JFrame("Cofetarie");
                ImageIcon image = new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500, 500);
                frame.setVisible(true);
                numeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String s = textField1.getText();
                                if(s.equals(""))
                                        JOptionPane.showMessageDialog(null, "Nu ati introdus numele.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                else {
                                        p.setNume(s);
                                        numetxt.setText("Nume actualizat cu succes.");
                                }

                        }
                });
                pretButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                try{
                                        pret = Integer.parseInt(textField2.getText());
                                        p.setPret(pret);
                                        prettxt.setText("Pret actualizat cu succes.");
                                }catch (NumberFormatException ex){
                                        JOptionPane.showMessageDialog(null, "Pretul nu este introdus corect.Va rugam incercati din nou",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
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
