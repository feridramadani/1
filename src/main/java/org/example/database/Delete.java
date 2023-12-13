package org.example.database;

public class Delete {
    public static final String DELETE_PRODUCT =
            "delete from products where id=?;";
    public static final String DELETE_ORDER =
            "delete from products where id=?;";

    public static final String DELETE_PAYMENT =
            "delete from payments where id=?;";

    public static final String DELETE_ORDER_ITEM =
            "delete from order_items where id=?;";

}