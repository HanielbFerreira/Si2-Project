package com.unifacisa.si2.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Enter the name of the book publisher")
	private String bookPublisher;

	@NotEmpty(message = "Enter the title of the book") 
	private String title;

	@NotNull(message = "The quantity of pages cannot be null")
	@Min(value=10, message = "The book must contain at least 10 pages")
	private int pages;
	
	@NotEmpty(message = "Enter the comments of the book") 
	private String comments;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
