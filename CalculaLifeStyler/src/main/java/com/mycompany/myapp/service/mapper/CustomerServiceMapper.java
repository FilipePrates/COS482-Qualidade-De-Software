package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CustomerServiceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CustomerService} and its DTO {@link CustomerServiceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerServiceMapper extends EntityMapper<CustomerServiceDTO, CustomerService> {}
