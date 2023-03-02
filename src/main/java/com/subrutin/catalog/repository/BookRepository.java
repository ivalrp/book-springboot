package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.Book;

import java.util.List;

public interface BookRepository {
	public Book findBookById(Long id);

	public List<Book> findAll();

	public void save(Book book);

	public void update(Book book);

}
