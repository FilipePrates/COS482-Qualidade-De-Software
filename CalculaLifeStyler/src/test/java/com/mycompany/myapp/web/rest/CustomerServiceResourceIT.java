package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.CustomerService;
import com.mycompany.myapp.repository.CustomerServiceRepository;
import com.mycompany.myapp.service.dto.CustomerServiceDTO;
import com.mycompany.myapp.service.mapper.CustomerServiceMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link CustomerServiceResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CustomerServiceResourceIT {

    private static final String DEFAULT_START_DATE = "AAAAAAAAAA";
    private static final String UPDATED_START_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_END_DATE = "AAAAAAAAAA";
    private static final String UPDATED_END_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_CUSTOMER_SATISFACTION = 1;
    private static final Integer UPDATED_CUSTOMER_SATISFACTION = 2;

    private static final String DEFAULT_ORDER_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_DESCRIPTION = "BBBBBBBBBB";

    private static final Double DEFAULT_PAYMENT_VALUE = 1D;
    private static final Double UPDATED_PAYMENT_VALUE = 2D;

    private static final String DEFAULT_PAYMENT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_DESCRIPTION = "BBBBBBBBBB";

    private static final Double DEFAULT_EXPENSE_VALUE = 1D;
    private static final Double UPDATED_EXPENSE_VALUE = 2D;

    private static final String DEFAULT_EXPENSE_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_EXPENSE_DESCRIPTION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/customer-services";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CustomerServiceRepository customerServiceRepository;

    @Autowired
    private CustomerServiceMapper customerServiceMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerServiceMockMvc;

    private CustomerService customerService;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CustomerService createEntity(EntityManager em) {
        CustomerService customerService = new CustomerService()
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .customerSatisfaction(DEFAULT_CUSTOMER_SATISFACTION)
            .orderDescription(DEFAULT_ORDER_DESCRIPTION)
            .paymentValue(DEFAULT_PAYMENT_VALUE)
            .paymentDescription(DEFAULT_PAYMENT_DESCRIPTION)
            .expenseValue(DEFAULT_EXPENSE_VALUE)
            .expenseDescription(DEFAULT_EXPENSE_DESCRIPTION);
        return customerService;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CustomerService createUpdatedEntity(EntityManager em) {
        CustomerService customerService = new CustomerService()
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .customerSatisfaction(UPDATED_CUSTOMER_SATISFACTION)
            .orderDescription(UPDATED_ORDER_DESCRIPTION)
            .paymentValue(UPDATED_PAYMENT_VALUE)
            .paymentDescription(UPDATED_PAYMENT_DESCRIPTION)
            .expenseValue(UPDATED_EXPENSE_VALUE)
            .expenseDescription(UPDATED_EXPENSE_DESCRIPTION);
        return customerService;
    }

    @BeforeEach
    public void initTest() {
        customerService = createEntity(em);
    }

    @Test
    @Transactional
    void getAllCustomerServices() throws Exception {
        // Initialize the database
        customerServiceRepository.saveAndFlush(customerService);

        // Get all the customerServiceList
        restCustomerServiceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(customerService.getId().intValue())))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE)))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE)))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].customerSatisfaction").value(hasItem(DEFAULT_CUSTOMER_SATISFACTION)))
            .andExpect(jsonPath("$.[*].orderDescription").value(hasItem(DEFAULT_ORDER_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].paymentValue").value(hasItem(DEFAULT_PAYMENT_VALUE.doubleValue())))
            .andExpect(jsonPath("$.[*].paymentDescription").value(hasItem(DEFAULT_PAYMENT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].expenseValue").value(hasItem(DEFAULT_EXPENSE_VALUE.doubleValue())))
            .andExpect(jsonPath("$.[*].expenseDescription").value(hasItem(DEFAULT_EXPENSE_DESCRIPTION)));
    }

    @Test
    @Transactional
    void getCustomerService() throws Exception {
        // Initialize the database
        customerServiceRepository.saveAndFlush(customerService);

        // Get the customerService
        restCustomerServiceMockMvc
            .perform(get(ENTITY_API_URL_ID, customerService.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(customerService.getId().intValue()))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.customerSatisfaction").value(DEFAULT_CUSTOMER_SATISFACTION))
            .andExpect(jsonPath("$.orderDescription").value(DEFAULT_ORDER_DESCRIPTION))
            .andExpect(jsonPath("$.paymentValue").value(DEFAULT_PAYMENT_VALUE.doubleValue()))
            .andExpect(jsonPath("$.paymentDescription").value(DEFAULT_PAYMENT_DESCRIPTION))
            .andExpect(jsonPath("$.expenseValue").value(DEFAULT_EXPENSE_VALUE.doubleValue()))
            .andExpect(jsonPath("$.expenseDescription").value(DEFAULT_EXPENSE_DESCRIPTION));
    }

    @Test
    @Transactional
    void getNonExistingCustomerService() throws Exception {
        // Get the customerService
        restCustomerServiceMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
