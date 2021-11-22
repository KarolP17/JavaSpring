package com.kptest.demo.Service;


import com.kptest.demo.ConfigData;
import com.kptest.demo.Data;
import com.kptest.demo.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class ConfigService{
    @Autowired
    DataRepository dataRepository;
    public ConfigData getConfigFromDB(Integer id){
        Data data = dataRepository.findById(id).get();
        ConfigData configData = new ConfigData(data.getRange(), data.getStart(), data.getEnd());
        return configData;
    }
}
