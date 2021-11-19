package com.kptest.demo.Service;


import com.kptest.demo.ConfigData;
import com.kptest.demo.Data;
import com.kptest.demo.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService{
    DataRepository dataRepository;
    public ConfigData getConfigFromDB(Integer id){
        Data data = dataRepository.findById(id).get();
        ConfigData configData = new ConfigData(data.getRange(), data.getStart(), data.getEnd());
        return configData;
    }
}
