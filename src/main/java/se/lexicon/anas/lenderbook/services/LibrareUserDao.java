package se.lexicon.anas.lenderbook.services;

import java.util.List;

import se.lexicon.anas.lenderbook.model.LibraryUser;

public interface LibrareUserDao {
	
	LibraryUser findById_LibraryUser(int id);
	
	LibraryUser save_LibraryUser(LibraryUser libraryUser);

	boolean remove(int id);

	List<LibraryUser> findAll();
	
	LibraryUser update_LibraryUser(int id, LibraryUser update);

	LibraryUser findBy_Email(String email);

}
