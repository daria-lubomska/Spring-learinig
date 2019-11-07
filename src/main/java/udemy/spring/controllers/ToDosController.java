package udemy.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import udemy.spring.entity.ToDo;
import udemy.spring.service.ToDosService;
import udemy.spring.util.AttributeNames;
import udemy.spring.util.Mappings;
import udemy.spring.util.ViewNames;

@Slf4j
@Controller
public class ToDosController {

  private final ToDosService service;

  @Autowired
  public ToDosController(ToDosService service){
    this.service = service;
  }

  @GetMapping(Mappings.TODO_ITEMS)
  public String getToDos(Model model){
    model.addAttribute(AttributeNames.TODOS, service.getToDoItems());
    return ViewNames.TODO_LIST;
  }

  @GetMapping(Mappings.VIEW_TODO)
  public String getToDo(@RequestParam(AttributeNames.TODO_ID) long id, Model model){
    model.addAttribute(AttributeNames.TODO, service.getToDoItem(id));
    return ViewNames.TODO;
  }

  @GetMapping(Mappings.ADD_TODO_FORM)
  public String getAddForm(Model model){
    ToDo toDo = new ToDo();
    model.addAttribute(AttributeNames.TODO_TO_PROCESS, toDo);
    return ViewNames.ADD_FORM;
  }

  @GetMapping(Mappings.UPDATE_TODO_FORM)
  public String getUpdateForm(@RequestParam(value = AttributeNames.TODO_ID,
      required = false, defaultValue = "-1") long id, Model model) {
    ToDo toDo = service.getToDoItem(id);
    if (toDo==null){
      toDo = new ToDo();
    }
    model.addAttribute(AttributeNames.TODO_TO_PROCESS, toDo);
    service.addToDoItem(toDo);
    return ViewNames.ADD_FORM;
  }

  @PostMapping("save")
  public String saveToDo(@ModelAttribute(AttributeNames.TODO_NEW) ToDo toDo) {
    service.addToDoItem(toDo);
    log.info("TODO item {} was added or updated successfully", toDo);
    return "redirect:/" + Mappings.TODO_ITEMS;
  }

  @GetMapping("delete")
  public String deleteToDo(@RequestParam(AttributeNames.TODO_ID) long id) {
    service.deleteToDoItem(id);
    log.info("TODO item with id {} was deleted successfully", id);
    return "redirect:/" + Mappings.TODO_ITEMS;
  }
}
