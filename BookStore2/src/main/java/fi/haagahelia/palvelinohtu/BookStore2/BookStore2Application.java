package fi.haagahelia.palvelinohtu.BookStore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.palvelinohtu.BookStore2.domain.department;
import fi.haagahelia.palvelinohtu.BookStore2.domain.departmentRepository;
import fi.haagahelia.palvelinohtu.BookStore2.domain.Book;
import fi.haagahelia.palvelinohtu.BookStore2.domain.BookStoreRepository;

@SpringBootApplication
public class BookStore2Application {
	private static final Logger log = LoggerFactory.getLogger(BookStore2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStore2Application.class, args);
		
	}

	@Bean
	public CommandLineRunner demo(BookStoreRepository repository, departmentRepository drepository) {
		return (args) -> {

			log.info("tallenna kirjoja");
			
			Book book1 = new Book();
			book1.setbook("book");
			repository.save(book1);
			
			department department1 = new department();
			department1.setDepartment((int) 1001);
			drepository.save(department1);
			
			log.info("fetchaa kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};

	}

}
