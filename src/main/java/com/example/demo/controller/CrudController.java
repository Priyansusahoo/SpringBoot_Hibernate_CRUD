package com.example.demo.controller;

import com.example.demo.entity.EntityClass;
import com.example.demo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import java.util.List;

@RestController
@RequestMapping("/myapp")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EntityClass>> getAllEmployees(){
        return crudService.getAllemployee();
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Boolean> addEmployee(@RequestBody EntityClass entity){
        return crudService.addEmployee(entity);
    }

    @GetMapping("/getById")
    public ResponseEntity<EntityClass> getById(@RequestParam Long id){
        return crudService.getById(id);
    }

    @PutMapping("/deleteById")
    public ResponseEntity<Boolean> addEmployee(@RequestParam Long id){
        return crudService.deleteById(id);
    }

    @PutMapping("/updateEmailById")
    public ResponseEntity<Boolean> updateEmployee(@RequestParam Long id, @RequestParam String email){
        return crudService.updateEmailById(id, email);
    }
}
