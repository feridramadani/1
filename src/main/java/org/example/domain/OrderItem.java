package org.example.domain;
import java.sql.ResultSet;
import java.util.Date;

public class OrderItem {
    private String id;
    private String product_id;
    private String order_id;
    private double charge_amount;
    private status status;
    private Date updated_at;
    private Date created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public double getCharge_amount() {
        return charge_amount;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(OrderItem.status status) {
        this.status = status;
    }

    public void setCharge_amount(double charge_amount) {
        this.charge_amount = charge_amount;
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

    public OrderItem(ResultSet rs) throws Exception {
        this.id = rs.getString("id");
        this.product_id = rs.getString("product_id");
        this.order_id = rs.getString("order_id");
        this.charge_amount = rs.getDouble("charge_amount");
        this.status = status.valueOf(rs.getString("status"));
    }
}
