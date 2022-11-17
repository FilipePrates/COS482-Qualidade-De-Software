package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerServiceMapperTest {

    private CustomerServiceMapper customerServiceMapper;

    @BeforeEach
    public void setUp() {
        customerServiceMapper = new CustomerServiceMapperImpl();
    }
}
