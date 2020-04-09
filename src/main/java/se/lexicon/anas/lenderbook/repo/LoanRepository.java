package se.lexicon.anas.lenderbook.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.model.LibraryUser;
import se.lexicon.anas.lenderbook.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
	
	Loan findByLibraryUser(LibraryUser user);
	
	Loan findByterminated(Boolean Isterminated);


}
