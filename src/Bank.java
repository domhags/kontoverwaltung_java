import java.util.ArrayList;
import java.util.List;

class Bank {
    private final List<Konto> konten;

    // Konstruktor
    public Bank() {
        konten = new ArrayList<>();
    }

    // Methode zum Konto anlegen
    public void kontoAnlegen(Konto konto) {
        if (findeKonto(konto.getKontonummer()) != null) {
            throw new IllegalArgumentException("Ein Konto mit dieser Nummer existiert bereits.");
        }
        konten.add(konto);
        System.out.println("Konto erfolgreich angelegt.");
    }

    // Methode um ein Konto anhand der Kontonummer zu finden
    public Konto findeKonto(String kontonummer) {
        for (Konto konto : konten) {
            if (konto.getKontonummer().equals(kontonummer)) {
                return konto;
            }
        }
        return null;
    }

    // Ausgabe aller Konten
    public void alleKontenAnzeigen() {
        if (konten.isEmpty()) {
            System.out.println("Es sind keine Konten vorhanden.");
            return;
        }
        int index = 1;
        for (Konto konto : konten) {
            System.out.println(index + ". " + konto);
            index++;
        }
    }

    // Ein Konto anhand einer ID finden
    public Konto findeKontoById(int id) {
        if (id > 0 && id <= konten.size()) {
            return konten.get(id - 1); // ID um 1 reduziert, um auf Listenindex zuzugreifen
        }
        return null;
    }
}