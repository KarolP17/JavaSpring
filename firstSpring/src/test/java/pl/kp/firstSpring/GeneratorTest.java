package pl.kp.firstSpring;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void NumberIsInRange() throws FileNotFoundException{
        ConfigUtil configUtil = new ConfigUtil();
        ConfigData configData = configUtil.loadData(new File("P:/Szkola/java/firstSpring/src/main/dane.txt"));

        Generator generator = new Generator();
        assertNotNull(generator);
        ArrayList<Integer> lista = generator.generate(configData);
        for (int i : lista) {
            assertTrue(((i >= configData.getStart() && i <= configData.getEnd())));
        }
    }
}

