package com.michalzyw.h2database.repository;

import com.michalzyw.h2database.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Integer>  {
}
