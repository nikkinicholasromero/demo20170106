package ph.com.nikkinicholas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ph.com.nikkinicholas.domain.Student;

import javax.transaction.Transactional;

/**
 * Created by nikkiromero on 16/01/2017.
 */
@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, String> {
}
