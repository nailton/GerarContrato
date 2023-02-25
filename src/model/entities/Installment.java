package model.entities;

import java.util.Date;

public class Installment {
    private Date dueDate;
    private Double amount;

    private Contract contract;

    public Installment(Date dueDate, Double amount, Contract contract) {
        this.dueDate = dueDate;
        this.amount = amount;
        this.contract = contract;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
