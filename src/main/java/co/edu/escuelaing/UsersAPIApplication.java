package co.edu.escuelaing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "co.edu.escuelaing" })
@SpringBootApplication
public class UsersAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersAPIApplication.class, args);
    }

}
