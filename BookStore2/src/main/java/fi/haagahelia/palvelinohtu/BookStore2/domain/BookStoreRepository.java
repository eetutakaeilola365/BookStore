package fi.haagahelia.palvelinohtu.BookStore2.domain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public interface BookStoreRepository extends CrudRepository <Book, Long>{
	List<Book> findByBookid(Long Bookid, String author, int published, double price);

	 
	@Autowired(required=true)
	@Bean(name = "entityManagerFactory")
	public static LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		return sessionFactory;
	}
	
}
