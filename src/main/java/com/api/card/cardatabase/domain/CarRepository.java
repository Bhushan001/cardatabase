package com.api.card.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	
	// find By Field
	// List<Car> findByBrand(String brand);
	List<Car> findByColor(String color);
	List<Car> findByManufactureYear(int manufactureYear);
	
	// find By multiple fields with And & Or
	List<Car> findByBrandAndModel(String brand, String model);
	List<Car> findByBrandOrModel(String brand, String model);
	
	// find By multiple fields with And & Or with sorting
	List<Car> findByBrandOrderByManufactureYear(String brand, int manufactureYear);
	
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(String brand);
}
