package pl.kp.firstSpring;

import java.util.Random;

public class Display {
    public static String displayRandom(){
        String file;
        Random random = new Random();
        int number = (random.nextInt(5) + 1);
        switch(number){
            case 1:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube1.png";
                break;
            case 2:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube2.png";
                break;
            case 3:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube3.png";
                break;
            case 4:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube4.png";
                break;
            case 5:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube5.png";
                break;
            case 6:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube6.png";
                break;
            default:
                file = "P:\\Szkola\\java\\firstSpring\\src\\main\\cube3.png";
                break;
        }
        return file;
    }
}
