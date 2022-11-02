import cofetarie.Cofetarie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Optiune {
        private JLabel optiune;
        private JPanel panel;
        private JButton clientiComenziButton;
        private JButton prajituriButton;
        private JLabel titlu;
        private Cofetarie cof = Cofetarie.getInstance();
        private JFrame frame;

        public Optiune() {
                frame = new JFrame("Cofetarie");
                ImageIcon image = new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(250, 250);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                optiune.setText("Va rugam alegeti o optiune...");
                prajituriButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                NewFrame n = new NewFrame(cof);
                        }
                });
                clientiComenziButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                ClientiComenzi c = new ClientiComenzi();
                        }
                });
        }
}
