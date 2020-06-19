package com.unifacisa.si2.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;

	@ManyToOne
	private BookPublisher bookPublisher;

	@NotEmpty(message = "Enter the title of the book") 
	private String title;

	@NotNull(message = "The quantity of pages cannot be null")
	@Min(value=10, message = "The book must contain at least 10 pages")
	private int pages;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BookPublisher getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(BookPublisher bookPublisher) {
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
	
}
