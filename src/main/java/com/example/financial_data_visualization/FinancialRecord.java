package com.example.financial_data_visualization;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "financial_records")

public class FinancialRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int year;
    private String month;
    private double amount;

    public FinancialRecord(Long recordId, Integer year, String month, Double amount){
        this.recordId = recordId;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public FinancialRecord(){

    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
