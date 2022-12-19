package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CustomerService.
 */
@Entity
@Table(name = "customer_service")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CustomerService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "service_date")
    private LocalDate serviceDate;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "customer_satisfaction")
    private Boolean customerSatisfaction;

    @Column(name = "is_there_extra_expenses")
    private Boolean isThereExtraExpenses;

    @Column(name = "order_description")
    private String orderDescription;

    @Column(name = "payment_value")
    private Double paymentValue;

    @Column(name = "payment_description")
    private String paymentDescription;

    @Column(name = "expense_value")
    private Double expenseValue;

    @Column(name = "expense_description")
    private String expenseDescription;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerService id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public CustomerService name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getServiceDate() {
        return this.serviceDate;
    }

    public CustomerService serviceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public CustomerService customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public CustomerService employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Boolean getCustomerSatisfaction() {
        return this.customerSatisfaction;
    }

    public CustomerService customerSatisfaction(Boolean customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
        return this;
    }

    public void setCustomerSatisfaction(Boolean customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }

    public Boolean getIsThereExtraExpenses() {
        return this.isThereExtraExpenses;
    }

    public CustomerService isThereExtraExpenses(Boolean isThereExtraExpenses) {
        this.isThereExtraExpenses = isThereExtraExpenses;
        return this;
    }

    public void setIsThereExtraExpenses(Boolean isThereExtraExpenses) {
        this.isThereExtraExpenses = isThereExtraExpenses;
    }

    public String getOrderDescription() {
        return this.orderDescription;
    }

    public CustomerService orderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
        return this;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Double getPaymentValue() {
        return this.paymentValue;
    }

    public CustomerService paymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
        return this;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public String getPaymentDescription() {
        return this.paymentDescription;
    }

    public CustomerService paymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
        return this;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public Double getExpenseValue() {
        return this.expenseValue;
    }

    public CustomerService expenseValue(Double expenseValue) {
        this.expenseValue = expenseValue;
        return this;
    }

    public void setExpenseValue(Double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public String getExpenseDescription() {
        return this.expenseDescription;
    }

    public CustomerService expenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
        return this;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerService)) {
            return false;
        }
        return id != null && id.equals(((CustomerService) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerService{" +
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
