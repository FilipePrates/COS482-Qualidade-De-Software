package com.mycompany.myapp.process.customerServiceProcess;

import com.mycompany.myapp.domain.CustomerService;
import com.mycompany.myapp.domain.CustomerServiceProcess;
import com.mycompany.myapp.service.dto.CustomerServiceDTO;
import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskRegisterExpensesMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    CustomerServiceProcessDTO toCustomerServiceProcessDTO(CustomerServiceProcess customerServiceProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "serviceDate", source = "serviceDate")
    @Mapping(target = "expenseValue", source = "expenseValue")
    @Mapping(target = "expenseDescription", source = "expenseDescription")
    CustomerServiceDTO toCustomerServiceDTO(CustomerService customerService);
}
