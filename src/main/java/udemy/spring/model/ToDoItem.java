package udemy.spring.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class ToDoItem {

  private long id;
  private String title;
  private String details;
  private LocalDateTime deadline;

  public ToDoItem(long id, String title, String details, LocalDateTime deadline) {
    this.id = id;
    this.title = title;
    this.details = details;
    this.deadline = deadline;
  }
}
