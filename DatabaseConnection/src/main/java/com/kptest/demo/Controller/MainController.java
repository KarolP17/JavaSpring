package com.kptest.demo.Controller;

import com.kptest.demo.Generator;
import com.kptest.demo.Writer;
import com.kptest.demo.ConfigData;
import com.kptest.demo.Data;
import com.kptest.demo.Repository.DataRepository;
import com.kptest.demo.Service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private DataRepository dataRepository;


    @GetMapping(path="/add")
    public String addNewData (@RequestParam Integer range
            , @RequestParam Integer start, @RequestParam Integer end) {


        Data n = new Data();
        n.setRange(range);
        n.setStart(start);
        n.setEnd(end);
        dataRepository.save(n);
        return "Saved";
    }
    @Autowired
    private Generator generator;
    @Autowired
    private Writer writer;
    @Autowired
    ConfigService configService;
    @GetMapping(path="/generate/{id}")
    public  String generateNumbers (@PathVariable("id") Integer id) throws FileNotFoundException {
        ConfigData configData = configService.getConfigFromDB(id);
        ArrayList<Integer> lista = generator.generate(configData);
        File file =  new File("wynik.txt");
        writer.write(lista, file);
        return "Generation completed";
    }

    @GetMapping(path="/all")
    public Iterable<Data> getAllUsers() {
        return dataRepository.findAll();
    }
}
