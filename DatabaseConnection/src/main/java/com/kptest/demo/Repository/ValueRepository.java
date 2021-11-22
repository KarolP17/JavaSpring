package com.kptest.demo.Repository;

import com.kptest.demo.Data;
import com.kptest.demo.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ValueRepository extends CrudRepository<Value, Integer> {
    Value findById(int id);
    List<Value> findAll();
    long count();
}
