package me.yummykang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WorkkitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkkitsApplication.class, args);
	}
}
