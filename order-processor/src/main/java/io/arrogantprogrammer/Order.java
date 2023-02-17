package io.arrogantprogrammer;

public class Order {

    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                '}';
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
