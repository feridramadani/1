package org.example.database;

public class Insert {
    public static final String CREATE_PRODUCT =
            "insert into products(id,name,base_price,active) values(?,?,?,?);";

    public static final String CREATE_ORDER =
            "insert into orders(id,order_number,total_charges,status) values(?,?,?,?);";

    public static final String ADD_ORDER_ITEM =
            "insert into order_items(id,product_id,order_id,charge_amount,status) values(? ? ? ? ?);";

    public static final String CREATE_PAYMENT =
            "insert into payments(id,order_id,charge_amount,status) values(? ? ? ?);";
}
