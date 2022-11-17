package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.CustomerServiceProcess;
import com.mycompany.myapp.repository.CustomerServiceProcessRepository;
import com.mycompany.myapp.repository.CustomerServiceRepository;
import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import com.mycompany.myapp.service.mapper.CustomerServiceProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link CustomerServiceProcess}.
 */
@Service
@Transactional
public class CustomerServiceProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "CustomerServiceProcess";

    private final Logger log = LoggerFactory.getLogger(CustomerServiceProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final CustomerServiceRepository customerServiceRepository;

    private final CustomerServiceProcessRepository customerServiceProcessRepository;

    private final CustomerServiceProcessMapper customerServiceProcessMapper;

    public CustomerServiceProcessService(
        ProcessInstanceService processInstanceService,
        CustomerServiceRepository customerServiceRepository,
        CustomerServiceProcessRepository customerServiceProcessRepository,
        CustomerServiceProcessMapper customerServiceProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.customerServiceRepository = customerServiceRepository;
        this.customerServiceProcessRepository = customerServiceProcessRepository;
        this.customerServiceProcessMapper = customerServiceProcessMapper;
    }

    /**
     * Save a customerServiceProcess.
     *
     * @param customerServiceProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public CustomerServiceProcessDTO create(CustomerServiceProcessDTO customerServiceProcessDTO) {
        log.debug("Request to save CustomerServiceProcess : {}", customerServiceProcessDTO);

        CustomerServiceProcess customerServiceProcess = customerServiceProcessMapper.toEntity(customerServiceProcessDTO);

        //Saving the domainEntity
        customerServiceRepository.save(customerServiceProcess.getCustomerService());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "CustomerService#" + customerServiceProcess.getCustomerService().getId(),
            customerServiceProcess
        );
        customerServiceProcess.setProcessInstance(processInstance);

        //Saving the process entity
        customerServiceProcess = customerServiceProcessRepository.save(customerServiceProcess);
        return customerServiceProcessMapper.toDto(customerServiceProcess);
    }

    /**
     * Get all the customerServiceProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<CustomerServiceProcessDTO> findAll() {
        log.debug("Request to get all CustomerServiceProcesss");
        return customerServiceProcessRepository
            .findAll()
            .stream()
            .map(customerServiceProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one customerServiceProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CustomerServiceProcessDTO> findOne(Long id) {
        log.debug("Request to get CustomerServiceProcess : {}", id);
        return customerServiceProcessRepository.findById(id).map(customerServiceProcessMapper::toDto);
    }

    /**
     * Get one customerServiceProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CustomerServiceProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get CustomerServiceProcess by  processInstanceId: {}", processInstanceId);
        return customerServiceProcessRepository.findByProcessInstanceId(processInstanceId).map(customerServiceProcessMapper::toDto);
    }
}
