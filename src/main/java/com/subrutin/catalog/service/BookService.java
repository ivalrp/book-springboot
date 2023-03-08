package com.subrutin.catalog.service;

import com.subrutin.catalog.dto.BookCreateRequestDTO;
import com.subrutin.catalog.dto.BookDetailResponseDTO;
import com.subrutin.catalog.dto.BookUpdateRequestDTO;

import java.util.List;

public interface BookService {
	
	public BookDetailResponseDTO findBookDetailById(String bookId);

	public List<BookDetailResponseDTO> listBookDetail();

	public void createNewBook(BookCreateRequestDTO dto);

	public void updateBook(Long bookId, BookUpdateRequestDTO dto);

	public void deleteBook(Long bookId);

}
