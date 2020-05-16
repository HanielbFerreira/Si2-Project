package com.unifacisa.si2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.si2.domains.BookPublisher;
import com.unifacisa.si2.repositories.BookPublisherRepository;

@Service
public class BookPublisherService {
	
	@Autowired
	private BookPublisherRepository bookPublisherRepository;
	
	public BookPublisher createBookPublishew(BookPublisher bookPublisher) {
		return bookPublisherRepository.save(bookPublisher);
	}
	
	public List<BookPublisher> findAll() {
		return bookPublisherRepository.findAll();
	}
	
	public BookPublisher findById(Long id) {
		return bookPublisherRepository.findById(id).get();	
	}
	
	public void deleteBookPublisher(Long id) {
		bookPublisherRepository.deleteById(id);
	}

}
