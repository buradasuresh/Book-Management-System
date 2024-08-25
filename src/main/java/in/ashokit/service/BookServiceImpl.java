package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Book;
import in.ashokit.repo.BookReository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	public BookReository bookrepo;
	
   @Override
	public List<Book>getAllBooks() {
		return bookrepo.findByActiveSw("Y");
	}
@Override
public boolean saveBook(Book book) {
	book.setActiveSw("Y");
	  Book savedBook = bookrepo.save(book);
	  return savedBook.getBookid()!=null;
		 
}
@Override
public void deleteBook(Integer bookid) {
	
	Optional<Book> findById = bookrepo.findById(bookid);
	Book book = findById.get();
	book.setActiveSw("N");
	bookrepo.save(book);
}
@Override
public Book getBookbyId(Integer bookid) {
	Optional<Book> findById = bookrepo.findById(bookid);
	if(findById.isPresent()) {
		return findById.get();
		
	}
	
	return null;
}

}
