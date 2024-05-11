package springwebmvcannotationexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springwebmvcannotationexample.dao.BookDAO;
import springwebmvcannotationexample.dto.BookDTO;
import springwebmvcannotationexample.exceptions.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public BookDTO addBook(BookDTO bookDTO) {

		return bookDAO.addBook(bookDTO);
	}

	@Override
	public BookDTO bookById(Integer bookId) throws BookNotFoundException {
		return bookDAO.bookById(bookId);
	}

	@Override
	public List<BookDTO> bookByName(String bookName) throws BookNotFoundException {
		return bookDAO.bookByName(bookName);
	}

	@Override
	public List<BookDTO> bookByPublisher(String publisher) throws BookNotFoundException {
		return bookDAO.bookByPublisher(publisher);
	}

	@Override
	public List<BookDTO> getAllBooks() throws BookNotFoundException {
		return bookDAO.getAllBooks();
	}

	@Override
	public String deleteById(Integer bookId) throws BookNotFoundException {
		return bookDAO.deleteById(bookId);
	}

	@Override
	public String deleteByBookName(String bookName) throws BookNotFoundException {
		return bookDAO.deleteByBookName(bookName);
	}

	@Override
	public BookDTO updateBook(BookDTO bookDTO) {
		return bookDAO.updateBook(bookDTO);
	}

}