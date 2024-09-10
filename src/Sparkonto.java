class Sparkonto extends Konto {

    // Konstruktor
    public Sparkonto(String kontonummer) {
        super(kontonummer);
    }

    @Override
    public String toString() {
        return "Sparkonto{" +
                "Kontonummer='" + kontonummer + '\'' +
                ", Kontostand=" + kontostand +
                '}';
    }
}
