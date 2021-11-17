package pl.kp.firstSpring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigUtil {
    public ConfigData loadData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int range = scanner.nextInt();
        ConfigData configData = new ConfigData(range,start,end);
        return configData;
    }
}
