
package springwebmvcannotationexample.dao;

import java.util.List;

import springwebmvcannotationexample.dto.BookDTO;
import springwebmvcannotationexample.exceptions.BookNotFoundException;

public interface BookDAO {
	// Create
	public BookDTO addBook(BookDTO bookDTO);

	// Retrieve by Id
	public BookDTO bookById(Integer bookId) throws BookNotFoundException;

	// Retrieve by bookName
	public List<BookDTO> bookByName(String bookName) throws BookNotFoundException;

	// Retrieve By publisher
	public List<BookDTO> bookByPublisher(String publisher) throws BookNotFoundException;

	// Delete by bookId
	public String deleteById(Integer bookId) throws BookNotFoundException;

	// Delete by name
	public String deleteByBookName(String bookName) throws BookNotFoundException;

	// Update Book
	public BookDTO updateBook(BookDTO bookDTO);

	public List<BookDTO> getAllBooks() throws BookNotFoundException;
}
