package org.example.database;

public class MenuSQL {

    public static final String CREATE_MENU =
            "insert into menus(id,name,start_time,end_time) values(?,?,?,?);";
    public static final String DELETE_MENU =
            "delete from menus where id=?;";
    public static final String GET_MENU_BY_ID =
            "select * from menus where id=?;";
    public static final String GET_ALL_MENUS =
            "select * from menus;";
    public static final String UPDATE_MENUS =
            "update menus set name=?,start_time=?,end_time=?,updated_at=now() where id=?";

}
