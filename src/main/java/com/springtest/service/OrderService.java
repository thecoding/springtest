package com.springtest.service;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年02月08日 14:24:00
 */
public class OrderService implements MyOrderService{

    @Override
    public String queryOrder(String orderId) {
        return "order query";
    }


}
