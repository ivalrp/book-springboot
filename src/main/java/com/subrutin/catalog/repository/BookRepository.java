package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
	public Optional<Book> findById(Long id);
//
//	public List<Book> findAll();
//
//	public void save(Book book);
//
//	public void update(Book book);
//
//	public void delete(Long bookId);

}
