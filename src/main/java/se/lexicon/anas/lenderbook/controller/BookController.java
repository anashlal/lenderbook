package se.lexicon.anas.lenderbook.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.repo.BookRepository;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	public BookController() {
		
	}

	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/")
	public List<Book> findAll(){
		List<Book> customers = bookRepo.findAll();
		return customers;
	}
	
	@GetMapping("/createtest")
	public String createTestBook(){
		bookRepo.save(new Book("book title", 10,  new BigDecimal("0.03"), "book descrption"));
		return "book is created";
	}
	
	@PostMapping("/")
	public String create(@RequestBody Book book){
		bookRepo.save(new Book(book.getTitle(), book.getMaxLoanDays(),  book.getFinePerDay(), book.getDescription()));
		return "book is created";
	}
}

