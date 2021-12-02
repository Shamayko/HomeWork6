package easyshop.services;

import easyshop.data.Order;
import easyshop.dao.orderDao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderDao.getOrdersByCustomerId(customerId);
    }


}
