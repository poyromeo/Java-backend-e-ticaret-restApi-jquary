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

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.ProductService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Product;

@RestController
@RequestMapping(value="/api/products")
public class ProductController {
	
	//interface - constructor
	private ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/addProduct")
	public Result addProduct(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}
	
	@DeleteMapping(value="/productID")
	public Result deleteProduct(@PathVariable long productID) {
		return this.productService.deleteProduct(productID);
	}
	
	@GetMapping("/getAllProduct")
	public DataResult<List<Product>> getAllProduct() {
		return this.productService.getAllProduct();
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllProductSorted() {
		return this.productService.getAllProductSorted();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAllproduct(int pageNo, int pageSize) {
		return this.productService.getAllproduct(pageNo, pageSize);
	}
	
	@GetMapping("/findByProductName")
	public DataResult<List<Product>> findByProductName(@RequestParam String productName) {
		return this.productService.findByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<List<Product>> findByProductNameAndCategoryID(@RequestParam("productName") String productName, @RequestParam long categoryID) {
		return this.productService.findByProductNameAndCategoryID(productName, categoryID);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> findByProductNameOrCategoryID(@RequestParam("productName") String productName, @RequestParam long categoryID) {
		return this.productService.findByProductNameOrCategoryID(productName, categoryID);
	}
	
	@GetMapping("/findByCategoryIDIn")
	public DataResult<List<Product>> findByCategoryIDIn(List<Integer> categories) {
		return this.productService.findByCategoryIDIn(categories);
	}
	
	@GetMapping("/findByProductNameContains")
	public DataResult<List<Product>> findByProductNameContains(@RequestParam String productName) {
		return this.productService.findByProductNameContains(productName);
	}
	
	
	

}
