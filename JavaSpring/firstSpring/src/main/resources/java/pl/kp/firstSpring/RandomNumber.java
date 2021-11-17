package pl.kp.firstSpring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public Integer random(File file) throws FileNotFoundException {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()){
            lista.add(scanner.nextInt());
        }
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
}
