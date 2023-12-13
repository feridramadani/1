package org.example.domain;
import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;
import java.util.Date;

public class Order {
    private String id;
    @SerializedName("order_number")
    private String orderNumber;
    private double total_charges;
    private status status;
    private Date updated_at;
    private Date created_at;

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

    public double getTotal_charges() {
        return total_charges;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(Order.status status) {
        this.status = status;
    }

    public void setTotal_charges(double total_charges) {
        this.total_charges = total_charges;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public enum status {
        APPROVED,
        CANCELLED,
        PENDING
    }

    public Order(ResultSet rs) throws Exception {
        this.id = rs.getString("id");
        this.orderNumber = rs.getString("order_number");
        this.total_charges = rs.getDouble("total_charges");
        this.status = status.valueOf(rs.getString("status"));
    }
}
