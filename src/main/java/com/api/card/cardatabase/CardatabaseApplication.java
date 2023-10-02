package com.api.card.cardatabase;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.card.cardatabase.domain.Car;
import com.api.card.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application Started");
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Car 1
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023,59000));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2022,29000));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "ADF-1121", 2020,39000));
		
		for (Car car: carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
	}

}
