package org.example.database;

public class ProductSQL {

    public static final String CREATE_PRODUCT =
            "insert into products(id,name,base_price,active,menu_id) values(?,?,?,?);";
    public static final String DELETE_PRODUCT =
            "delete from products where id=?;";
    public static final String GET_PRODUCT_BY_ID =
            "select * from products where id=?;";
    public static final String GET_ALL_PRODUCTS =
            "select * from products;";
    public static final String UPDATE_PRODUCT =
            "update products set name=?,base_price=?,active=?,menu_id=?,updated_at=now() where id=?;";


}
