package org.example.database;

public class Update {
    public static final String UPDATE_PRODUCT =
            "update products set name=?,base_price=?,active=?,updated_at=now() where id=?;";

    public static final String UPDATE_ORDER =
            "update orders set order_number=?,total_charges=?,status=?,updated_at=now() where id=?";

    public static final String UPDATE_PAYMENT =
            "update payments set order_id=?,amount=?,status=?,updated_at=now() where id=?;";

    public static final String UPDATE_ORDER_ITEM =
            "update order_items set product_id=?,order_id=?,charge_amount=?,status=?,updated_at=now() where id=?;";
}
