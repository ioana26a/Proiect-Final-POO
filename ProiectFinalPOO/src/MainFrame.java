import cofetarie.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
        public Cofetarie cof;
        private JPanel panel;
        private JTextField Camp1;
        private JTextField Camp2;
        private JTextField Camp3;
        private JButton btn;
        private static JFrame frame;

        public String nume;
        public int oraDes,oraInc;
        public MainFrame() {
                frame=new JFrame("Cofetarie");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);
                frame.setVisible(true);
                btn.addActionListener(
                        new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        cof = new Cofetarie();
                                        nume = Camp1.getText();
                                        try {
                                                oraDes = Integer.parseInt(Camp2.getText());
                                                oraInc = Integer.parseInt(Camp3.getText());
                                        } catch (NumberFormatException ex) {
                                                JOptionPane.showMessageDialog(null, "Ora este introdusa gresit.Va rugam incercati din nou.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                        }
                                        if(oraDes < 6 || oraDes > oraInc || oraInc > 22){
                                                JOptionPane.showMessageDialog(null, "Program incorect.Programul trebuie sa fie definita in intervalul 6:00-22:00.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                        }else if (nume.length() > 10) {
                                                JOptionPane.showMessageDialog(null, "Numele este prea lung.Va rugam incercati din nou.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else if (nume.equals(""))
                                                JOptionPane.showMessageDialog(null, "Nu ati introdus numele.",
                                                        "Eroare", JOptionPane.ERROR_MESSAGE);
                                        else {
                                                cof.setNume(nume);
                                                cof.setOraDeschidere(oraDes);
                                                cof.setOraInchidere(oraInc);
                                                MainFrame.frame.dispose();
                                                NewFrame n = new NewFrame(cof);
                                        }
                                }
                        }
                );
        }
}