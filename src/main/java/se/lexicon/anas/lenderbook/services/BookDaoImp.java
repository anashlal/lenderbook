package se.lexicon.anas.lenderbook.services;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.anas.lenderbook.model.Book;
import se.lexicon.anas.lenderbook.repo.BookRepository;

@Service
@Transactional
public class BookDaoImp implements BookDao {

	private BookRepository book_repo;

	// @Autowired
	// public BookDaoImpl(Book_Repo book_repo) {
	// super();
	// this.book_repo = book_repo;
	// }

	@Override
	public Book findById_Book(int id) {
		return book_repo.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public Book save_Book(Book book) {

		return book_repo.save(book);
	}

	@Override
	public boolean remove(int id) {
		book_repo.deleteById(id);

		return book_repo.existsById(id);
	}

	@Override
	public List<Book> findAll() {

		return (List<Book>) book_repo.findAll();
	}

	@Override
	public Book update_Book(int id, Book update) {
		Book orginal = findById_Book(id);
		orginal.setTitle(update.getTitle());
		orginal.setMaxLoanDays(update.getMaxLoanDays());
		orginal.setAvailable(update.isAvailable());
		orginal.setReserved(update.isReserved());
		orginal.setFinePerDay(update.getFinePerDay());
		orginal.setDescription(update.getDescription());
		return book_repo.save(orginal);
	}

	@Override
	public Book findBytitle(String title) {

		return book_repo.findBytitle(title);
	}

	@Override
	public Book findByavailable(boolean Isavailable) {

		return book_repo.findByavailable(Isavailable);
	}

	@Override
	public Book findByreserved(boolean Isreserved) {

		return book_repo.findByreserved(Isreserved);
	}

}
