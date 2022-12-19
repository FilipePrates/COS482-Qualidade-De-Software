package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CustomerService} entity.
 */
public class CustomerServiceDTO implements Serializable {

    private Long id;

    private String name;

    private LocalDate serviceDate;

    private String customerName;

    private String employeeName;

    private Boolean customerSatisfaction;

    private Boolean isThereExtraExpenses;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
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

    public Boolean getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(Boolean customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }

    public Boolean getIsThereExtraExpenses() {
        return isThereExtraExpenses;
    }

    public void setIsThereExtraExpenses(Boolean isThereExtraExpenses) {
        this.isThereExtraExpenses = isThereExtraExpenses;
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
            ", name='" + getName() + "'" +
            ", serviceDate='" + getServiceDate() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            ", customerSatisfaction='" + getCustomerSatisfaction() + "'" +
            ", isThereExtraExpenses='" + getIsThereExtraExpenses() + "'" +
            ", orderDescription='" + getOrderDescription() + "'" +
            ", paymentValue=" + getPaymentValue() +
            ", paymentDescription='" + getPaymentDescription() + "'" +
            ", expenseValue=" + getExpenseValue() +
            ", expenseDescription='" + getExpenseDescription() + "'" +
            "}";
    }
}
