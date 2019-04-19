package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		Author eric = new Author("Eric", "Evans");
		Publisher harperPublisher = new Publisher("Harper Collins");
		Book book = new Book("Domain Driven Design", "1234", harperPublisher);
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		authorRepository.save(eric);
		publisherRepository.save(harperPublisher);
		bookRepository.save(book);
		
		
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("worx");
		Book book1 = new Book("J2EE Development without EJB", "23456", worx);
		rod.getBooks().add(book1);
		book1.getAuthors().add(rod);
		authorRepository.save(rod);
		publisherRepository.save(worx);
		bookRepository.save(book1);
	}

}
