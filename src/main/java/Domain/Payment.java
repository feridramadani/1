package Domain;
import java.util.Date;

public class Payment {
    private String id;
    private String order_id;
    private double amount;
    private status status;

    private Date updated_at;
    private Date created_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment.status getStatus() {
        return status;
    }

    public void setStatus(Payment.status status) {
        this.status = status;
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
