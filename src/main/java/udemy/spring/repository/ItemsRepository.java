package udemy.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import udemy.spring.entity.ToDo;

@Repository("itemsRepository")
public interface ItemsRepository extends CrudRepository<ToDo,Long> {

}
