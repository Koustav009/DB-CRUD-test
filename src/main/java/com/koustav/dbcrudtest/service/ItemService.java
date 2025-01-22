package com.koustav.dbcrudtest.service;

import com.koustav.dbcrudtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import java.util.List;
import java.util.List;
import java.util.Optional;


import com.koustav.dbcrudtest.model.Item;

@Service // Marks this as a Spring-managed service
public class ItemService {

    @Autowired // Injects the repository
    private StudentRepository studentRepository;

    // Create a new student
    public Item createStudent(Item student) {
        return studentRepository.save(student);
    }

    // Get a student by ID
    public Optional<Item> getStudentById(Long id) {

        return studentRepository.findById(id);
    }

    public Optional<Item> getBymarks(Integer marks)
    {
        return studentRepository.fetchBymarks(marks);
    }

    public List<Item> fetchall()
    {
        return studentRepository.fetchall();
    }
}
