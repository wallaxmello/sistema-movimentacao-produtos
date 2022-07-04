package br.com.springboot.sistema.movimentacao.produtos

-movimentacao-produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"br.com.*"})
@RestController
@EnableWebMvc
public class Application implements WebMvcConfigurer{
	
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}