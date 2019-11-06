package udemy.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import udemy.spring.entity.ToDo;
import udemy.spring.service.ToDosService;
import udemy.spring.util.Mappings;
import udemy.spring.util.ViewNames;

@Slf4j
@Controller
@RequestMapping("/todos")
public class ToDosController {

  private final ToDosService service;

  @Autowired
  public ToDosController(ToDosService service){
    this.service = service;
  }

  @GetMapping(Mappings.TODO_ITEMS)
  public String getToDos(Model model){
    model.addAttribute("todos", service.getToDoItems());
    return ViewNames.TODO_LIST;
  }

  @GetMapping
  public String getToDo(@RequestParam("todoId") long id, Model model){
    model.addAttribute("todo", service.getToDoItem(id));
    return ViewNames.TODO;
  }

  @GetMapping(Mappings.ADD_TODO_FORM)
  public String getAddForm(Model model){
    ToDo toDo = new ToDo();
    model.addAttribute("newToDo", toDo);
    return ViewNames.ADD_FORM;
  }

  @GetMapping(Mappings.UPDATE_TODO_FORM)
  public String getUpdateForm(@RequestParam("todoId") long id, Model model){
    model.addAttribute("toDoToUpdate", service.getToDoItem(id));
    return ViewNames.UPDATE_FORM;
  }

  @PostMapping("save")
  public String saveToDo(ToDo toDo){
    service.addToDoItem(toDo);
    return ViewNames.REDIRECT;
  }

  @PostMapping("delete")
  public String deleteToDo(@RequestParam("todoId") long id){
    service.deleteToDoItem(id);
    return ViewNames.REDIRECT;
  }
}
