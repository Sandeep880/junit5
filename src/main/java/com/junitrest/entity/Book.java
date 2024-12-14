package com.junitrest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name ="book_record")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    @NotNull
    private String name;
    @NotNull
    private String summary;

    private int rating;

    public Book() {
    }

    public Book(Long bookId, String name, String summary, int rating) {
        this.bookId = bookId;
        this.name = name;
        this.summary = summary;
        this.rating = rating;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public int getRating() {
        return rating;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
