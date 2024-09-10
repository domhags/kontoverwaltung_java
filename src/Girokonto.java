class Girokonto extends Konto {
    private final double dispoLimit;

    // Konstruktor
    public Girokonto(String kontonummer, double dispoLimit) {
        super(kontonummer);
        this.dispoLimit = dispoLimit;
    }

    //Überschreiben der Methode abheben
    @Override
    public void abheben(double betrag) {
        if (betrag <= 0) {
            throw new IllegalArgumentException("Abhebebetrag muss positiv sein.");
        }
        if (betrag > (kontostand + dispoLimit)) {
            throw new IllegalArgumentException("Nicht genügend Guthaben oder Dispo vorhanden.");
        }
        kontostand -= betrag;
    }

    @Override
    public String toString() {
        return "Girokonto{" +
                "Kontonummer='" + getKontonummer() + '\'' +
                ", Kontostand=" + getKontostand() +
                ", Dispo-Limit=" + dispoLimit +
                '}';
    }
}