package com.unifacisa.si2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.si2.domains.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	Book findByBookPublisherId(Long id);
}
