package com.doruk.hazelcastdemo.domain;

import com.doruk.hazelcastdemo.controller.BookStoreService;
import com.doruk.hazelcastdemo.infrastructure.BookStoreRepository;
import com.doruk.hazelcastdemo.interfaces.AddBookRequest;
import java.util.List;


public class DefaultBookStoreService implements BookStoreService {

    private final BookStoreRepository repository;

    public DefaultBookStoreService(BookStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addBook(AddBookRequest addBookRequest) {
        final Book book = Book.builder()
            .author(addBookRequest.getAuthor())
            .category(addBookRequest.getCategory())
            .isbnCode(addBookRequest.getIsbnCode())
            .name(addBookRequest.getName())
            .publisher(addBookRequest.getPublisher())
            .version(addBookRequest.getVersion())
            .year(addBookRequest.getYear())
            .build();

        repository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Book getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
}
