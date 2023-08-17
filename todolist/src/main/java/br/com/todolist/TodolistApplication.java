package br.com.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner criarTarefaFake(TodoRepository todoRepository){
		return  args -> {
			todoRepository.deleteAll();

			Todo todo1 = new Todo("Configurar 30K",
					"Preciso aprender a configurar e jdk corretamente",
			        StatusEnum.NOT_STARTED);
			Todo todo2 = new Todo("Estudar Java",
					"Estudar java aprender e dificil",
					StatusEnum.IN_PROGRESS);
			Todo todo3 = new Todo("Estudar html",
					"Estudar html para desenvolver sites",
					StatusEnum.FINISHED);

			todoRepository.save(todo1);
			todoRepository.save(todo2);
			todoRepository.save(todo3);
		};
	}

}
