package com.kptest.demo;

import com.kptest.demo.ConfigData;
import com.kptest.demo.Data;
import com.kptest.demo.Generator;
import com.kptest.demo.Repository.DataRepository;
import com.kptest.demo.Service.ConfigService;
import com.kptest.demo.Writer;
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

    @GetMapping(path="/add")
    public @ResponseBody String addNewData (@RequestParam Integer range
            , @RequestParam Integer start, @RequestParam Integer end) {


        Data n = new Data();
        n.setRange(range);
        n.setStart(start);
        n.setEnd(end);
        dataRepository.save(n);
        return "Saved";
    }
    @Autowired
    ConfigService configService;
    @GetMapping(path="/generate/{id}")
    public void generateNumbers (@PathVariable("id") int id) throws IOException {
        ConfigData configData = configService.getConfigFromDB(id);
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
