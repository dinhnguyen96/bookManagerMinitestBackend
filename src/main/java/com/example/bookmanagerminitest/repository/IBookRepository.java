package com.example.bookmanagerminitest.repository;

import com.example.bookmanagerminitest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long>
{
    @Query("select sum(bookPrice) from Book ")
    Double toTalMoneyOfBook();
}
