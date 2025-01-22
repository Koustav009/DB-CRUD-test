package com.koustav.dbcrudtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;

import com.koustav.dbcrudtest.service.ItemService;
import com.koustav.dbcrudtest.model.Item;

@RestController
@RequestMapping("/students")
public class ItemController {

    @Autowired // Injects the service
    private ItemService studentService;

    // Endpoint to create a new student
    @PostMapping("/add") // Handles HTTP POST requests
    public ResponseEntity<Item> createStudent(@RequestBody Item student) {
        System.out.println(student.getMarks());
        Item createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent); // Returns the created student as a response
    }

    // Endpoint to get a student by ID
    @GetMapping("/id/{id}") // Handles HTTP GET requests with a path variable
    public ResponseEntity<Item> getStudentById(@PathVariable Long id) {
        Optional<Item> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok) // Returns 200 OK with the student
                .orElse(ResponseEntity.notFound().build()); // Returns 404 if student not found
    }
    @GetMapping("/marks/{marks}")
    public ResponseEntity<Item> getStudentByMarks(@PathVariable Integer marks)
    {
        Optional<Item> student = studentService.getBymarks(marks);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getall()
    {
        List<Item> student = studentService.fetchall();

        return ResponseEntity.ok(student);
    }


}





//===================================================================
//public class ItemController {
//
//    @Autowired
//    private ItemService service;
//
//
//    public ItemController(ItemService service) {
//       this.service = service;
//    }
//
//
//    @PostMapping // Handles HTTP POST requests
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        Student createdStudent = studentService.createStudent(student);
//        return ResponseEntity.ok(createdStudent);

//    @GetMapping
//    public List<Item> getAllItems() {
//        return service.getAllItems();
//    }
//
//    @GetMapping("/{id}")
//    public Item getItem(@PathVariable Long id) {
//        return service.getItemById(id);
//    }
//
//    @PostMapping
//    public Item createItem(@RequestBody Item item) {
//        return service.createItem(item);
//    }
//
//    @PutMapping("/{id}")
//    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
//        return service.updateItem(id, item);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteItem(@PathVariable Long id) {
//        service.deleteItem(id);
//    }
//}

