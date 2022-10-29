import cofetarie.Cofetarie;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AfisareMeniu {
        private JPanel panel;
        private JLabel titlu;
        private JList list1;
        public AfisareMeniu(Cofetarie cof){
                JFrame frame=new JFrame("Cofetarie");
                ImageIcon image= new ImageIcon("src/cake.png");
                frame.setIconImage(image.getImage());
                frame.setContentPane(panel);
                frame.getContentPane().setBackground(Color.pink);
                frame.setSize(500,500);

                String s = "Meniu  " + cof.getNume();
                titlu.setText(s);
                frame.setVisible(true);
                Vector prajituri =new Vector(cof.getMeniuCofetarie());
                list1.setListData(prajituri);
                list1.setBackground(Color.pink);
        }
}
