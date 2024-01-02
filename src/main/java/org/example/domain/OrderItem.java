package org.example.domain;

import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;
import java.util.Date;

public class OrderItem {

    @SerializedName("id")
    private String id;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("charge_amount")
    private Double chargeAmount;

    @SerializedName("status")
    private status status;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("menu_id")
    private String menuId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(OrderItem.status status) {
        this.status = status;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum status {
        APPROVED,
        CANCELLED,
        PENDING
    }

    public OrderItem() {

    }

    public OrderItem(ResultSet rs, String alias) throws Exception {
        this.id = rs.getString(alias + "id");
        this.productId = rs.getString(alias + "product_id");
        this.orderId = rs.getString(alias + "order_id");
        this.chargeAmount = rs.getDouble(alias + "charge_amount");
        this.status = status.valueOf(rs.getString(alias + "status"));
        this.quantity = rs.getInt(alias + "quantity");
    }
}
