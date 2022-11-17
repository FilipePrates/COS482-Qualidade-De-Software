package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CustomerServiceProcessService;
import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.CustomerServiceProcess}.
 */
@RestController
@RequestMapping("/api")
public class CustomerServiceProcessResource {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceProcessResource.class);

    private static final String ENTITY_NAME = "customerServiceProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CustomerServiceProcessService customerServiceProcessService;

    public CustomerServiceProcessResource(CustomerServiceProcessService customerServiceProcessService) {
        this.customerServiceProcessService = customerServiceProcessService;
    }

    /**
     * {@code POST  /customer-service-processes} : Create a new customerServiceProcess.
     *
     * @param customerServiceProcessDTO the customerServiceProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new customerServiceProcessDTO, or with status {@code 400 (Bad Request)} if the customerServiceProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/customer-service-processes")
    public ResponseEntity<CustomerServiceProcessDTO> create(@RequestBody CustomerServiceProcessDTO customerServiceProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save CustomerServiceProcess : {}", customerServiceProcessDTO);
        if (customerServiceProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new customerServiceProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CustomerServiceProcessDTO result = customerServiceProcessService.create(customerServiceProcessDTO);
        return ResponseEntity
            .created(new URI("/api/customer-service-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /customer-service-processes} : get all the customerServiceProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customerServiceProcesss in body.
     */
    @GetMapping("/customer-service-processes")
    public List<CustomerServiceProcessDTO> getAllCustomerServiceProcesss() {
        log.debug("REST request to get all CustomerServiceProcesss");
        return customerServiceProcessService.findAll();
    }

    /**
     * {@code GET  /customer-service-processes/:id} : get the "id" customerServiceProcess.
     *
     * @param processInstanceId the id of the customerServiceProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customerServiceProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/customer-service-processes/{processInstanceId}")
    public ResponseEntity<CustomerServiceProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get CustomerServiceProcess by processInstanceId : {}", processInstanceId);
        Optional<CustomerServiceProcessDTO> customerServiceProcessDTO = customerServiceProcessService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(customerServiceProcessDTO);
    }
}
