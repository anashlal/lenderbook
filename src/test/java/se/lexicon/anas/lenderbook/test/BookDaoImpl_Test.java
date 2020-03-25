/**
 * 
 */
package se.lexicon.anas.lenderbook.test;




import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.*;
import org.hamcrest.core.Is;

import ch.qos.logback.classic.boolex.*;
import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.repo.BookRepository;
import se.lexicon.anas.lenderbook.services.BookDaoImp;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest

class BookDaoImp_TestBookUppdate {
	@MockBean
	private BookRepository book_repo;
	@Autowired
	private BookDaoImp bookdaoimp;
	@TestConfiguration
	static class BookDaoImpConfigration{
	@Bean
	public BookDaoImp bookdaoimp(){
	return new BookDaoImp ();
	}
	}

	@Test
	public void Bookupdate_BookTest() {
	Book orginal = new Book();
    orginal.setBookId(1);
    orginal.setDescription("jhg");
    orginal.setMaxLoanDays(10);
    orginal.setTitle("ans");
    orginal.setAvailable(true);
    Book update=  book_repo.save(orginal);
    book_repo.save(update);
    assertNotNull(orginal.getBookId(),orginal.getDescription());
	
	}

	

	
	

	
}
