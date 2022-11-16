package fi.haagahelia.palvelinohtu.BookStore2.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToOne
	private long Bookid;
	private String bookName;
	private String author;
	private int published;
	private double price;

	@JoinColumn(name = "departmentid")
	private int departmentid;

	public Book() {

	}

	public Book(List<Book> books, String bookName, long Bookid, String author, int published, double price, int departmentid) {
		super();
		
		this.Bookid = Bookid;
		this.bookName = bookName;
		this.author = author;
		this.published = published;
		this.price = price;
		this.departmentid = departmentid;
	}

	public String getbook() {
		return bookName;
	}

	public void setbook(String book) {
		this.bookName = bookName;
	}

	public long getBookid() {
		return Bookid;
	}

	public void setId(long Bookid) {
		this.Bookid = Bookid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getdepartmentid() {
		return departmentid;
	}

	public void setdepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	@Override
	public String toString() {
		if (this.departmentid != 0) 
			return "Book [id=" + Bookid + ", =" + bookName + ", book=" + author + ", author=" + published + " published ="
					+ this.getdepartmentid() + "]";

		else
			return "Book [id=" + Bookid + ", book=" + bookName + ", author=" + author + ", published=" + published
					+ ", price =" + price + "]";
	}
}
