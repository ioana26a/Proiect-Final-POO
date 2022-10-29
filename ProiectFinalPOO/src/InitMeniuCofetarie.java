import cofetarie.Cofetarie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitMeniuCofetarie {
        private JTextField textField1;
        private JTextField textField2;
        private JButton confirmaButton;
        private JPanel panel;
        private JLabel mesaj;
        private String nume;
        private int pret;
        private JFrame frame;
        private int numarPrajituri=0;
        public InitMeniuCofetarie(){
                frame=new JFrame("Cofetarie");
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
        }
        public void action(Cofetarie cof,int n) {
                confirmaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (textField1.getText().equals(""))
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
                                if(numarPrajituri!=n){
                                        if (!Operatii.verifica(cof,nume)){
                                                Operatii.add(cof,textField1,textField2,nume,pret);
                                                mesaj.setText("Prajitura adaugata cu succes!");
                                                numarPrajituri++;
                                        }
                                        else mesaj.setText("Prajitura deja exista in meniu.Va rugam alegeti alt nume.");
                                }
                                if (numarPrajituri == n) {
                                        frame.dispose();
                                }
                        }
                });
        }
}
