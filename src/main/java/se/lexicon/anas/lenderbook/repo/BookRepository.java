package se.lexicon.anas.lenderbook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.lexicon.anas.lenderbook.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findAll();
}
