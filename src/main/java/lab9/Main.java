package lab9;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        List<Integer> numere = new Random().ints(10, 5, 26)
                .boxed()
                .toList();
        System.out.println("Lista generata: " + numere);

        int suma = numere.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma: " + suma);

        int maxim = numere.stream()
                .max(Integer::compareTo)
                .orElse(-1);

        int minim = numere.stream()
                .min(Integer::compareTo)
                .orElse(-1);
        System.out.println("Minim " + minim + " Maxim" + maxim);

        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .toList();
        System.out.println("Numere filtrate: " + filtrate);

        List<Double> numereDouble = numere.stream()
                .map(Integer::doubleValue)
                .toList();
        System.out.println("Numere double: " + numereDouble);

        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("Contine lista valoarea 12? " + (contine12 ? "Da" : "Nu"));

        String text="Acesta este un program scris in java pentru expresii lambda";List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista inițială: " + cuvinte);
        System.out.println("--------------------------------------------------");

        List<String> cuvinteFiltrate = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .toList();

        System.out.println("Numărul de cuvinte cu >= 5 caractere este: " + cuvinteFiltrate.size());
        System.out.println("Lista filtrată: " + cuvinteFiltrate);

        List<String> cuvinteOrdonate = cuvinteFiltrate.stream()
                .sorted()
                .toList();

        System.out.println("Lista nouă ordonată alfabetic: " + cuvinteOrdonate);

        String cuvantCuP = cuvinte.stream()
                .filter(cuvant -> cuvant.toLowerCase().startsWith("p"))
                .findFirst()
                .orElse("Nu a fost găsit niciun cuvânt");

        System.out.println("Un element care începe cu litera 'p': " + cuvantCuP);
        }
    }

