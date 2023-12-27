package org.example.database;

public class OrderSQL {

    public static final String CREATE_ORDER =
            "insert into orders(id,order_number," +
                    "total_charges,status,guest_name) values(?,?,?,?,?);";
    public static final String ORDER_PAYLOAD =
            "";
    public static final String DELETE_ORDER =
            "delete from products where id=?;";
    public static final String GET_ORDER_BY_ID =
            "select o.*, oi.* from orders o inner join order_items oi on o.id = oi.order_id " +
                    "where o.id = ?;";
//    public static final String GET_ORDER_BY_ID =
//            "select * from orders where id=?";
    public static final String GET_ALL_ORDERS =
            "select * from orders;";
    public static final String UPDATE_ORDER =
            "update orders set order_number=?,total_charges=?,status=?,updated_at=now() where id=?";
    public static final String ADD_ORDER_ITEM =
            "insert into order_items(id,product_id,order_id,charge_amount,status,quantity) values(?, ?, ?, ?, ?, ?);";
    public static final String GET_ORDER_ITEM =
            "select * from order_items where id=?;";
    public static final String GET_ALL_ORDER_ITEMS =
            "select * from order_items;";
    public static final String DELETE_ORDER_ITEM =
            "delete from order_items where id=?;";
    public static final String UPDATE_ORDER_ITEM =
            "update order_items set product_id=?,order_id=?,charge_amount=?,status=?,updated_at=now() where id=?;";

}