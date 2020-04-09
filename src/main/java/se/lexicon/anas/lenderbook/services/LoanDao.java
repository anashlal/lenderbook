package se.lexicon.anas.lenderbook.services;

import java.util.List;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.model.LibraryUser;
import se.lexicon.anas.lenderbook.model.Loan;

public interface LoanDao {
	
	Loan findById_Loan(int id);
	
		Loan save_Loan(Loan loan);
	
		boolean remove(int id);
	
		List<Loan> findAll();
	
		Loan update_Loan(int id, Loan update);
	
		Loan findByLibraryUser(LibraryUser user);
	
		Loan findByBook(Book book);
	
		Loan findByterminated(Boolean Isterminated);

		Loan findBylibraryUserId (int userid);
		
		Loan findByBookId (int bookid);
}
