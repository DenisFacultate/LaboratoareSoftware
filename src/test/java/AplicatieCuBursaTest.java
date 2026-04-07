import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.StudentBursier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicatieCuBursaTest {
    @Test
    public void testSorteaza(){
        AplicatieCuBursa aplicatie=new AplicatieCuBursa();
        List<StudentBursier> listaNesortata=new ArrayList<>();

        StudentBursier s1=new StudentBursier(5,"Denis","Gabriel","TI 21/1",8.00,700);
        StudentBursier s2=new StudentBursier(2,"Gheorghe","Stelian","TI 22/1",8.90,780);
        StudentBursier s3=new StudentBursier(4,"Daniel","Moldovan","C 21/2",8.20,720);
        StudentBursier s4=new StudentBursier(1,"Andrei","Lucian","TI 22/2",9.50,850);
        StudentBursier s5=new StudentBursier(3,"Ianis","Feier","ISM 21/1",9.00,790);

        listaNesortata.add(s1);
        listaNesortata.add(s2);
        listaNesortata.add(s3);
        listaNesortata.add(s4);
        listaNesortata.add(s5);

        List<StudentBursier> listaSortata=aplicatie.sorteaza(listaNesortata);
        assertEquals(4, listaSortata.size(), "Lista sortată ar trebui să aibă 4 elemente");
        assertEquals(s4, listaSortata.get(0), "Primul student ar trebui să fie Andrei Lucian");
        assertEquals(s3, listaSortata.get(1), "Al doilea student ar trebui să fie Daniel Moldovan ");
        assertEquals(s2, listaSortata.get(2), "Al treilea student ar trebui să fie Denis Gabriel");
        assertEquals(s1, listaSortata.get(3), "Ultimul student ar trebui să fie Gheorghe Stelian");
        assertEquals(s1, listaSortata.get(4), "Ultimul student ar trebui să fie Ianis Feier");

        }
    }
