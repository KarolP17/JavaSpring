package pl.kp.firstSpring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    private static final Logger logger = LogManager.getLogger(Generator.class);
    public File write(ArrayList<Integer> lista, File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (int n : lista) {
            printWriter.println(n);
            logger.info(n);
        }
        printWriter.close();
        return file;
    }
}
