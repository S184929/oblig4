package uke13;

import java.util.Arrays;

public class Oppgave1a {
    static String[] table = new String[10];
    static String[] bilnummer = {
        "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"
    };
    static int[] equalsCalls = new int[bilnummer.length];

    public static void main(String[] args) {
        Arrays.fill(table, null);
        insertWithLinearProbing();

        System.out.println("Hash-tabell:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

    // Hashfunksjon: siste siffer i bilnummeret
    static int hash(String bilnr) {
        char lastChar = bilnr.charAt(bilnr.length() - 1);
        return Character.getNumericValue(lastChar);
    }

    // Insert with linear probing
    static void insertWithLinearProbing() {
        for (int i = 0; i < bilnummer.length; i++) {
            String plate = bilnummer[i];
            int hash = hash(plate);
            int probes = 0;

            while (table[hash] != null) {
                probes++;
                hash = (hash + 1) % table.length;
            }
            table[hash] = plate;
            equalsCalls[i] = probes + 1; // +1 for første sammenligning
        }
    }
}
