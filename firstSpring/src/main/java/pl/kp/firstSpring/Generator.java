package pl.kp.firstSpring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.kp.firstSpring.controller.FirstController;

import java.sql.Time;
import java.util.*;

public class Generator {
    private static final Logger logger = LogManager.getLogger(Generator.class);
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
            logger.info(liczba);
            tab[liczba - start] += 1;
        }
        for (int i = 0; i < tab.length; i++) {
            logger.info("Liczba: " + (i+start) + " Ilość wystąpień: " + tab[i]);
        }
        logger.info("Generation completed");
        return tab;
    }


}

