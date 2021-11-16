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
        ConfigData configData = new ConfigData(20,1,300);

        Generator generator = new Generator();
        ArrayList<Integer> lista = generator.generate(configData);
        for (int i : lista) {
            assertTrue(((i >= configData.getStart() && i <= configData.getEnd())));
        }
    }
}

