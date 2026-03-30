package lab3;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
try {
    File fisier = new File("in.txt");
    Scanner scanner = new Scanner(fisier);

    String textComplet = " ";

    while (scanner.hasNextLine()) {
        String text = scanner.nextLine();

        text = text.replace(".", ".\n");

        textComplet = textComplet + text + "\n";
    }

    scanner.close();

    FileWriter fisierIesire = new FileWriter("out.txt");
    fisierIesire.write(textComplet);
    fisierIesire.close();

    System.out.println("Textul a fost salvat in fisierul out.txt");
}
catch (Exception e) {
    System.out.println("Nu am gasit fisierul.");
}

    }
}
