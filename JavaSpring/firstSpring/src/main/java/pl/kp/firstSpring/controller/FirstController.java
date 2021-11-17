package pl.kp.firstSpring.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kp.firstSpring.*;
import pl.kp.firstSpring.Writer;

import java.io.*;
import java.util.ArrayList;

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
    public void generateNumbers () throws IOException {
        ConfigUtil configUtil = new ConfigUtil();
        ClassPathResource classPathResource1 = new ClassPathResource("dane.txt");
        InputStream inputStream1 = classPathResource1.getInputStream();
        File file1 = File.createTempFile("dane", ".txt");
        FileUtils.copyInputStreamToFile(inputStream1, file1);
        ConfigData configData = configUtil.loadData(file1);
        Generator generator = new Generator();
        ArrayList<Integer> lista = generator.generate(configData);
        Writer writer = new Writer();
        File file =  new File("wynik.txt");
        writer.write(lista, file);
    }

    @GetMapping("/randomNumber")
    public int randomNumber() throws IOException {
        RandomNumber randomNumber = new RandomNumber();
        ClassPathResource classPathResource;
        classPathResource = new ClassPathResource("wynik.txt");
        InputStream inputStream = classPathResource.getInputStream();
        File file = File.createTempFile("wynik", ".txt");
        FileUtils.copyInputStreamToFile(inputStream, file);
        return randomNumber.random(file);
    }

    @GetMapping(
            value = "/cube",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        Display display = new Display();
        File file = File.createTempFile("cube", ".png");
        FileUtils.copyInputStreamToFile(display.displayRandom(), file);
        FileInputStream inputStream = new FileInputStream(file);
        return IOUtils.toByteArray(inputStream);
    }

}

