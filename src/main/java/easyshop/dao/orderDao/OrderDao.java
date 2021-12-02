package easyshop.dao.orderDao;

import easyshop.data.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {

    public List<Order> getOrders();
    public List<Order> getOrdersByCustomerId(Long customerId);

}
