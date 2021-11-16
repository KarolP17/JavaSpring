package pl.kp.firstSpring;

import java.util.Random;

public class Display {
    public static String displayRandom(){
        String file;
        Random random = new Random();
        int number = (random.nextInt(5) + 1);
        switch(number){
            case 1:
                file = "src/main/resources/cube1.png";
                break;
            case 2:
                file = "src/main/resources/cube2.png";
                break;
            case 3:
                file = "src/main/resources/cube3.png";
                break;
            case 4:
                file = "src/main/resources/cube4.png";
                break;
            case 5:
                file = "src/main/resources/cube5.png";
                break;
            case 6:
                file = "src/main/resources/cube6.png";
                break;
            default:
                file = "src/main/resources/cube2.png";
                break;
        }
        return file;
    }
}
