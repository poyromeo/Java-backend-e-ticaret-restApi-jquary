package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import java.util.List;

import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Product;

public interface ProductService {
	
	Result addProduct(Product product);
	Result deleteProduct(long productID);
	DataResult<List<Product>> getAllProduct();
	DataResult<List<Product>> getAllProductSorted();
	DataResult<List<Product>> getAllproduct(int pageNo, int pageSize);
	
	DataResult<List<Product>> findByProductName(String productName);
	DataResult<List<Product>> findByProductNameAndCategoryID(String productName, long categoryID);
	DataResult<List<Product>> findByProductNameOrCategoryID(String productName, long categoryID);
	DataResult<List<Product>> findByCategoryIDIn(List<Integer> categories);
	DataResult<List<Product>> findByProductNameContains(String productName);
	

}
