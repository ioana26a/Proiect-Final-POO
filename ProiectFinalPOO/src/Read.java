import cofetarie.Client;
import cofetarie.Cofetarie;
import cofetarie.Comanda;
import cofetarie.Prajitura;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Read {
        public void citirePrajituri(Cofetarie cof){
                String nume;
                int pret;
                try {
                        Scanner input ;
                        File file = new File("src\\Prajituri.txt");
                        input = new Scanner(file);

                        while (input.hasNextLine()) {
                                nume=input.next();
                                pret=input.nextInt();
                                Prajitura p=new Prajitura();
                                p.adaugarePrajitura(nume,pret);
                                cof.addPrajitura(p);
                        }
                        input.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Eroare la citirea prajiturilor.",
                                "Eroare", JOptionPane.ERROR_MESSAGE);
                }
        }
        public void citireClienti(Cofetarie cof){
                String nume,adresa,telefon,nextLine;
                try {
                        Scanner input ;
                        File file = new File("src\\Clienti.txt");
                        input = new Scanner(file);

                        while (input.hasNextLine()) {
                                nextLine=input.nextLine();
                                String arr[]=nextLine.split(",");
                                nume=arr[0];
                                adresa=arr[1];
                                telefon=arr[2];
                                Client client=new Client(nume,adresa,telefon);
                                cof.addClient(client);
                        }
                        input.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Eroare la citirea clientilor.",
                                "Eroare", JOptionPane.ERROR_MESSAGE);
                }
        }
        public void scriereComanda(Comanda comanda){
                try {
                        FileWriter myWriter = new FileWriter("src\\Istoric_comenzi_cofetarie.txt");
                        myWriter.write(comanda.toString());
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Eroare la scrierea comenzii in fisier.",
                                "Eroare", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                }
        }

}