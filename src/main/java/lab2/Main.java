package lab2;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList();


        for (int i = 0; i <= 4; i++)
        {
            x.add(rand.nextInt(11));
        }

        System.out.println(x);

        for (int i = 0; i <= 6; i++)
        {
            y.add(rand.nextInt(11));
        }

        System.out.println(y);

        xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        zSet = new TreeSet<>(x);

        zSet.retainAll(y);

        System.out.println(zSet);

        xMinusY = new ArrayList<>(x);

        xMinusY.removeAll(y);

        System.out.println(xMinusY);

        xPlusYLimitedByP = new ArrayList<>(x);
        xPlusYLimitedByP.addAll(y);

        xPlusYLimitedByP.removeIf(valoare -> valoare > p);

        System.out.println(xPlusYLimitedByP);
    }

}
