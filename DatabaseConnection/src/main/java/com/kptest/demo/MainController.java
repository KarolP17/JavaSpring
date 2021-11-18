package com.kptest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DataRepository dataRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam Integer range
            , @RequestParam Integer start, @RequestParam Integer end) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Data n = new Data();
        n.setRange(range);
        n.setStart(start);
        n.setEnd(end);
        dataRepository.save(n);
        return "Saved";
    }
    @PostMapping(path="/generate")
    public void generateNumbers () throws IOException {
        ConfigData configData = new ConfigData();
        Generator generator = new Generator();
        ArrayList<Integer> lista = generator.generate(dataRepository.findById(1).get());
        Writer writer = new Writer();
        File file =  new File("wynik.txt");
        writer.write(lista, file);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Data> getAllUsers() {
        // This returns a JSON or XML with the users
        return dataRepository.findAll();
    }
}