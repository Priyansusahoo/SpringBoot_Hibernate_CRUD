package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.EntityClass;
import com.example.demo.repo.CrudRepo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class CrudService implements CrudServiceInterf {
    @Autowired
    private CrudRepo entityClassRepository;

    public List<EntityClass> getAllEntities() {
        return entityClassRepository.findAll();
    }

    public Optional<EntityClass> getEntityById(Long id) {
        return entityClassRepository.findById(id);
    }

    public EntityClass saveEntity(EntityClass entity) {
        return entityClassRepository.save(entity);
    }

    @Override
    public ResponseEntity<List<EntityClass>> getAllemployee() {
        // Provide implementation for this method
        // For example, you can return all employees using the repository
        List<EntityClass> employeeDetailsList = entityClassRepository.findAll();
        return ResponseEntity.ok(employeeDetailsList);
    }

    @Override
    public ResponseEntity<Boolean> addEmployee(EntityClass entity) {
        EntityClass newEntity = new EntityClass();

        newEntity.setFirstName(entity.getFirstName());
        newEntity.setEmail(entity.getEmail());
        newEntity.setLastName(entity.getLastName());

        newEntity = entityClassRepository.save(newEntity);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @Override
    public ResponseEntity<EntityClass> getById(Long id) {

        Optional<EntityClass> entityObject = entityClassRepository.findById(id);

        if (entityObject.isPresent()) {
            return ResponseEntity.ok(entityObject.get());
        } else {
         return ResponseEntity.unprocessableEntity().body(new EntityClass());
        }

//        return entityObject.map(ResponseEntity :: ok).orElseGet(()-> ResponseEntity.unprocessableEntity().body(new EntityClass()));
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        Optional<EntityClass> entityObject = entityClassRepository.findById(id);

        if(entityObject.isPresent()){
            entityClassRepository.deleteById(id);
            return ResponseEntity.ok(Boolean.TRUE);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        }
    }

    @Override
    public ResponseEntity<Boolean> updateEmailById(Long id, String email) {
        Optional<EntityClass> entityObject = entityClassRepository.findById(id);
        try {
            if (entityObject.isPresent()) {
                int updateCount = entityClassRepository.updateEmailById(id, email);
                if (updateCount >= 1)
                    return ResponseEntity.ok().body(Boolean.TRUE);
                else
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Boolean.FALSE);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
            }
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Boolean.FALSE);
        }
    }


}