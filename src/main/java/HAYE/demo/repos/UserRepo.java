package HAYE.demo.repos;

import HAYE.demo.data.Person;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Person, Long> {

}
