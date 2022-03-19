package romeo.ama.julieti.olmayan.myapp.Api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.CategoryService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Category;

@RestController
@RequestMapping(value="/Api/categories")
public class CategoryController {
	
	//interface - constructor
	private CategoryService categoryService;
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/addCategory")
	public Result addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}
	
	@DeleteMapping(value="/categoryID")
	public Result deleteCategory(@PathVariable long categoryID) {
		return this.categoryService.deleteCategory(categoryID);
	}
	
	@GetMapping("/getAllCategory")
	public DataResult<List<Category>> gettAllCategory() {
		return this.categoryService.gettAllCategory();
	}
	
	@GetMapping("/findByCategoryName")
	public DataResult<List<Category>> findByCategoryName(@RequestParam String categoryName) {
		return this.categoryService.findByCategoryName(categoryName);
	}
	
	
	
	
	
	
	
	
	
	
	

}
