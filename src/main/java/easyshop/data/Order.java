package easyshop.data;

import javax.persistence.*;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer product_cost;

    public Integer getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Integer product_cost) {
        this.product_cost = product_cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order() {
    }

    public Order(Long id, Customer customer, Product product, Integer product_cost) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.product_cost = product_cost;
    }

    public Order(Customer customer, Product product, Integer product_cost) {
        this.customer = customer;
        this.product = product;
        this.product_cost = product_cost;
    }

    @Override
    public String toString() {
        return String.format("{Order: id = %d, Customer = %s, Product = %s, productCost = %d}", id, customer.getName(), product.getTitle(), product_cost);
    }
}
