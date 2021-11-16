package pl.kp.firstSpring.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kp.firstSpring.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/generateTime")
    public long[] generateNumbersTime () throws FileNotFoundException {
        Generator generator = new Generator();
        return generator.generate(1,6,0.1);

    }
    @GetMapping("/generate")
    public void generateNumbers () throws FileNotFoundException {
        ConfigUtil configUtil = new ConfigUtil();
        ConfigData configData = configUtil.loadData(new File("P:/Szkola/java/firstSpring/src/main/dane.txt"));
        Generator generator = new Generator();
        ArrayList<Integer> lista = generator.generate(configData);
        Writer writer = new Writer();
        writer.write(lista, new File("P:\\Szkola\\java\\firstSpring\\src\\main\\wynik.txt"));
    }

    @GetMapping("/randomNumber")
    public int randomNumber() throws FileNotFoundException {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.random(new File("P:\\Szkola\\java\\firstSpring\\src\\main\\wynik.txt"));
    }

    @GetMapping(
            value = "/cube",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        Display display = new Display();
        FileInputStream inputStream = new FileInputStream(new File(display.displayRandom()));
        return IOUtils.toByteArray(inputStream);
    }

}

