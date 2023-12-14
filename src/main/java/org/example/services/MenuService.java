package org.example.services;

import org.example.database.*;
import org.example.domain.Menu;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuService {

    public Menu getMenu(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(MenuSQL.GET_MENU_BY_ID);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return new Menu(rs);
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return null;
    }

    public boolean createMenu(Menu menu) throws Exception {
        menu.setId(UUID.randomUUID().toString());
        boolean isCreated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(MenuSQL.CREATE_MENU);
            statement.setString(1, menu.getId());
            statement.setString(2, menu.getName());
            statement.setInt(3,menu.getStartTime());
            statement.setInt(4, menu.getEndTime());
            isCreated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean deleteMenu(String id) throws Exception {
        boolean isCreated;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(MenuSQL.DELETE_MENU);
            statement.setString(1, id);
            isCreated = statement.executeUpdate() == 1;

        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean updateMenu(Menu menu) throws Exception {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(MenuSQL.UPDATE_MENUS);
            statement.setString(1, menu.getId());
            statement.setString(2, menu.getName());
            statement.setInt(3, menu.getStartTime());
            statement.setInt(4, menu.getEndTime());
            isUpdated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isUpdated;
    }

    public List<Menu> getAllMenus() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(MenuSQL.GET_ALL_MENUS);
            rs = statement.executeQuery();
            List<Menu> menus = new ArrayList<>();
            while (rs.next()){
                menus.add(new Menu(rs));
            }
            statement.close();
            conn.close();
            return menus;
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
