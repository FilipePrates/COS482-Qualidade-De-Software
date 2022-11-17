package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CustomerService} entity.
 */
public class CustomerServiceDTO implements Serializable {

    private Long id;

    private String startDate;

    private String endDate;

    private String customerName;

    private String employeeName;

    private Integer customerSatisfaction;

    private String orderDescription;

    private Double paymentValue;

    private String paymentDescription;

    private Double expenseValue;

    private String expenseDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(Integer customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public Double getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(Double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerServiceDTO)) {
            return false;
        }

        CustomerServiceDTO customerServiceDTO = (CustomerServiceDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, customerServiceDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerServiceDTO{" +
            "id=" + getId() +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            ", customerSatisfaction=" + getCustomerSatisfaction() +
            ", orderDescription='" + getOrderDescription() + "'" +
            ", paymentValue=" + getPaymentValue() +
            ", paymentDescription='" + getPaymentDescription() + "'" +
            ", expenseValue=" + getExpenseValue() +
            ", expenseDescription='" + getExpenseDescription() + "'" +
            "}";
    }
}
