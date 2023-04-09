package com.example.bookmanagerminitest.service;


import com.example.bookmanagerminitest.model.Book;

import java.util.Optional;

public interface IBookService
{
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void remove(Long id);


    Double toTalMoneyBook();
}
