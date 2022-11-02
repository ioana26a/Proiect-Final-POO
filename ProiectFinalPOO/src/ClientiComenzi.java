import cofetarie.Client;
import cofetarie.Cofetarie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientiComenzi {
        private JPanel panel;
        private JButton adaugareComandaButton;
        private JButton actualizareComandaButton;
        private JButton adaugareClientButton;
        private JButton initializareClientiButton;
        private JButton actualizareClientButton;
        private JTextField numarComanda;
        private JTextField nume;
        private JButton inapoi;
        private JLabel titlu;
        private JLabel mesaj;
        private Cofetarie cof=Cofetarie.getInstance();
        public ClientiComenzi(){
                JFrame frame=new JFrame("Cofetarie");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                titlu.setText("Cofetaria "+ cof.getNume());
                adaugareComandaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                AdaugareComanda a=new AdaugareComanda();
                        }
                });
                actualizareComandaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                });
                adaugareClientButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                AdaugareClient a=new AdaugareClient();
                        }
                });
                actualizareClientButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                });
                initializareClientiButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Read r=new Read();
                                r.citireClienti(cof);
                                for (Client c:cof.getListaClienti()) {
                                        System.out.println(c);
                                }
                                initializareClientiButton.setEnabled(false);
                        }
                });
                inapoi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                Optiune op=new Optiune();
                        }
                });
        }
}
