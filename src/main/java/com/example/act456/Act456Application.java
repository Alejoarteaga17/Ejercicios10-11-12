package com.example.act456;

import com.example.act456.Controllers.HelloConreoller;
import com.example.act456.Entity.Laptop;
import com.example.act456.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Act456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Act456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

	HelloConreoller helloConreoller = new HelloConreoller();
	helloConreoller.hola();

		Laptop laptop1 = new Laptop(null, "Apple", 4,5432.4);
		Laptop laptop2 = new Laptop(null, "Hp", 10,6434.23);
		Laptop laptop3 = new Laptop(null, "Lenovo", 6,5892.4);
		Laptop laptop4 = new Laptop(null, "Asus", 6,5432.4);
		repository.save(laptop1);
		repository.save(laptop3);
		repository.save(laptop2);
		repository.save(laptop4);



	}

}
