package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.CustomerServiceRepository;
import com.mycompany.myapp.service.CustomerServiceService;
import com.mycompany.myapp.service.dto.CustomerServiceDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.CustomerService}.
 */
@RestController
@RequestMapping("/api")
public class CustomerServiceResource {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceResource.class);

    private final CustomerServiceService customerServiceService;

    private final CustomerServiceRepository customerServiceRepository;

    public CustomerServiceResource(CustomerServiceService customerServiceService, CustomerServiceRepository customerServiceRepository) {
        this.customerServiceService = customerServiceService;
        this.customerServiceRepository = customerServiceRepository;
    }

    /**
     * {@code GET  /customer-services} : get all the customerServices.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customerServices in body.
     */
    @GetMapping("/customer-services")
    public List<CustomerServiceDTO> getAllCustomerServices() {
        log.debug("REST request to get all CustomerServices");
        return customerServiceService.findAll();
    }

    /**
     * {@code GET  /customer-services/:id} : get the "id" customerService.
     *
     * @param id the id of the customerServiceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customerServiceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/customer-services/{id}")
    public ResponseEntity<CustomerServiceDTO> getCustomerService(@PathVariable Long id) {
        log.debug("REST request to get CustomerService : {}", id);
        Optional<CustomerServiceDTO> customerServiceDTO = customerServiceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(customerServiceDTO);
    }
}
