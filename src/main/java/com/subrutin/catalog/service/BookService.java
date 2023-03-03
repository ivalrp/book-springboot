package com.subrutin.catalog.service;

import com.subrutin.catalog.dto.BookCreateDTO;
import com.subrutin.catalog.dto.BookDetailDTO;
import com.subrutin.catalog.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {
	
	public BookDetailDTO findBookDetailById(Long bookId);

	public List<BookDetailDTO> listBookDetail();

	public void createNewBook(BookCreateDTO dto);

	public void updateBook(Long bookId, BookUpdateRequestDTO dto);

	public void deleteBook(Long bookId);

}
