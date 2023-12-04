package HAYE.demo.repos;

import HAYE.demo.data.Person;
import HAYE.demo.data.Url;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepo extends CrudRepository<Url, Long> {

}