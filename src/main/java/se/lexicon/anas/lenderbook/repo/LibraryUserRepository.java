package se.lexicon.anas.lenderbook.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.anas.lenderbook.model.LibraryUser;

@Repository
public interface LibraryUserRepository  extends CrudRepository<LibraryUser, Integer> {
	
	LibraryUser findByEmail(String email);

}
