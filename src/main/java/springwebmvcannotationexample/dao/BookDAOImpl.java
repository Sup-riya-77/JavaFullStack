package springwebmvcannotationexample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import springwebmvcannotationexample.dto.BookDTO;
import springwebmvcannotationexample.exceptions.BookNotFoundException;
import springwebmvcannotationexample.utility.HibernateUtility;

@Component
public class BookDAOImpl implements BookDAO {

	Session session = HibernateUtility.getSessionFactory().openSession();

	@Override
	@Transactional
	public BookDTO addBook(BookDTO bookDTO) {
		session.beginTransaction();
		session.persist(bookDTO);
		session.getTransaction().commit();
		return bookDTO;
	}

	@Override
	@Transactional
	public BookDTO bookById(Integer bookId) throws BookNotFoundException {
		BookDTO bookDTO = session.get(BookDTO.class, bookId);
		if (bookDTO != null) {
			return bookDTO;
		} else {
			throw new BookNotFoundException("Book with bookId " + bookId + " doesn't exists");
		}

	}

	@Override
	@Transactional
	public List<BookDTO> bookByName(String bookName) throws BookNotFoundException {
	    Query<BookDTO> q = session.createNativeQuery("SELECT * FROM book_details WHERE bookName = :bookName", BookDTO.class);
	    q.setParameter("bookName", bookName);
	    List<BookDTO> resultList = q.getResultList();
	    if (!resultList.isEmpty()) {
	        return resultList;
	    } else {
	        throw new BookNotFoundException("Book with bookName " + bookName + " doesn't exist");
	    }
	}

	@Override
	@Transactional
	public List<BookDTO> bookByPublisher(String publisher) throws BookNotFoundException {
		Query<BookDTO> q=session.createNativeQuery("select * from  book_details where publisher=:publisher",BookDTO.class);
		q.setParameter("publisher", publisher);
		List<BookDTO> resultList = q.getResultList();
       if (!resultList.isEmpty()) {
			return q.getResultList();
		} else {
			throw new BookNotFoundException("Book with publisher " + publisher + " doesn't exists");
		}
	}

	@Override
	@Transactional
	public String deleteById(Integer bookId) throws BookNotFoundException {
		session.beginTransaction();
		BookDTO bookDTO = session.get(BookDTO.class, bookId);
		if (bookDTO != null) {
			session.remove(bookDTO);
			session.getTransaction().commit();
			return "Book with bookId " + bookId + " deleted successfully";
		} else {
			session.getTransaction().commit();
			throw new BookNotFoundException("Book with bookId " + bookId + " doesn't exists");
		}
	}

	@Override
	@Transactional
	public String deleteByBookName(String bookName) throws BookNotFoundException {
	    try {
	        Query q = session.createNativeQuery("DELETE FROM book_details WHERE bookName = :bookName", BookDTO.class);
	        q.setParameter("bookName", bookName);
	        int deletedCount = q.executeUpdate();

	        if (deletedCount > 0) {
	        	
	            return "Book with bookName " + bookName + " deleted successfully";
	        } else {
	            throw new BookNotFoundException("Book with bookName " + bookName + " doesn't exist");
	        }
	    } catch (Exception e) {
	    
	        e.printStackTrace();
	        throw e;
	    }
	}


	@Override
	@Transactional
	public BookDTO updateBook(BookDTO bookDTO) {
		session.merge(bookDTO);
		return bookDTO;
		
	}

	@Override
	@Transactional
	public List<BookDTO> getAllBooks() throws BookNotFoundException {
		List<Integer> allIds = session.createNativeQuery("SELECT bookId FROM book_details", Integer.class).list();
		List<BookDTO> listBookDTO = (List<BookDTO>) session.byMultipleIds(BookDTO.class).multiLoad(allIds);
		if (!listBookDTO.isEmpty()) {
			return listBookDTO;
		} else {
			throw new BookNotFoundException("Books doesn't exists");
		}
	}

}