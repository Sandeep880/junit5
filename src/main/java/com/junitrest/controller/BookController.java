package com.junitrest.controller;

import com.junitrest.entity.Book;
import com.junitrest.exception.NotFoundException;
import com.junitrest.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getAllBookRecords() {
        return bookRepository.findAll();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping("/")
    public Book createBookRecord(@RequestBody Book bookRecord) {
        return bookRepository.save(bookRecord);
    }

    @PutMapping("/")
    public Book updateBookRecord(@RequestBody Book bookRecord) throws NotFoundException {
        if(bookRecord == null || bookRecord.getBookId() == null) {
            throw new NotFoundException("Book Id must not be Null");
        }
        Optional<Book> book = bookRepository.findById(bookRecord.getBookId());
        if(!book.isPresent())
        {
          throw new NotFoundException("Book is not present in database with given bookId");
        }
        Book existingBook = book.get();
        existingBook.setName(bookRecord.getName());
        existingBook.setSummary(bookRecord.getSummary());
        existingBook.setRating(bookRecord.getRating());

        return bookRepository.save(existingBook);
    }



}
