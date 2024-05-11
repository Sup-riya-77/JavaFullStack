package springwebmvcannotationexample.utility;

import springwebmvcannotationexample.dto.BookDTO;
import springwebmvcannotationexample.model.Book;

public class BookUtility {
	public static BookDTO  convertBookToBookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(book.getBookId());
		bookDTO.setBookName(book.getBookName());
		bookDTO.setPrice(book.getPrice());
		bookDTO.setPublisher(book.getPublisher());
		
		return bookDTO;
	}
	
	public static Book convertBookDTOToBook(BookDTO dto) {
		Book book = new Book();
		book.setBookId(dto.getBookId());
		book.setBookName(dto.getBookName());
		book.setPrice(dto.getPrice());
		book.setPublisher(dto.getPublisher());
		
		return book;
	}

}
