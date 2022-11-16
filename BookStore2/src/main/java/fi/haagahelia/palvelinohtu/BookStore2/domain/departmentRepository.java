package fi.haagahelia.palvelinohtu.BookStore2.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface departmentRepository extends CrudRepository <department, Long>{
	List<department> findByName(Long departmentid, String category);
}
