package cofetarie;

public class Client {
        private String nume;
        private String adresa;
        private String nrTelefon;
        public Client(String nume,String adresa,String nrTelefon){
                this.nume=nume;
                this.adresa=adresa;
                this.nrTelefon=nrTelefon;
        }
        public String getNume(){
                return nume;
        }
        public String getNrTelefon() {
                return nrTelefon;
        }
        public void setNume(){
                this.nume=nume;
        }

        public void setAdresa(String adresa) {
                this.adresa = adresa;
        }

        public void setNrTelefon(String nrTelefon) {
                this.nrTelefon = nrTelefon;
        }

        @Override
        public String toString() {
                return nume + "," + adresa + "," + nrTelefon;
        }
}
