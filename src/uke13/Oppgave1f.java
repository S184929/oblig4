package uke13;

import java.util.Arrays;

public class Oppgave1f {
    static String[] table = new String[20];  // Ny tabell, dobbelt så stor
    static String[] bilnummer = {
        "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"
    };

    public static void main(String[] args) {
        Arrays.fill(table, null);  // Fyll tabellen med null-verdier
        insertWithLinearProbing();  // Sett inn elementene

        // Skriv ut tabellen
        System.out.println("Ny hash-tabell (dobbelt så stor):");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

    // Ny hashfunksjon: de to siste sifrene i bilnummeret
    static int hash(String bilnr) {
        // Hent de to siste sifrene fra bilnummeret
        String lastTwoDigits = bilnr.substring(bilnr.length() - 2);
        int lastDigits = Integer.parseInt(lastTwoDigits);
        return lastDigits % table.length;  // Modulo tabellens størrelse (20)
    }

    // Sett inn elementene med lineær probing
    static void insertWithLinearProbing() {
        for (String plate : bilnummer) {
            int hash = hash(plate);
            int probes = 0;

            // Lineær probing for å finne ledig plass
            while (table[hash] != null) {
                probes++;
                hash = (hash + 1) % table.length;  // Steglengde 1
            }
            table[hash] = plate;  // Sett inn bilnummeret
        }
    }
}
