import cofetarie.Client;
import cofetarie.Cofetarie;
import cofetarie.Comanda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugareComanda {
        private JPanel panel;
        private JLabel titlu;
        private JTextField numarTelefon;
        private JTextField numarComanda;
        private JButton confirmaButton;
        private Cofetarie cof=Cofetarie.getInstance();
        public AdaugareComanda(){
                JFrame frame=new JFrame("Cofetarie");
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                confirmaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Comanda com=new Comanda();
                                int nrComanda;

                                String telefon=numarTelefon.getText();
                                try {
                                        nrComanda = Integer.parseInt(numarComanda.getText());
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Numar incorect.Va rugam incercati din nou.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                if(telefon.length()!=10){
                                        JOptionPane.showMessageDialog(null, "Numar de telefon incorect.Va rugam incercati din nou.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                if(telefon.equals("")){
                                        JOptionPane.showMessageDialog(null, "Introduceti numarul de telefon.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                Client client=Operatii.cautareClient(cof,telefon);
                                if(client!=null){
                                        com.setClient(client);
                                        com.setNrComanda(nrComanda);
                                        frame.dispose();
                                        AlegePrajitura a=new AlegePrajitura(com);
                                }
                                else {
                                        JOptionPane.showMessageDialog(null, "Clientul nu exista.",
                                                "Eroare", JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });
        }
}
