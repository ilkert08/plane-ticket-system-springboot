package com.internship.firstbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//TODO: Flight oluştururken uçak kapasite bilgisi alınıp o büyüklükte liste oluşturulacak!



@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class FirstbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbackendApplication.class, args);
	}
}
