package com.unifacisa.si2.dtos;

public class BookDto {

	private String bookPublisherName;
	
	private Long bookPublisherId;

	private String title;

	private int pages;

	public String getbookPublisherName() {
		return bookPublisherName;
	}

	public void setbookPublisherName(String bookPublisherName) {
		this.bookPublisherName = bookPublisherName;
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

	public Long getBookPublisherId() {
		return bookPublisherId;
	}

	public void setBookPublisherId(Long bookPublisherId) {
		this.bookPublisherId = bookPublisherId;
	}
	
	

	

}
