package udemy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "udemy.spring")

public class AppConfig {

  private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/view/";
  private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

  @Bean
  public ViewResolver viewResolver(){
    UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
    viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
    return viewResolver;
  }
}
