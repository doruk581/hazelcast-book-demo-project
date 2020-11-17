package com.doruk.hazelcastdemo.controller;

import com.doruk.hazelcastdemo.interfaces.AddBookRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BookStoreController {

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @PostMapping(value = "/v1/bookstore")
    public ResponseEntity<Object> addBook(@RequestBody AddBookRequest addBookRequest){
        bookStoreService.addBook(addBookRequest);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/v1/bookstore/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookStoreService.getById(id));
    }

    @GetMapping(value = "/v1/bookstore")
    public ResponseEntity<Object> getAllBooks(){
        return ResponseEntity.ok(bookStoreService.getAll());
    }

    @DeleteMapping(value = "/v1/bookstore/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        bookStoreService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
