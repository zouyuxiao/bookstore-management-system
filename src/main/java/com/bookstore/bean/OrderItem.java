package com.bookstore.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by heanxing on 2018/9/25.
 */
@JsonIgnoreProperties(value = {"handler"})
public class OrderItem {
    private Long id;
    private Long order_id;
    private Long product_id;
    private Long user_id;
    private int number;
    private Long total;
    private Product product;//明细对应的产品信息

    public OrderItem() {
    }

    public OrderItem(Long id, Long order_id, Long product_id, Long user_id, int number, Long total, Product product) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.number = number;
        this.total = total;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}



