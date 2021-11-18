package com.kptest.demo;

import org.springframework.data.repository.CrudRepository;

import com.kptest.demo.Data;

import java.util.List;



public interface DataRepository extends CrudRepository<Data, Integer> {
    Data findDataById(int id);
    List<Data> findAll();
}
