package pl.kp.firstSpring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Display {
    public static InputStream displayRandom() throws IOException {
        ClassPathResource classPathResource;
        Random random = new Random();
        int number = (random.nextInt(5) + 1);
        switch(number){
            case 1:
                classPathResource = new ClassPathResource("cube1.png");
                break;
            case 2:
                classPathResource = new ClassPathResource("cube2.png");
                break;
            case 3:
                classPathResource = new ClassPathResource("cube3.png");
                break;
            case 4:
                classPathResource = new ClassPathResource("cube4.png");
                break;
            case 5:
                classPathResource = new ClassPathResource("cube5.png");
                break;
            case 6:
                classPathResource = new ClassPathResource("cube6.png");
                break;
            default:
                classPathResource = new ClassPathResource("cube2.png");
                break;
        }
        InputStream inputStream = classPathResource.getInputStream();
        return inputStream;
    }
}
