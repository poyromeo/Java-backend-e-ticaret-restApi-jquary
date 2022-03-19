package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.CategoryService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessResult;
import romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks.CategoryDao;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Category;

@Service
public class CategoryManager implements CategoryService{
	
	//interface - constructor
	private CategoryDao categoryDao;
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}
	
	@Override
	public Result addCategory(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult("Data Listelendi.");
	}
	
	@Override
	public Result deleteCategory(long categoryID) {
		this.categoryDao.deleteById(categoryID);;
		return new SuccessResult("Data Silindi.");
	}
	
	@Override
	public DataResult<List<Category>> gettAllCategory() {
		return new SuccessDataResult<List<Category>>
		(this.categoryDao.findAll(),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Category>> findByCategoryName(String categoryName) {
		return new SuccessDataResult<List<Category>>
		(this.categoryDao.findByCategoryName(categoryName),"Data Listelendi.");
	}
	

}
