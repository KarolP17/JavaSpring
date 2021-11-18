package com.kptest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private DataRepository dataRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam Integer range
            , @RequestParam Integer start, @RequestParam Integer end) {


        Data n = new Data();
        n.setRange(range);
        n.setStart(start);
        n.setEnd(end);
        dataRepository.save(n);
        return "Saved";
    }
    @PostMapping(path="/generate")
    public void generateNumbers () throws IOException {
        ConfigData configData = new ConfigData(1,2,6);
        Generator generator = new Generator();
        ArrayList<Integer> lista = generator.generate(configData);
        Writer writer = new Writer();
        File file =  new File("wynik.txt");
        writer.write(lista, file);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Data> getAllUsers() {
        return dataRepository.findAll();
    }
}
