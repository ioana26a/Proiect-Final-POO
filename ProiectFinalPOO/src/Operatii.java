import cofetarie.Client;
import cofetarie.Cofetarie;
import cofetarie.Prajitura;

import javax.swing.*;

public class Operatii {
        public static boolean verifica(Cofetarie cof ,String nume){
                for(Prajitura p: cof.getMeniuCofetarie()){
                        if(p.getNume().equals(nume)){
                                return true;
                        }
                }
                return false;
        }
        public static Prajitura verificaPrajitura(Cofetarie cof ,String nume){
                for(Prajitura p: cof.getMeniuCofetarie()){
                        if(p.getNume().equals(nume)){
                                return p;
                        }
                }
                return null;
        }
        public static void add(Cofetarie cof ,JTextField t1,JTextField t2,String nume,int pret){
                Prajitura p = new Prajitura();
                p.adaugarePrajitura(nume, pret);
                cof.getMeniuCofetarie().add(p);
                t1.setText("");
                t2.setText("");
        }
        public static void addClient(Cofetarie cof ,JTextField t1,JTextField t2,JTextField t3){
                String nume=t1.getText();
                String adresa=t2.getText();
                String telefon=t3.getText();
                Client c = new Client(nume,adresa,telefon);
                cof.getListaClienti().add(c);
                t1.setText("");
                t2.setText("");
        }
        public static Client cautareClient(Cofetarie cof,String nrTelefon){
                for(Client c: cof.getListaClienti()){
                        if(c.getNrTelefon().equals(nrTelefon)){
                                return c;
                        }
                }
                return null;
        }
}
