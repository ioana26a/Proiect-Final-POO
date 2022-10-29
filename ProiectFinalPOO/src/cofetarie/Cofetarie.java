package cofetarie;
import java.util.ArrayList;

public class Cofetarie {
        private String nume;
        private int oraInchidere;
        private int oraDeschidere;
        private final String locatie="Targu Mures";
        ArrayList<Prajitura> meniuCofetarie = new ArrayList<>();
        public void setNume(String nume) {
                this.nume = nume;
        }

        public String getLocatie() {
                return locatie;
        }

        public void setOraInchidere(int oraInchidere) {
                this.oraInchidere = oraInchidere;
        }

        public void setOraDeschidere(int oraDeschidere) {
                this.oraDeschidere = oraDeschidere;
        }

        public ArrayList<Prajitura> getMeniuCofetarie() {
                return meniuCofetarie;
        }

        @Override
        public String toString() {
                return "Cofetaria " + nume + " este deschisa in intervalul orar " + oraDeschidere + ":00-" + oraInchidere + ":00.";
        }

        public String getNume() {
                return nume;
        }
}
