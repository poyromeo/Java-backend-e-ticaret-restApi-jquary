package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import java.util.List;

import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Category;

public interface CategoryService {
	
	Result addCategory(Category category);
	Result deleteCategory(long categoryID);
	
	DataResult<List<Category>> gettAllCategory();
	DataResult<List<Category>> findByCategoryName(String categoryName);
	
	

}
