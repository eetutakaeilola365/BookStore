package fi.haagahelia.palvelinohtu.BookStore2.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface userRepository extends CrudRepository<user, Long> {
	user findByUsername(String username);
}
