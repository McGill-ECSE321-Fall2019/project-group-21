package ca.mcgill.ecse321.tutoringcompany.dao;


	import org.springframework.data.repository.CrudRepository;
	import org.springframework.data.repository.query.Param;

	import org.springframework.web.bind.annotation.CrossOrigin;

import ca.mcgill.ecse321.tutoringcompany.model.Product;


	@CrossOrigin(origins = "*")
	public interface ProductRepository extends CrudRepository<Product, String> {
	  Product findById(@Param(value = "id") int Id);
	
	 
	  Product save(Product product);
	}

