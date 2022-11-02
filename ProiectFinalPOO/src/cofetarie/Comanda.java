package cofetarie;
import java.util.ArrayList;

public class Comanda extends ComandaAbstract{
        private int nrComanda;
        private Client client;
        private int sumaTotala;
        ArrayList<Prajitura> prajituriComanda=new ArrayList<Prajitura>();
        public Comanda(){
        }
        public int suma() {
                for (int i = 0; i < prajituriComanda.size(); i++) {
                        sumaTotala += prajituriComanda.get(i).getPret();
                }
                return sumaTotala;
        }

        public void setClient(Client client) {
                this.client = client;
        }

        public void adaugarePrajitura(Prajitura p) {
                prajituriComanda.add(p);
        }

        public void setNrComanda(int nrComanda) {
                this.nrComanda = nrComanda;
        }

        @Override
        public String toString() {
                return "Comanda cu numarul "+nrComanda+" in total de "+sumaTotala + " lei este a clientului " + client.toString();
        }
}