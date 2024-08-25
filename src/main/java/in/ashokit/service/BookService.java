package in.ashokit.service;

import java.util.List;

import in.ashokit.Entity.Book;

public interface BookService {
	
	public List<Book>getAllBooks();
	
	public boolean saveBook(Book book);

	public void deleteBook(Integer bookid);
	
	public Book getBookbyId(Integer bookid);

}
