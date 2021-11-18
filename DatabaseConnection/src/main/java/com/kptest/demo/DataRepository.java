package com.kptest.demo;

import org.springframework.data.repository.CrudRepository;

import com.kptest.demo.Data;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DataRepository extends CrudRepository<Data, Integer> {
    Data findDataById(int id);
    List<Data> findAll();
}
