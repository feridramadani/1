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
    private double chargeAmount;

    @SerializedName("status")
    private status status;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("created_at")
    private Date createdAt;

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

    public enum status {
        APPROVED,
        CANCELLED,
        PENDING
    }

    public OrderItem(ResultSet rs) throws Exception {
        this.id = rs.getString("id");
        this.productId = rs.getString("product_id");
        this.orderId = rs.getString("order_id");
        this.chargeAmount = rs.getDouble("charge_amount");
        this.status = status.valueOf(rs.getString("status"));
    }
}
