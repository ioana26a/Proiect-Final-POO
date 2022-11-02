package cofetarie;
public class Prajitura implements IPrajitura{
        private String nume;
        private int pret;
        private static int nrPrajituri;
        public Prajitura(){
                super();
                nrPrajituri++;
        }
        public Prajitura(String nume,int pret){
                this.nume=nume;
                this.pret=pret;
                nrPrajituri++;
        }
        public String getNume() {
                return nume;
        }

        public void setPret(int pret) {
                this.pret = pret;
        }

        public void setNume(String nume) {
                this.nume=nume;
        }
        public String toString(){
                return nume + " " + pret + " lei.\n";
        }
        @Override
        public void adaugarePrajitura(String nume, int pret) {
                this.setNume(nume);
                this.setPret(pret);
        }
        public static int getNrPrajituri() {
                return nrPrajituri;
        }

        public int getPret() {
                return pret;
        }
}
