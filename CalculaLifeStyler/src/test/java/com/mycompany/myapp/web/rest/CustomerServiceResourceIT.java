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
import java.time.LocalDate;
import java.time.ZoneId;
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

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_SERVICE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SERVICE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_CUSTOMER_SATISFACTION = false;
    private static final Boolean UPDATED_CUSTOMER_SATISFACTION = true;

    private static final Boolean DEFAULT_IS_THERE_EXTRA_EXPENSES = false;
    private static final Boolean UPDATED_IS_THERE_EXTRA_EXPENSES = true;

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
            .name(DEFAULT_NAME)
            .serviceDate(DEFAULT_SERVICE_DATE)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .customerSatisfaction(DEFAULT_CUSTOMER_SATISFACTION)
            .isThereExtraExpenses(DEFAULT_IS_THERE_EXTRA_EXPENSES)
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
            .name(UPDATED_NAME)
            .serviceDate(UPDATED_SERVICE_DATE)
            .customerName(UPDATED_CUSTOMER_NAME)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .customerSatisfaction(UPDATED_CUSTOMER_SATISFACTION)
            .isThereExtraExpenses(UPDATED_IS_THERE_EXTRA_EXPENSES)
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
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].serviceDate").value(hasItem(DEFAULT_SERVICE_DATE.toString())))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].customerSatisfaction").value(hasItem(DEFAULT_CUSTOMER_SATISFACTION.booleanValue())))
            .andExpect(jsonPath("$.[*].isThereExtraExpenses").value(hasItem(DEFAULT_IS_THERE_EXTRA_EXPENSES.booleanValue())))
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
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.serviceDate").value(DEFAULT_SERVICE_DATE.toString()))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.customerSatisfaction").value(DEFAULT_CUSTOMER_SATISFACTION.booleanValue()))
            .andExpect(jsonPath("$.isThereExtraExpenses").value(DEFAULT_IS_THERE_EXTRA_EXPENSES.booleanValue()))
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
