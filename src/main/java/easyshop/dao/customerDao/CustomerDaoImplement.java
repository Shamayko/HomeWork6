package easyshop.dao.customerDao;


import easyshop.data.Customer;
import easyshop.data.Order;
import easyshop.data.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import easyshop.utils.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImplement implements easyshop.dao.customerDao.CustomerDao {

    private SessionFactoryUtils factoryUtils;

    @Autowired
    public CustomerDaoImplement(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    @Override
    public void addNewCustomer(String name) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(new Customer(name));
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Customer> getCustomers() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers =  session.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println(customers);
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public List<Customer> getAllCustomersByProductId(Long productId) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            List<Order> orders = product.getOrders();
            List<Customer> customers = new ArrayList<>();
            orders.stream().map(o -> o.getCustomer()).distinct().forEach(o -> customers.add(o));
            System.out.println(customers);
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public void doOrder(Long customerId, Long productId) {
        try (Session session = factoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            Product product = session.get(Product.class, productId);
            session.saveOrUpdate(new Order(customer, product, product.getCost()));
            session.getTransaction().commit();
        }
    }
}
