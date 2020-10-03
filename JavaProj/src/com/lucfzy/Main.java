package com.lucfzy;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.InvocationTargetException;

public class Main {

//    private static final OrderHeader orderHeader = new OrderHeader();

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // write your code here
        OrderHeader orderHeader1 = new OrderHeader("123456");
//        OrderHeader orderHeader = new OrderHeader();
        OrderInvoice orderInvoice = new OrderInvoice();
//        BeanUtils.copyProperties(orderInvoice,orderHeader1);
        System.out.println(orderInvoice);

//        OrderHeader orderHeader2 = new OrderHeader("12345677777", null);
//        orderHeader1.setOrderId("12345677777");
//        OrderHeader orderHeader2 = new OrderHeader("1234543414fdasfa6", new OrderInvoice("保利"));
//        BeanUtils.copyProperties(orderHeader,orderHeader2);
//        System.out.println(orderHeader);
//        System.out.println(OrderHeader.getCopyOnOrderId());
//        System.out.println(OrderHeader.getCopyOnOrderId());
//        System.out.println(OrderHeader.getCopyOnOrderId());
//        System.out.println(OrderHeader.getCopyOnOrderId());
    }
}
