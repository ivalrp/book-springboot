package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //method name convention
    //find + keyword
    //sql -> select * from Author a where a.id =: authorId


    @Override
    public Optional<Author> findById(Long id);

    //sql -> select a from Author a where a.name Like =: authorId
    public List<Author> findByNameLike(String authorName);

}
