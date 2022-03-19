package romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findByProductName(String productName);
	
	@Query("From Product where productName=:productName and category.categoryID=:categoryID")
	List<Product> findByProductNameAndCategoryID(String productName, long categoryID);
	
	@Query("From Product where productName=:productName or category.categoryID=:categoryID")
	List<Product> findByProductNameOrCategoryID(String productName, long categoryID);

	List<Product> findByCategoryIDIn(List<Integer> categories);

	List<Product> findByProductNameContains(String productName);
	
	
	
	

}
