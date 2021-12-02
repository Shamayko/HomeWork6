package easyshop.dao.productDao;

import easyshop.data.Customer;
import easyshop.data.Order;
import easyshop.data.Product;
import easyshop.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoImplement implements easyshop.dao.productDao.ProductDao {

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public ProductDaoImplement(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public List<Product> getAllProducts() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Product> getProductsByCustomerId(Long customerId) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            List<Order> orders = customer.getOrders();
            List<Product> products = new ArrayList<>();
            orders.stream().map(o -> o.getProduct()).distinct().forEach(o -> products.add(o));
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void changeCostOfProduct(Long productId, Integer newCost) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            product.setCost(newCost);
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }


}
