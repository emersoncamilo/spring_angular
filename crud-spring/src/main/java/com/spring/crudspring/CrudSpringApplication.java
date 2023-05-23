package com.spring.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.crudspring.model.Course;
import com.spring.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c1 = new Course();
			c1.setName("Angular");
			c1.setCategory("front-end");

			Course c2 = new Course();
			c2.setName("Spring Boot");
			c2.setCategory("back-end");

			Course c3 = new Course();
			c3.setName("SQL");
			c3.setCategory("back-end");

			Course c4 = new Course();
			c4.setName("JavaScript");
			c4.setCategory("front-end");

		
			courseRepository.save(c1);
			courseRepository.save(c2);
			courseRepository.save(c3);
			courseRepository.save(c4);

		};

	}
}
