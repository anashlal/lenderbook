package se.lexicon.anas.lenderbook.services;

import java.util.List;
import se.lexicon.anas.lenderbook.model.Book;

public interface BookDao {
	
	Book findById_Book(int id);

	Book save_Book(Book book);

	boolean remove(int id);

	List<Book> findAll();

	Book update_Book(int id, Book update);

	Book findBytitle(String title);

	Book findByavailable(boolean Isavailable);

	Book findByreserved(boolean Isreserved);

}
