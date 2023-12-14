package org.example.database;

public class PaymentSQL {
    public static final String CREATE_PAYMENT =
            "insert into payments(id,order_id,charge_amount,status) values(? ? ? ?);";
    public static final String DELETE_PAYMENT =
            "delete from payments where id=?;";
    public static final String GET_PAYMENT =
            "select * from payments where id=?;";
    public static final String GET_ALL_PAYMENTS =
            "select * from payments;";
    public static final String UPDATE_PAYMENT =
            "update payments set order_id=?,amount=?,status=?,updated_at=now() where id=?;";

}
