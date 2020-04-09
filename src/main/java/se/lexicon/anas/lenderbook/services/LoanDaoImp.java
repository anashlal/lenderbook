package se.lexicon.anas.lenderbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.model.LibraryUser;
import se.lexicon.anas.lenderbook.model.Loan;
import se.lexicon.anas.lenderbook.repo.BookRepository;
import se.lexicon.anas.lenderbook.repo.LibraryUserRepository;
import se.lexicon.anas.lenderbook.repo.LoanRepository;

@Service
@Transactional
public class LoanDaoImp implements LoanDao {
	
	private LoanRepository loan_repo;
	private LibraryUserRepository libraryuser_rep;
	private BookRepository book_repo;
	
		@Autowired
		public LoanDaoImp(LoanRepository loan_repo) {
			super();
			this.loan_repo = loan_repo;
		}
	
		@Override
		public Loan findById_Loan(int id) {
			return loan_repo.findById(id).orElseThrow(IllegalArgumentException::new);
		}
	
		@Override
		public Loan save_Loan(Loan loan) {
			return loan_repo.save(loan);
		}
	
		@Override
		public boolean remove(int id) {
			loan_repo.deleteById(id);
	
			return loan_repo.existsById(id);
		}
	
		@Override
		public List<Loan> findAll() {
			return (List<Loan>) loan_repo.findAll();
		}
	
		@Override
		public Loan update_Loan(int id, Loan update) {
	
			Loan orginal = findById_Loan(id);
			orginal.setLoanTaker(update.getLoanTaker());
			orginal.setBook(update.getBook());
			orginal.setLoanDate(update.getLoanDate());
			orginal.setTerminated(update.isTerminated());
			return loan_repo.save(orginal);
		}
	
		@Override
		public Loan findByLibraryUser(LibraryUser user) {
	
			return loan_repo.findByLibraryUser(user);
		}
	
		@Override
		public Loan findByBook(Book book) {
	
			return findByBook(book) ;
		}
	
		@Override
		public Loan findByterminated(Boolean Isterminated) {
	
			return loan_repo.findByterminated(Isterminated);
	
		}

		@Override
		public Loan findBylibraryUserId(int userid) {
			LibraryUser orginal = libraryuser_rep.findById(userid).orElseThrow(IllegalArgumentException::new);
			
			return loan_repo.findByLibraryUser(orginal);
		}

		@Override
		public Loan findByBookId(int bookid) {
		
			return loan_repo.findById(bookid).orElseThrow(IllegalArgumentException::new);
		}

}
