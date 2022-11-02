import cofetarie.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugareClient {
        private JButton confirmaButton;
        private JTextField numeField;
        private JTextField adresaField;
        private JTextField telefonField;
        private JLabel nume;
        private JPanel panel;

        public AdaugareClient(){
                JFrame frame=new JFrame("Cofetarie");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                //validare date
                confirmaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String nume=numeField.getText();
                                String adresa=adresaField.getText();
                                String telefon=telefonField.getText();
                                Client client=new Client(nume,adresa,telefon);
                                frame.dispose();
                        }
                });


        }
}
