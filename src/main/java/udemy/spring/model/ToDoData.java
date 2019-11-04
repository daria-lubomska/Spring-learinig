package udemy.spring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import lombok.NonNull;

public class ToDoData {

  private static long idVal = 1;

  private final List<ToDoItem> items = new ArrayList<>();

  public ToDoData() {
  }

  public List<ToDoItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public void addItem( @NonNull ToDoItem toDoItem) {
    toDoItem.setId(idVal);
    items.add(toDoItem);
    idVal++;
  }

  public void removeItem(long id){
    for (ToDoItem item : items) {
      if (id == item.getId()) {
        items.remove(item);
        break;
      }
    }
  }

  public ToDoItem getItem(long id){
    for (ToDoItem item:items) {
      if (item.getId()==id){
        return item;
      }
    }
    return null;
  }

  public void editItem(ToDoItem itemToEdit){
    ListIterator<ToDoItem> iterator = items.listIterator();
    while (iterator.hasNext()){
      ToDoItem item = iterator.next();
      if (item.equals(itemToEdit)){
        iterator.set(itemToEdit);
      }
    }
  }
}
