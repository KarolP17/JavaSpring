package com.kptest.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kptest.demo.Data;

import java.util.List;



public interface DataRepository extends CrudRepository<Data, Integer> {
    Data findDataById(int id);
    List<Data> findAll();
}
