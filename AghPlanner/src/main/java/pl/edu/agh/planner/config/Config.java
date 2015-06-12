package pl.edu.agh.planner.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(value = {"pl.edu.agh.planner.controllers", "pl.edu.agh.planner.dao", "pl.edu.agh.planner.dto"
                        ,"pl.edu.agh.planner.service."})
//@EnableWebMvc
@EnableAutoConfiguration
public class Config extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/pages/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/index").setViewName("index");
    }
}