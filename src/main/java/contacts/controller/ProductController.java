package contacts.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import contacts.entity.Product;
import contacts.respsitory.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	

	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String product(Map<String,Object> model) throws Exception {
		// ≤È—Ø
		Long id = 1L;
		Product product = productRepo.getProductById(id);
		model.put("products", product);

		return "product";
	}
	
	
}
