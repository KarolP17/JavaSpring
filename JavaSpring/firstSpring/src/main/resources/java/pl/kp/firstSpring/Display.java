package pl.kp.firstSpring;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Display {
    public static File displayRandom() throws FileNotFoundException {
        File file;
        Random random = new Random();
        int number = (random.nextInt(5) + 1);
        switch(number){
            case 1:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube1.png");
                break;
            case 2:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube2.png");
                break;
            case 3:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube3.png");
                break;
            case 4:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube4.png");
                break;
            case 5:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube5.png");
                break;
            case 6:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube6.png");
                break;
            default:
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "cube2.png");
                break;
        }
        return file;
    }
}
