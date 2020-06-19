package com.unifacisa.si2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.si2.domains.BookPublisher;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long>{
	
	BookPublisher findByName(String title);
	boolean existsByName(String name);

}
