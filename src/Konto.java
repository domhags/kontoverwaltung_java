abstract class Konto {
    protected String kontonummer;
    protected double kontostand;

    // Konstruktor
    public Konto(String kontonummer) {
        this.kontonummer = kontonummer;
        this.kontostand = 0;
    }

    // Getter für Kontonummer
    public String getKontonummer() {
        return kontonummer;
    }

    // Getter für Kontostand
    public double getKontostand() {
        return kontostand;
    }

    // Methode für Geld einzahlen
    public void einzahlen(double betrag) {
        if (betrag <= 0) {
            throw new IllegalArgumentException("Einzahlungsbetrag muss positiv sein.");
        }
        kontostand += betrag;
    }

    // Methode für Geld abheben
    public  void abheben(double betrag) {
        if (betrag <= 0) {
            throw new IllegalArgumentException("Abhebebetrag muss positiv sein.");
        }
        if (betrag > kontostand) {
            throw new IllegalArgumentException("Nicht genügend Guthaben vorhanden.");
        }
        kontostand -= betrag;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "Kontonummer='" + getKontonummer() + '\'' +
                ", Kontostand=" + getKontostand() +
                '}';
    }
}