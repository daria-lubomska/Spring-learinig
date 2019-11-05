package udemy.spring.service;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udemy.spring.entity.ToDo;
import udemy.spring.repository.ItemsRepository;

@Service
@Transactional
public class ToDosServiceImpl implements ToDosService {

  private ItemsRepository itemsRepository;

  @Autowired
  public ToDosServiceImpl(@Qualifier("itemsRepository") ItemsRepository itemsRepository) {
    this.itemsRepository = itemsRepository;
  }

  @Override
  public List<ToDo> getToDoItems() {
    return (List<ToDo>) itemsRepository.findAll();
  }

  @Override
  public void addToDoItem(@NonNull ToDo toDo) {
    itemsRepository.save(toDo);
  }

  @Override
  public ToDo getToDoItem(long id) {
    return itemsRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public void deleteToDoItem(long id) {
    itemsRepository.deleteById(id);
  }
}
