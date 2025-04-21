package uke13;

import java.util.*;

public class Oppgave1b {
    static final int SIZE = 10;
    @SuppressWarnings("unchecked")
	static List<String>[] table = new ArrayList[SIZE];
    static String[] bilnummer = {
        "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"
    };
    static Map<String, Integer> equalsCalls = new HashMap<>();

    public static void main(String[] args) {
        // Initialiser tabellplasser som tomme lister
        for (int i = 0; i < SIZE; i++) {
            table[i] = new ArrayList<>();
        }

        insertChained();

        System.out.println("Kjedet hashtabell:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

    // Hashfunksjon: siste siffer i bilnummeret
    static int hash(String bilnr) {
        char lastChar = bilnr.charAt(bilnr.length() - 1);
        return Character.getNumericValue(lastChar);
    }

    static void insertChained() {
        for (String plate : bilnummer) {
            int hash = hash(plate);
            table[hash].add(plate);

            // equals-kall ved søk (siden vi vet vi skal finne elementet til slutt)
            // vi teller antall elementer i lista før vi finner det
            equalsCalls.put(plate, table[hash].size());
        }
    }
}
