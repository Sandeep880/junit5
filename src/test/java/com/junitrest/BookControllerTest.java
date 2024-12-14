package com.junitrest;
import com.junitrest.controller.BookController;
import com.junitrest.entity.Book;
import com.junitrest.repo.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    Book RECORD_1 = new Book(1L,"Atomic Habbits" , "How to build better habbits",4);
    Book RECORD_2 = new Book(2L,"Thinking Fast and Slow","How to create good mental",3);
    Book RECORD_3 = new Book(3L,"Grokking Algorithms","Learn algorithm the fun way",5);


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllBook_success() throws Exception {
        List<Book> record = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2,RECORD_3));
        when(bookController.getAllBookRecords()).thenReturn(record);
        //Assertions.assertEquals(record, bookController.getAllBookRecords());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect()

                )

    }

}
