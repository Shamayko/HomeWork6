import easyshop.services.CustomerService;
import easyshop.services.OrderService;
import easyshop.services.ProductService;
import easyshop.utils.SessionFactoryUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("easyshop");
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);

        try {
            orderService.getOrders();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactoryUtils.getSession() != null) {
                sessionFactoryUtils.getSession().close();
            }
            sessionFactoryUtils.shutdown();
        }

    }
}
