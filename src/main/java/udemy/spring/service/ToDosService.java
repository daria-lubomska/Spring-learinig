package udemy.spring.service;

import java.util.List;
import lombok.NonNull;
import udemy.spring.entity.ToDo;

public interface ToDosService {

  public List<ToDo> getToDoItems();

  public void addToDoItem( @NonNull ToDo toDo);

  public ToDo getToDoItem(long id);

  public void deleteToDoItem(long id);
}
