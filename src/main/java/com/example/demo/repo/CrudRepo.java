package com.example.demo.repo;

import com.example.demo.entity.EntityClass;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

public interface CrudRepo extends JpaRepository<EntityClass, Long> {
    Optional<EntityClass> findById(Long id);
    @Modifying
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("update EntityClass SET email = :email WHERE id= :id")
    int updateEmailById(@Param("id") Long id, @Param("email") String email);
}