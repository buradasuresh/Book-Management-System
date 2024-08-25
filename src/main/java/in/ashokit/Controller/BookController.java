package in.ashokit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.Entity.Book;
import in.ashokit.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("book",new Book());
		mav.setViewName("index");
		
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView saveBook(Book book) {
		ModelAndView mav=new ModelAndView();
		
		boolean status = service.saveBook(book);
		if(status) {
			mav.addObject("succmesg", "BookSaved");
		}else {
			mav.addObject("errmesg", "Fail to Save");
		}
		mav.setViewName("index");
		return mav;
		
	}
	@GetMapping("/books")
	public ModelAndView getBooks() {
		ModelAndView mav=new ModelAndView();
		  List<Book> allBooks = service.getAllBooks();
		  mav.addObject("books", allBooks);
		  mav.setViewName("booksview");
		
		return mav;
	}
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer bookid) {
	service.deleteBook(bookid);
	
		ModelAndView mav=new ModelAndView();
		  List<Book> allBooks = service.getAllBooks();
		  mav.addObject("books", allBooks);
		  mav.setViewName("booksview");
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam("bookId")Integer bookid) {
		Book bookbyId = service.getBookbyId(bookid);
		ModelAndView mav =new  ModelAndView();
		mav.addObject("books",bookbyId);
		mav.setViewName("index");

		return mav;
		
	}
	
	
}
