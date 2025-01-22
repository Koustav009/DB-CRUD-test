package com.koustav.dbcrudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.koustav.dbcrudtest.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository // Indicates this is a Spring-managed repository
public interface StudentRepository extends JpaRepository<Item, Long> {
    // JpaRepository provides CRUD methods out of the box

    // Custom JPQL query to retrieve all Item details specifically
    @Query(value = "SELECT * FROM Students10 WHERE marks = :marks",nativeQuery = true)
    Optional<Item> fetchBymarks(@Param("marks") Integer marks);

    @Query(value = "SELECT * FROM Students10",nativeQuery = true)
    List<Item> fetchall();
}