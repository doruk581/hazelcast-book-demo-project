package com.doruk.hazelcastdemo.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookRequest {

    private String name;
    private String author;
    private Integer year;
    private String isbnCode;
    private String publisher;
    private Integer version;
    private String category;
}
