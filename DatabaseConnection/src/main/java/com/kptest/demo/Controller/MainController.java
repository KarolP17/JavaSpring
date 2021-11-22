package com.kptest.demo.Controller;

import com.kptest.demo.*;
import com.kptest.demo.Repository.ValueRepository;
import com.kptest.demo.Repository.DataRepository;
import com.kptest.demo.Service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kptest.demo.Value;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private ValueRepository valueRepository;


    @GetMapping(path = "/add")
    public String addNewData(@RequestParam Integer range
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

    @GetMapping(path = "/generate/{id}")
    public String generateNumbers(@PathVariable("id") Integer id) throws FileNotFoundException {
        ConfigData configData = configService.getConfigFromDB(id);
        ArrayList<Integer> lista = generator.generate(configData);
        File file = new File("wynik.txt");
        writer.write(lista, file);
        return "Generation completed";
    }

    @GetMapping(path = "/all")
    public List<Data> getAllUsers() {
        return dataRepository.findAll();
    }


    @GetMapping(path = "/count")
    public long countValues() {
        return valueRepository.count();
    }


    @GetMapping(path = "/randomNumberFromDB")
    public String random() {
        int id = generator.generate(valueRepository.count());
        Value value = valueRepository.findById(id);
        return value.getValue();
    }

    @GetMapping(path = "/allRandomNumbersFromDB")
    public ArrayList<String> allRandom() {
        ArrayList<String> lista = new ArrayList<>();
        boolean odp;
        long count = valueRepository.count();
        while (lista.size() < count) {
            odp = true;
            int id = generator.generate(valueRepository.count());
            Value value = valueRepository.findById(id);
                    if (lista.contains(value.getValue())) {
                        odp = false;
                    }
                if (odp) {
                    lista.add(value.getValue());
                }
        }
        return lista;
    }
    @GetMapping(path="/randomWithoutIDandSQL")
    public ArrayList<String> randomWithoutID(){
        List<Value> it;
        ArrayList<String> results = new ArrayList<>();
        it = valueRepository.findAll();
        while (results.size() < it.size()){
            boolean odp = true;
            int id = generator.generate(it.size()) - 1;
            if(results.contains(it.get(id).getValue())){
                odp = false;
            }
            if(odp == true)
            results.add(it.get(id).getValue());
        }
        return results;
    }
    @GetMapping(path="/randomWithSQL")
    public List<String> randomWithoutIDwithSQL(){
        List<String> results = valueRepository.randomFromDB();
        return results;
    }
}
