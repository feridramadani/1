package Domain;
import java.util.Date;

public class Order {
    private String id;
    private String order_number;
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

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public Order.status getStatus() {
        return status;
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
}
