package fi.haagahelia.palvelinohtu.BookStore2.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import fi.haagahelia.palvelinohtu.BookStore2.domain.Book;
import fi.haagahelia.palvelinohtu.BookStore2.domain.BookStoreRepository;
import fi.haagahelia.palvelinohtu.BookStore2.domain.department;
import fi.haagahelia.palvelinohtu.BookStore2.domain.departmentRepository;

@RestController
@ResponseBody
public class BookstoreController {


	@GetMapping("/department")
	public Iterable<department> getDepartments() {
		return drepository.findAll();
	}

	@Autowired
	private BookStoreRepository repository;
	private departmentRepository drepository;

	@GetMapping("/bookStore")
	public Iterable<Book> getBooks() {
		return repository.findAll();
	}

	@RequestMapping("/department")
	public Iterable<department> getdepartments() {
		return drepository.findAll();
	}

	// RESTful service to get student by id
	@GetMapping(value = "/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") long Bookid) {
		return repository.findById((long) Bookid);
	}

	// Lisää kirja
	@PostMapping(value = "/add")
	public String addStudent(Model model) {
		model.addAttribute("bookName", new Book());
		model.addAttribute("departments", drepository.findAll());
		return "lisaabook";
	}

	// Tallenna kirja
	@PutMapping(value = "/save")
	public String save(Book Book) {
		repository.save(Book);
		return "redirect:bookStore";
	}

	// Poista kirja
	@DeleteMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteStudent(@PathVariable("id") Long Bookid) {
		repository.deleteById(Bookid);
		return "redirect:../bookStore";
	}
	
}
