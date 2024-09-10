import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menü ---");
            System.out.println("1. Girokonto anlegen");
            System.out.println("2. Sparkonto anlegen");
            System.out.println("3. Geld einzahlen");
            System.out.println("4. Geld abheben");
            System.out.println("5. Alle Konten anzeigen");
            System.out.println("6. Beenden");

            int auswahl = getAuswahl();
            switch (auswahl) {
                case 1:
                    girokontoAnlegen();
                case 2:
                    sparkontoAnlegen();
                case 3:
                    geldEinzahlen();
                case 4:
                    geldAbheben();
                case 5:
                    bank.alleKontenAnzeigen();
                case 6:
                    running = false;
                    System.out.println("Programm beendet.");
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private static int getAuswahl() {
        System.out.print("Bitte wählen Sie eine Option: ");
        try {
            int auswahl = scanner.nextInt();
            if (auswahl < 1 || auswahl > 6) {
                throw new IllegalArgumentException("Die Auswahl muss zwischen 1 und 6 liegen.");
            }
            return auswahl;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Eingabe löschen
            System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
            return -1;
        }
    }

    private static void girokontoAnlegen() {
        System.out.print("Kontonummer: ");
        String kontonummer = scanner.next();
        System.out.print("Dispo-Limit: ");
        double dispoLimit = scanner.nextDouble();

        try {
            bank.kontoAnlegen(new Girokonto(kontonummer, dispoLimit));
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    private static void sparkontoAnlegen() {
        System.out.print("Kontonummer: ");
        String kontonummer = scanner.next();
        try {
            bank.kontoAnlegen(new Sparkonto(kontonummer));
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    private static void geldEinzahlen() {
        bank.alleKontenAnzeigen();
        System.out.print("Bitte wählen Sie die ID des Kontos: ");
        int id = scanner.nextInt();
        Konto konto = bank.findeKontoById(id);

        if (konto == null) {
            System.out.println("Konto nicht gefunden.");
            return;
        }

        System.out.print("Betrag einzahlen: ");
        try {
            double betrag = scanner.nextDouble();
            konto.einzahlen(betrag);
            System.out.println("Einzahlung erfolgreich.");
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie einen gültigen Betrag ein.");
            scanner.next(); // Eingabe löschen
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void geldAbheben() {
        bank.alleKontenAnzeigen();
        System.out.print("Bitte wählen Sie die ID des Kontos: ");
        int id = scanner.nextInt();
        Konto konto = bank.findeKontoById(id);

        if (konto == null) {
            System.out.println("Konto nicht gefunden.");
            return;
        }

        System.out.print("Betrag abheben: ");
        try {
            double betrag = scanner.nextDouble();
            konto.abheben(betrag);
            System.out.println("Abhebung erfolgreich.");
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie einen gültigen Betrag ein.");
            scanner.next(); // Eingabe löschen
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}