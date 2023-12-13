package org.example.database;

public class Select {
    public static final String GET_PRODUCT_BY_ID =
            "select * from products where id=?;";
    public static final String GET_ALL_PRODUCTS =
            "select * from products;";
    public static final String GET_ORDER_BY_ID =
            "select * from orders where id=?;";
    public static final String GET_ALL_ORDERS =
            "select * from orders;";
    public static final String GET_ORDER_ITEM =
            "select * from order_items where id=?;";
    public static final String GET_ALL_ORDER_ITEMS =
            "select * from order_items;";
    public static final String GET_PAYMENT =
            "select * from payments where id=?;";
    public static final String GET_ALL_PAYMENTS =
            "select * from payments;";
}
