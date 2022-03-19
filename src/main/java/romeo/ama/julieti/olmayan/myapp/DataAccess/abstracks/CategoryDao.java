package romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

	List<Category> findByCategoryName(String categoryName);
	

}
