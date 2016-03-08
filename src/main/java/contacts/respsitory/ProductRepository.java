package contacts.respsitory;

import org.springframework.cache.annotation.Cacheable;

import contacts.entity.Product;

public interface ProductRepository {
	
	Long getProductStorageCountByType(String productType);
	
	void updateProduct(Product product);
	
	@Cacheable(value = "productcache")
	Product getProductById(Long id);
}
