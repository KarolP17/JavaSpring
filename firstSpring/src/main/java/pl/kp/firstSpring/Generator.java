package pl.kp.firstSpring;

import java.sql.Time;
import java.util.*;

public class Generator {
    public ArrayList<Integer> generate(ConfigData configData){
        Random random = new Random();
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i = 0; i < configData.getRange(); i++){
            lista.add(random.nextInt((configData.getEnd() - configData.getStart()) + configData.getStart()));
        }
        return lista;
    }
    public long[] generate(int start, int end, double timeEnd){
        long time = System.currentTimeMillis();
        Random random = new Random();
        long[] tab = new long[(end - start) + 1];
        for (long n : tab) {
            n = 0;
        }

        while (System.currentTimeMillis() <= time + (timeEnd * 60000)) {
            int liczba = random.nextInt(end - start + 1) + start;
            System.out.println(liczba);
            tab[liczba - start] += 1;
        }
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Liczba: " + (i+start) + " Ilość wystąpień: " + tab[i]);
        }
        System.out.println("Generation completed");
        return tab;
    }


}
