package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CustomerServiceProcess} entity.
 */
public class CustomerServiceProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private CustomerServiceDTO customerService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public CustomerServiceDTO getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerServiceDTO customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerServiceProcessDTO)) {
            return false;
        }

        CustomerServiceProcessDTO customerServiceProcessDTO = (CustomerServiceProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, customerServiceProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerServiceProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", customerService=" + getCustomerService() +
            "}";
    }
}
