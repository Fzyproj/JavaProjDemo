package com.lucfzy;

public class OrderInvoice {
    private String orderId;

    public OrderInvoice() {
    }

    public OrderInvoice(String orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceAddress() {
        return orderId;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.orderId = invoiceAddress;
    }

    @Override
    public String toString() {
        return "OrderInvoice{" +
                "invoiceAddress='" + orderId + '\'' +
                '}';
    }
}