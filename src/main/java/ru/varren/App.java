package ru.varren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by varren on 01.09.17.
 */
@SpringBootApplication
@EnableWebMvc
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}
