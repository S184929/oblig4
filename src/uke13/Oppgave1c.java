package uke13;

import java.util.Map;

public class Oppgave1c {
    public static void main(String[] args) {
        // Initierer tidligere oppgaver for å fylle inn equalsCalls
        Oppgave1a.main(null);
        Oppgave1b.main(null);

        // Hent equalsCalls for begge oppgavene
        int[] linear = Oppgave1a.equalsCalls;
        Map<String, Integer> chainedMap = Oppgave1b.equalsCalls;
        
        // Konverter Map til array for enkel bearbeiding
        int[] chained = chainedMap.values().stream().mapToInt(Integer::intValue).toArray();

        // Beregn gjennomsnittlig equals-kall for begge metodene for elementer som finnes i tabellen
        System.out.printf("Gj.snitt equals-kall (linear probing) for funnede elementer: %.2f\n", average(linear));
        System.out.printf("Gj.snitt equals-kall (kjedet liste) for funnede elementer: %.2f\n", average(chained));

        // Beregn gjennomsnittlig equals-kall for elementer som ikke finnes i tabellen
        System.out.printf("Gj.snitt equals-kall (linear probing) for ikke-funnede elementer: %.2f\n", averageNotFound(linear));
        System.out.printf("Gj.snitt equals-kall (kjedet liste) for ikke-funnede elementer: %.2f\n", averageNotFound(chained));
    }

    // Beregn gjennomsnittet av en int-array
    static double average(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return (double) sum / arr.length;
    }

    // Beregn gjennomsnitt for elementer som ikke finnes
    static double averageNotFound(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // For open adressering kan vi anta at vi søker hele tabellen
            // Hvis det ikke finnes i tabellen, vil vi gjøre (table.length) probes i verste fall
            sum += arr[i] + 1; // +1 for første sammenligning og deretter resten
        }
        return (double) sum / arr.length;
    }

    // Beregn gjennomsnitt for ikke-funnede elementer i kjedelister
    static double averageNotFound(Map<String, Integer> map) {
        int sum = 0;
        for (Integer count : map.values()) {
            // I kjedelister må vi sjekke alle elementene i listen før vi kan konkludere at elementet ikke finnes
            sum += count;
        }
        return (double) sum / map.size();
    }
}
