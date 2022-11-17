package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CustomerServiceTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CustomerService.class);
        CustomerService customerService1 = new CustomerService();
        customerService1.setId(1L);
        CustomerService customerService2 = new CustomerService();
        customerService2.setId(customerService1.getId());
        assertThat(customerService1).isEqualTo(customerService2);
        customerService2.setId(2L);
        assertThat(customerService1).isNotEqualTo(customerService2);
        customerService1.setId(null);
        assertThat(customerService1).isNotEqualTo(customerService2);
    }
}
