package com.doruk.hazelcastdemo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "BOOK_STORE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"id"})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_book", allocationSize = 1)
    @GeneratedValue(generator = "seq_book", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLISH_YEAR")
    private Integer year;

    @Column(name = "ISBN")
    private String isbnCode;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CATEGORY")
    private String category;
}
