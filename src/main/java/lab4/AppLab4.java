package lab4;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;
import  java.util.WeakHashMap;

public class AppLab4 {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");
        for(Map.Entry<String,Integer> entry : varste.entrySet()){
            System.out.println("nume "+entry.getKey()+" "+entry.getValue()+" ani");
        }
        HashMap<String,Tanar> tineri=new HashMap<>();
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String nume = entry.getKey();
            Integer varsta = entry.getValue();
            String adresa = adrese.getOrDefault(nume, "Necunoscuta");
            tineri.put(nume, new Tanar(nume, varsta, adresa));
        }
        System.out.println("Continut instanta tineri ");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println("Cheie (Prenume): " + entry.getKey() + " -> Valoare: " + entry.getValue());
        }
    }
}

