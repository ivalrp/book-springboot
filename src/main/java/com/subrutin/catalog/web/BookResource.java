package com.subrutin.catalog.web;

import com.subrutin.catalog.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import com.subrutin.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {
	
	private final BookService bookService;

	@GetMapping("/v1/book/{bookId}")
	public ResponseEntity<BookDetailResponseDTO> findBookDetail(@PathVariable("bookId") String id) {
		StopWatch stopWatch = new StopWatch();
		log.info("start findBookDetail "+id);
		stopWatch.start();
		BookDetailResponseDTO result =  bookService.findBookDetailById(id);
		log.info("finish findBookDetail. execution time = {}",stopWatch.getTotalTimeMillis());
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/v1/book")
	public ResponseEntity<Void> createNewBook(@RequestBody BookCreateRequestDTO dto){
		bookService.createNewBook(dto);
		return ResponseEntity.created(URI.create("/book")).build();
	}

	@GetMapping("/v2/book")
	public ResponseEntity<ResultPageResponseDTO<BookListResponseDTO>> findBookList(
			@RequestParam(name = "page", required = true, defaultValue = "0") Integer page,
			@RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
			@RequestParam(name = "sortBy", required = true, defaultValue = "title") String sortBy,
			@RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
			@RequestParam(name = "bookTitle", required = false, defaultValue = "") String bookTitle,
			@RequestParam(name = "publisherName", required = false, defaultValue = "") String publisher,
			@RequestParam(name = "authorName", required = false, defaultValue = "") String authorName
	){
		return ResponseEntity.ok().body(bookService.findBookList(page, limit, sortBy, direction, bookTitle, publisher, authorName));
	}

	@GetMapping("/v1/book")
	public ResponseEntity<List<BookDetailResponseDTO>> findBookList(){
		return ResponseEntity.ok().body(bookService.listBookDetail());
	}

	@PutMapping("/v1/book/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId,
										   @RequestBody BookUpdateRequestDTO dto){
		bookService.updateBook(bookId, dto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/v1/book/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();

	}
}
