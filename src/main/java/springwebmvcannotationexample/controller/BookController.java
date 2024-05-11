package springwebmvcannotationexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springwebmvcannotationexample.dto.BookDTO;
import springwebmvcannotationexample.exceptions.BookNotFoundException;
import springwebmvcannotationexample.model.Book;
import springwebmvcannotationexample.service.BookService;
import springwebmvcannotationexample.utility.BookUtility;

@Controller
@RequestMapping("/bookapp")
public class BookController {

	@Autowired
	private BookService service;

	/** ADD BOOK **/
	// Load Book Details form
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public ModelAndView loadBookDetailsForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addbookform"); // setting view name or jsp name
		return mv;
	}

	// Create
	@RequestMapping(value = "/createbook", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute Book book) {
		// converting book model to dto
		BookDTO bookDTO = BookUtility.convertBookToBookDTO(book);
		// Sending data to DB
		BookDTO bokDTO = service.addBook(bookDTO);

		ModelAndView mv = new ModelAndView();
		//// converting book dto to model and setting model in ModelAndView
		mv.addObject("bookModel", BookUtility.convertBookDTOToBook(bokDTO));
		mv.setViewName("bookdetails"); // setting view name or jsp name
		return mv;
	}

	/** GET BOOK BY ID - WAY 1 **/
	// Retrieve URL -
	// http://localhost:8080/springwebmvcannotationexample/bookapp/getbook?id=1
	@GetMapping("/getbook")
	public ModelAndView bookById(@RequestParam("id") Integer bookId) {
		BookDTO bokDTO = null;
		String errorMsg = null;
		try {
			bokDTO = service.bookById(bookId);
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (bokDTO != null) {
			//// converting book dto to model and setting model in ModelAndView
			mv.addObject("bookModel", BookUtility.convertBookDTOToBook(bokDTO));
			mv.setViewName("bookdetails"); // setting view name or jsp name
		} else {
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("errormsg"); // name of the jsp is errormsg.jsp
		}
		return mv;
	}

	/** GET BOOK BY ID - WAY 2 **/
	// Load book form to pass book id as http post method
	// http://localhost:8080/springwebmvcannotationexample/bookapp/getbookform
	@GetMapping("/getbookbyidform")
	public ModelAndView showBookForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getbookbyidform"); // name of the JSP page to display
		return mv;
	}

	// This method will be called when getbookform form will be submitted
	@RequestMapping(value = "/getbookbyid", method = RequestMethod.POST)
	public ModelAndView bookByIdUsingForm(@ModelAttribute("bookId") Integer bookId) {
		BookDTO bdto = null;
		Book bok = null;
		String errorMsg = null;
		try {
			bdto = service.bookById(bookId);
			bok = BookUtility.convertBookDTOToBook(bdto);
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (bdto != null) {
			mv.addObject("bookModel", bok);
			mv.setViewName("bookdetails");
		} else {
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("errormsg"); // name of the jsp is errormsg.jsp
		}
		return mv;
	}

	/** GET BOOK BY NAME **/
	@GetMapping("/getbookbynameform")
	public ModelAndView getBookByName() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getbookbynameform"); // name of the JSP page to display
		return mv;
	}

	// This method will be called when getbookbynameform form will be submitted
	@RequestMapping(value = "/getbookbyname", method = RequestMethod.POST)
	public ModelAndView bookByNameUsingForm(@ModelAttribute("bookName") String BookName) {
		List<Book> bok = new ArrayList<Book>();
		String errorMsg = null;
		try {
			List<BookDTO> bdto = service.bookByName(BookName);
			for (BookDTO b : bdto) {
				Book boo = BookUtility.convertBookDTOToBook(b);
				bok.add(boo);
			}
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (bok != null) {
			mv.addObject("bookModel", bok);
			mv.setViewName("bookdetails");
		} else {
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("errormsg"); // name of the jsp is errormsg.jsp
		}
		return mv;
	}

	/** GET BOOK BY PUBLISHER **/
	@GetMapping("/getbookbypublisherform")
	public ModelAndView getBookByPublisher() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getbookbypublisherform"); // name of the JSP page to display
		return mv;
	}

	// This method will be called when getbookbynameform form will be submitted
	@RequestMapping(value = "/getbookbypublisher", method = RequestMethod.POST)
	public ModelAndView bookByPublisherUsingForm(@ModelAttribute("publisher") String publisher) {
		String errorMsg = null;
		List<Book> bok=new ArrayList<Book>();
		try {
			List<BookDTO> bdto = service.bookByPublisher(publisher);
			for (BookDTO b : bdto) {
				Book boo = BookUtility.convertBookDTOToBook(b);
				bok.add(boo);
			}
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (!bok.isEmpty()) {
			mv.addObject("bookModel", bok);
			mv.setViewName("bookdetails");
		} else {
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("errormsg"); // name of the jsp is errormsg.jsp
		}
		return mv;
	}

	/** GET ALL **/
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getAllBooks() throws BookNotFoundException {
		List<BookDTO> bookDTOList = service.getAllBooks();
		ModelAndView mv = new ModelAndView();
		List<Book> bookList = new ArrayList<Book>();
		for (BookDTO b : bookDTOList) {
			Book boo = BookUtility.convertBookDTOToBook(b);
			bookList.add(boo);
		}

		mv.addObject("bookModel", bookList);
		mv.setViewName("bookdetails"); // setting view name or jsp name
		return mv;
	}

	/** UPDATE BOOK **/
	@RequestMapping(value = "/updatebookform", method = RequestMethod.GET)
	public ModelAndView loadBookUpdateDetailsForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updatebookform"); // setting view name or jsp name
		return mv;
	}

	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public ModelAndView updateBook(@ModelAttribute Book book) {
		// converting book model to dto
		BookDTO bookDTO = BookUtility.convertBookToBookDTO(book);
		// Sending data to DB
		BookDTO bokDTO = service.updateBook(bookDTO);

		ModelAndView mv = new ModelAndView();
		//// converting book dto to model and setting model in ModelAndView
		mv.addObject("bookModel", BookUtility.convertBookDTOToBook(bokDTO));
		mv.setViewName("bookdetails"); // setting view name or jsp name
		return mv;
	}

	/** DELETE BOOK BY ID **/
	@RequestMapping(value = "/deletebookbyidform", method = RequestMethod.GET)
	public ModelAndView showDeleteBookForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletebookbyidform"); // Name of the JSP page for delete book form
		return mv;
	}

	@RequestMapping(value = "/deletebookbyid", method = RequestMethod.POST)
	public ModelAndView deleteBookByIdForm(@ModelAttribute("bookId") Integer bookId) {
		String errorMsg = null;
		String message = null;
		try {
			  message = service.deleteById(bookId);
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (message != null) {
			mv.addObject("successMsg", message);
			mv.setViewName("successmsg");
			return mv;
		}
		else {
			mv.addObject("errorMsg", errorMsg);
			mv.setViewName("errormsg"); // name of the jsp is errormsg.jsp
		    return mv;
		}
	}

	/** DELETE BOOK BY NAME **/
	@RequestMapping(value = "/deletebookbynameform", method = RequestMethod.GET)
	public ModelAndView deleteBookForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletebookbynameform"); // Name of the JSP page for delete book form
		return mv;
	}

	@RequestMapping(value = "/deletebookbyname", method = RequestMethod.POST)
	public ModelAndView deleteBookByNameForm(@ModelAttribute("name") String bookName) {
		String message = null;
		String errorMsg = null;
		try {
			message = service.deleteByBookName(bookName);
		} catch (BookNotFoundException e) {
			errorMsg = e.getMessage();
		}

		ModelAndView mv = new ModelAndView();
		if (message != null) {
			mv.addObject("successMsg", message);
			mv.setViewName("successmsg");
		}
		return mv;
	}

}