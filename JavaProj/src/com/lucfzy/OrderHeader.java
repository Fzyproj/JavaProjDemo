package com.lucfzy;

public class OrderHeader {
    private String orderId;
//    private OrderInvoice orderInvoice;
//    private String copyOnOrderId;

    public OrderHeader() {
    }

    public OrderHeader(String orderId) {
        this.orderId = orderId;
//        copyOnOrderId = orderId;
//        this.orderInvoice = orderInvoice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
//        copyOnOrderId = orderId;
    }

//    public OrderInvoice getOrderInvoice() {
//        return orderInvoice;
//    }
//
//    public void setOrderInvoice(OrderInvoice orderInvoice) {
//        this.orderInvoice = orderInvoice;
//    }
//
//    public String getCopyOnOrderId() {
//        return this.copyOnOrderId;
//    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
