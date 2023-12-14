package org.example.domain;
import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;
import java.util.Date;

public class Payment {

    @SerializedName("id")
    private String id;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("amount")
    private double amount;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(Payment.status status) {
        this.status = status;
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

    public Payment(ResultSet rs) throws Exception {
        this.id = rs.getString("id");
        this.orderId = rs.getString("order_id");
        this.amount = rs.getDouble("amount");
        this.status = status.valueOf(rs.getString("status"));
    }
}
