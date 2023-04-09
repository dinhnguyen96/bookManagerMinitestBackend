package com.example.bookmanagerminitest.controller;


import com.example.bookmanagerminitest.model.Book;
import com.example.bookmanagerminitest.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private IBookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBookPage()
    {
        List<Book> books = (List<Book>)bookService.findAll();

        if (books.size() == 0)
        {
            return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> customerOptional = bookService.findById(id);
        if (!customerOptional.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (!bookOptional.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        book.setId(bookOptional.get().getId());
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }
    @GetMapping("/information/{id}")
    public ResponseEntity<Book> getInforBook(@PathVariable("id") Long id)
    {
        Optional<Book>optionalBook = bookService.findById(id);
        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }

    @GetMapping("/watchTotalMoney")
    public ResponseEntity<Double> getTotalMoneyBook()
    {
        return new ResponseEntity<>(bookService.toTalMoneyBook(), HttpStatus.OK);
    }

}
