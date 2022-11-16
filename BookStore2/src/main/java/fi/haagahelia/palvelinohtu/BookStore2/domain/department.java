package fi.haagahelia.palvelinohtu.BookStore2.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@JoinColumn(name = "departmentid")

	protected int departmentid;
	protected String category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Book> books;

	public department() {
	}

	public department(List<Book> books) {
		super();
		this.books = books;
	}

	public department(int departmentid, String category) {
		super();
		this.departmentid = departmentid;
		this.category = category;

	}

	public int getDepartment() {
		return departmentid;
	}

	public void setDepartment(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getName() {
		return category;
	}

	public void setName(String category) {
		this.category = category;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setStudents(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", category=" + category + "]";
	}

}
