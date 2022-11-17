package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CustomerServiceProcess} and its DTO {@link CustomerServiceProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, CustomerServiceMapper.class })
public interface CustomerServiceProcessMapper extends EntityMapper<CustomerServiceProcessDTO, CustomerServiceProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "customerService", source = "customerService")
    CustomerServiceProcessDTO toDto(CustomerServiceProcess s);
}
