package com.microservice.order.constants;

public class ServiceConstants {
    private ServiceConstants() {
    }
    public static final String STATUS = "status";
    public static final String MESSAGE = "message";
    public static final String ID = "id";
    public static final String TRUE = "true";
    public static final String INSUFFICIENT_QUANTITY = "Insufficient Quantity for itemId : %s";
    public static final String ITEM_NOT_FOUND = "Item Not Found for itemID : %s";
    public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String INVENTORY_SERVICE = "INVENTORY-SERVICE";
    public static final String DELIVERY_SERVICE = "DELIVERY-SERVICE";
    public static final String ORDER_NOT_FOUND = "Order Details Not Found for orderId : %s";
    public static final String ORDER_NOT_FOUND2 = "Order Details Not Found for orderId : %s | Can't update the address";

}
