package udemy.spring.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
@Entity
@Table(name="todo_item")
public class ToDo {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id")
  private long id;

  @Column(name="title")
  private String title;

  @Column(name="details")
  private String details;

  @Column(name="deadline")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime deadline;

  public ToDo(){
  }
}
