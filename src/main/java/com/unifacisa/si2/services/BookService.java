package com.unifacisa.si2.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.si2.domains.Book;
import com.unifacisa.si2.domains.BookPublisher;
import com.unifacisa.si2.exceptions.IdNotFoundException;
import com.unifacisa.si2.exceptions.InvalidCreationException;
import com.unifacisa.si2.repositories.BookPublisherRepository;
import com.unifacisa.si2.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookPublisherRepository bookPublisherRepository;

	public Book createBook(Book book) throws InvalidCreationException {
		if (book == null) {
			throw new InvalidCreationException("Book can not be null");
		}
		Optional<BookPublisher> bp = bookPublisherRepository.findById(book.getBookPublisher().getId());
		System.out.println(bp);
		return bookRepository.save(book);
	}	

	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public List<Book> findByBookPublisherTitle(String title) {
		return bookRepository.findByBookPublisherTitle(title);
	}

	@NotFound
	public Book findBookById(long id) throws IdNotFoundException {
		if (!bookRepository.existsById(id)) {
			throw new IdNotFoundException("Id not found");
		}
		return bookRepository.findById(id).get();
	}

	public void deleteBook(long id) throws IdNotFoundException {
		if (!bookRepository.existsById(id)) {
			throw new IdNotFoundException("Id not found");
		}
		bookRepository.deleteById(id);
	}

	public Book updateBook(long id, Book book) throws IdNotFoundException {
		if (!bookRepository.existsById(id)) {
			throw new IdNotFoundException("Id not found");
		}
		Book bookUpdated = this.findBookById(id);
		bookUpdated.setBookPublisher(book.getBookPublisher());
		bookUpdated.setPages(book.getPages());
		bookUpdated.setTitle(book.getTitle());
		return bookRepository.save(bookUpdated);
	}

}
