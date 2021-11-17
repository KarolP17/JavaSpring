package pl.kp.firstSpring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    public File write(ArrayList<Integer> lista, File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (int n : lista) {
            printWriter.println(n);
        }
        printWriter.close();
        return file;
    }
}
