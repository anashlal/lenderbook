package se.lexicon.anas.lenderbook.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import se.lexicon.anas.lenderbook.model.*;
import se.lexicon.anas.lenderbook.repo.*;
import se.lexicon.anas.lenderbook.services.LibrareUserDaoImp;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
class Book_Test_Repo {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LibraryUserRepository libraryUserRepo;
	
	@Test
	public void findByTitle_ShouldReturnTheCurrectBook() {
	    // given
	    Book book = new Book("title", 10, new BigDecimal("1.0"), "description");
	    entityManager.persist(book);
	    
	    // when
	    Book found = bookRepository.findBytitle("title");
	    
	     // then
	    assertEquals(book.getTitle(), found.getTitle());
	}
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
		LibraryUser libraryUser = new LibraryUser(LocalDate.now(), "", "test@test.com");
		entityManager.persist(libraryUser);
	    
	    // when
		LibraryUser find = libraryUserRepo.findByEmail("test@test.com");
		
	    // then
	    assertNotNull(find);
	}
	
	@Test
	public void findById_Book_ShouldReturnTheCurrectBook() {
	    // given
	    Book book = new Book("title", 10, new BigDecimal("1.0"), "description");
	    entityManager.persist(book);
	    
	    // when
	    Book found = bookRepository.findById(book.getBookId()).orElseThrow(IllegalArgumentException::new);
	    
	     // then
	    assertEquals(book.getBookId(), found.getBookId());
	}
	
	@Test
	public void findByavailable_Book_ShouldReturnTheCurrectBook() {
	    // given
	    Book book = new Book("title", 10, new BigDecimal("1.0"), "description");
	    entityManager.persist(book);
	    
	    // when
	    Book found = bookRepository.findById(book.getBookId()).orElseThrow(IllegalArgumentException::new);
	    
	     // then
	    assertEquals(book.isAvailable(), found.isAvailable());
	}
	
	@Test
	public void findByRemove_Book_ShouldReturnTheExistBook() {
	    // given
	    Book book = new Book("title", 10, new BigDecimal("1.0"), "description");
	    entityManager.persist(book);
	    
	    
	    // when
	    
	     bookRepository.delete(book);
	    
	     // then
	    assertEquals(bookRepository.existsById(book.getBookId()), false );
	}
	
	@Test
	public void findByUpdate_Book_ShouldReturnTheNewBook() {
	    // given
	    Book orginal = new Book("title", 10, new BigDecimal("1.0"), "description");
	    entityManager.persist(orginal);
	    
	    
	    // when
	    
	    orginal.setDescription("jhg");
	    orginal.setMaxLoanDays(11);
	    orginal.setTitle("ans");
	    orginal.setAvailable(false);
	    orginal.setFinePerDay(new BigDecimal("2.0"));
	    entityManager.persist(orginal);
	     // then
	    Book update=bookRepository.findById(orginal.getBookId()).orElseThrow(IllegalArgumentException::new);
	    
	    assertEquals(update.isAvailable(), false );
	    // to confirm the update 
	    assertEquals(update.getTitle(), "ans" );
	    assertEquals(update.getDescription(), "jhg" );
	    assertEquals(update.getMaxLoanDays(), 11 );
	   
	}
}
