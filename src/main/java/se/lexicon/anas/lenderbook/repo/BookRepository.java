package se.lexicon.anas.lenderbook.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.model.Loan;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	
	List<Book> findAll();
	
	Book findBytitle(String title);
	
	Book findByavailable(boolean Isavailable);

	Book findByreserved(boolean Isreserved);
	
	
}
