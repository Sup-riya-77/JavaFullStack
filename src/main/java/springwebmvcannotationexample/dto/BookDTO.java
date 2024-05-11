package springwebmvcannotationexample.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="book_details")
public class BookDTO {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
		private Integer bookId;
		private String bookName;
		private String publisher;
		private Double price;
}