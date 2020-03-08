package se.lexicon.anas.lenderbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import se.lexicon.anas.lenderbook.model.LibraryUser;
import se.lexicon.anas.lenderbook.repo.LibraryUserRepository;

public class LibrareUserDaoImp implements LibrareUserDao{

	
	private LibraryUserRepository libraryuser_rep;
	
		@Autowired
		public LibrareUserDaoImp(LibraryUserRepository libraryuser_rep) {
			super();
			this.libraryuser_rep = libraryuser_rep;
		}
	
		@Override
		public LibraryUser findById_LibraryUser(int id) {
			return libraryuser_rep.findById(id).orElseThrow(IllegalArgumentException::new);
		}
	
		@Override
		public LibraryUser save_LibraryUser(LibraryUser libraryUser) {
			return libraryuser_rep.save(libraryUser);
		}
	
		@Override
		public boolean remove(int id) {
			libraryuser_rep.deleteById(id);
	
			return libraryuser_rep.existsById(id);
	
		}
	
		@Override
		public List<LibraryUser> findAll() {
	
			return (List<LibraryUser>) libraryuser_rep.findAll();
		}
	
		@Override
		public LibraryUser update_LibraryUser(int id, LibraryUser update) {
	
			LibraryUser orginal = findById_LibraryUser(id);
			orginal.setEmail(update.getEmail());
			orginal.setName(update.getName());
			orginal.setRegDate(update.getRegDate());
	
			return libraryuser_rep.save(orginal);
		}
	
		@Override
		public LibraryUser findBy_Email(String email) {
	
			return libraryuser_rep.findByEmail(email);
		}
}
