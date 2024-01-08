package com.example.demo.service;
import com.example.demo.entity.EntityClass;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudServiceInterf {
    ResponseEntity<List<EntityClass>> getAllemployee();
    ResponseEntity<Boolean> addEmployee(EntityClass entity);

    ResponseEntity<EntityClass> getById(Long id);

    ResponseEntity<Boolean> deleteById(Long id);

    ResponseEntity<Boolean> updateEmailById(Long id, String email);
}
