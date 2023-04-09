package com.example.bookmanagerminitest.service.impl;


import com.example.bookmanagerminitest.model.Book;
import com.example.bookmanagerminitest.repository.IBookRepository;
import com.example.bookmanagerminitest.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BoolServiceImpl implements IBookService
{

    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id)
    {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public Double toTalMoneyBook() {
        return bookRepository.toTalMoneyOfBook();
    }

}
