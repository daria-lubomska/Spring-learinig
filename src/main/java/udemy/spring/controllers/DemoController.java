package udemy.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import udemy.spring.service.DemoService;

@Slf4j
@Controller
public class DemoController {

  private final DemoService demoService;

  @Autowired
  public DemoController(DemoService demoService){
    this.demoService = demoService;
  }

  @ResponseBody
  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

  //ViewResolver prepare path : prefix + welcome (line 19) + suffix = /WEB-INF/view/welcome.jsp
  @GetMapping("welcome")
  public String welcome(@RequestParam String user, @RequestParam int age, Model model){
    model.addAttribute("helloMessage", demoService.getHelloMessage(user));
    model.addAttribute("ageParam", "Age parameter: " + age);
    log.info("model {}", model);
    return "welcome";
  }

  @ModelAttribute("welcomeMessage")
  public String welcomeMessage(){
    return demoService.getWelcomeMessage();
  }

}
