package easyshop.dao.productDao;

import easyshop.data.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {

    public List<Product> getAllProducts();
    public List<Product> getProductsByCustomerId(Long customerID);
    public void changeCostOfProduct(Long productId, Integer newCost);

}
