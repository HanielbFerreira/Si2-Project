package com.unifacisa.si2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.si2.domains.Book;
import com.unifacisa.si2.exceptions.IdNotFoundException;
import com.unifacisa.si2.exceptions.InvalidCreationException;
import com.unifacisa.si2.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(bookService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) throws IdNotFoundException {
		return new ResponseEntity<Book>(bookService.findBookById(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) throws InvalidCreationException {
		return new ResponseEntity<Book>(bookService.createBook(book), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable long id) throws IdNotFoundException {
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id,@Valid @RequestBody Book book) throws IdNotFoundException {
		return new ResponseEntity<Book>(bookService.updateBook(id, book), HttpStatus.OK);
	}
	
	
	

}
