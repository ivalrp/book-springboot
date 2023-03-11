package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.Author;
import com.subrutin.catalog.dto.AuthorQueryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //method name convention
    //find + keyword
    //sql -> select * from Author a where a.id =: authorId


    @Override
    public Optional<Author> findById(Long id);

    public Optional<Author> findBySecureId(String id);

    //sql select * from Auhtor a where a.id =:id AND deleted := false
    public Optional<Author> findByIdAndDeletedFalse(Long id);


    //sql -> select a from Author a where a.name Like =: authorId
    public List<Author> findByNameLike(String authorName);

    public List<Author> findBySecureIdIn(List<String> authorIdList);

    @Query("SELECT new com.subrutin.catalog.dto.AuthorQueryDTO(b.id, bc.name) " +
            "FROM Book b " +
            "JOIN b.authors bc " +
            "WHERE b.id IN :bookIdList ")
    public List<AuthorQueryDTO> findAuthorByBookIdList(List<Long> bookIdList);

}
