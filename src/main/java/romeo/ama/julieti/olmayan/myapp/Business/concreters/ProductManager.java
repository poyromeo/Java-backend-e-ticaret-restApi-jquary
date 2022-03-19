package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.ProductService;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessResult;
import romeo.ama.julieti.olmayan.myapp.DataAccess.abstracks.ProductDao;
import romeo.ama.julieti.olmayan.myapp.Entities.concreters.Product;

@Service
public class ProductManager implements ProductService {

	//interface - constructor
	private ProductDao productDao;
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	
	@Override
	public Result addProduct(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi.");
	}
	
	@Override
	public Result deleteProduct(long productID) {
		this.productDao.deleteById(productID);;
		return new SuccessResult("Ürün Silindi.");
	}
	
	@Override
	public DataResult<List<Product>> getAllProduct() {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> getAllProductSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Data Z-A Doğru Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> getAllproduct(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent(),"Data Sayfa Numarasına Göre Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> findByProductName(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findByProductName(productName),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> findByProductNameAndCategoryID(String productName, long categoryID) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findByProductNameAndCategoryID(productName, categoryID),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> findByProductNameOrCategoryID(String productName, long categoryID) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findByProductNameOrCategoryID(productName, categoryID),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> findByCategoryIDIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findByCategoryIDIn(categories),"Data Listelendi.");
	}
	
	@Override
	public DataResult<List<Product>> findByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.findByProductNameContains(productName),"Data Listelendi.");
	}
	
}
