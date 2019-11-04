package udemy.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
public class WebAppInit implements WebApplicationInitializer {

  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    log.info("onStartup");

    //create spring annotation context
    AnnotationConfigWebApplicationContext context =
        new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);

    //create DispatcherServlet
    DispatcherServlet dispatcherServlet =
        new DispatcherServlet(context);

    //register and configure dispatcher servlet
    ServletRegistration.Dynamic registration =
        servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

    registration.setLoadOnStartup(1);
    registration.addMapping("/");
  }
}
