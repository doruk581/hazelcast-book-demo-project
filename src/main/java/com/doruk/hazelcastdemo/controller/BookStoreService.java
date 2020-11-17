package com.doruk.hazelcastdemo.controller;

import com.doruk.hazelcastdemo.domain.Book;
import com.doruk.hazelcastdemo.interfaces.AddBookRequest;
import java.util.List;

public interface BookStoreService {

    void addBook(AddBookRequest addBookRequest);

    void deleteBook(Long id);

    Book getById(Long id);

    List<Book> getAll();
}
