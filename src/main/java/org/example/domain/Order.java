package org.example.domain;

import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    @SerializedName("id")
    private String id;

    @SerializedName("order_number")
    private String orderNumber;

    @SerializedName("total_charges")
    private Double totalCharges;

    @SerializedName("status")
    private status status;

    @SerializedName("guest_name")
    private String guestName;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("order_items")
    private List<OrderItem> orderItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(Order.status status) {
        this.status = status;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


//    public Order(ResultSet rs) throws Exception {
//        this.id = rs.getString("id");
//        this.orderNumber = rs.getString("order_number");
//        this.totalCharges = rs.getDouble("total_charges");
//        this.status = status.valueOf(rs.getString("status"));
//    }


    public Order() {

    }

    public Order(String guestName, List<OrderItem> orderItems) {
        this.guestName = guestName;
        this.orderItems = new ArrayList<>();
    }

    public Order(ResultSet rs) throws Exception {
        this.guestName = rs.getString("guest_name");
//        this.id = rs.getString("id");
//        this.orderNumber = rs.getString("order_number");
//        this.totalCharges = rs.getDouble("total_charges");
//        this.status = status.valueOf(rs.getString("status"));
        this.orderItems = new ArrayList<>();
    }
}