package com.unifacisa.si2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.si2.domains.BookPublisher;
import com.unifacisa.si2.exceptions.InvalidCreationException;
import com.unifacisa.si2.services.BookPublisherService;

@RestController
@RequestMapping("/bookPublisher")
public class BookPublisherController {

	@Autowired
	private BookPublisherService bookPublisherService;
	
	@GetMapping
	public ResponseEntity<List<BookPublisher>> getAllBookPublisher() {
		return new ResponseEntity<List<BookPublisher>>(bookPublisherService.findAll(), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<BookPublisher> createBookPublisher(@Valid @RequestBody BookPublisher book) throws InvalidCreationException {
		return new ResponseEntity<BookPublisher>(bookPublisherService.createBookPublisher(book), HttpStatus.CREATED);
	}
	
}
