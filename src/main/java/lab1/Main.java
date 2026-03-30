package lab1;

public class Main {
    public static void main(String[] args) {

        String alfabet = "";

        for (char c = 'a'; c <= 'z'; c++) {
            alfabet += c;
        }

        System.out.println("Alfabet litere mici: " + alfabet.toLowerCase());
        System.out.println("Alfabet majuscule: " + alfabet.toUpperCase());


        String[] arrayVocale = new String[5];
        int indexArray = 0;
        String grupCurent = "";

        for (int i = 0; i < alfabet.length(); i++) {
            char litera = alfabet.charAt(i);

            if (litera == 'e' || litera == 'i' || litera == 'o' || litera == 'u') {

                arrayVocale[indexArray] = grupCurent;
                indexArray++;
                grupCurent = "";
            }

            grupCurent += litera;
        }

        arrayVocale[indexArray] = grupCurent;

        for (int i = 0; i < arrayVocale.length; i++) {
            System.out.println("array[" + i + "] = \"" + arrayVocale[i] + "\"");
        }
    }
}
