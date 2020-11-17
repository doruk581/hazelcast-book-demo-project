package com.doruk.hazelcastdemo;

import com.doruk.hazelcastdemo.controller.BookStoreService;
import com.doruk.hazelcastdemo.domain.Book;
import com.doruk.hazelcastdemo.domain.DefaultBookStoreService;
import com.doruk.hazelcastdemo.infrastructure.BookStoreRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Configuration
public class HazelcastDemoApplication {

    @Autowired
    private BookStoreRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HazelcastDemoApplication.class, args);
    }

    @Bean
    BookStoreService bookStoreService(BookStoreRepository repository){
        return new DefaultBookStoreService(repository);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void generateDefaultData() {
        Long count = repository.count();

        if (count == 0L) {
            List<Book> bookList = new ArrayList<>();

            for (int i = 0; i < 5000 ; i++){
                Book book = new Book();
                book.setAuthor("Author" + i);
                book.setCategory("Category" + i);
                book.setIsbnCode("ISBN"+ i);
                book.setPublisher("PUBLISHER"+i);
                book.setYear(2020);
                book.setVersion(1);
                book.setName("NAME"+i);

                bookList.add(book);
            }

            repository.saveAll(bookList);
        }

    }
}
