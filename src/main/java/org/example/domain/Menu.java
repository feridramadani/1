package org.example.domain;

import com.google.gson.annotations.SerializedName;

import java.sql.ResultSet;
import java.util.Date;

public class Menu {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("start_time")
    private int startTime;

    @SerializedName("end_time")
    private int endTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
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

    public Menu(ResultSet rs) throws Exception {
        this.id = rs.getString("id");
        this.name = rs.getString("name");
        this.startTime = rs.getInt("start_time");
        this.endTime = rs.getInt("end_time");
    }
}