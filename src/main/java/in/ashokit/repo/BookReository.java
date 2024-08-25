package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Book;

public interface BookReository  extends JpaRepository<Book, Integer>{
	
	public List<Book>findByActiveSw(String status);

}
