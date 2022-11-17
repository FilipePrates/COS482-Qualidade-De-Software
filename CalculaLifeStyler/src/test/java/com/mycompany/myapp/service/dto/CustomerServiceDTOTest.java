package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CustomerServiceDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CustomerServiceDTO.class);
        CustomerServiceDTO customerServiceDTO1 = new CustomerServiceDTO();
        customerServiceDTO1.setId(1L);
        CustomerServiceDTO customerServiceDTO2 = new CustomerServiceDTO();
        assertThat(customerServiceDTO1).isNotEqualTo(customerServiceDTO2);
        customerServiceDTO2.setId(customerServiceDTO1.getId());
        assertThat(customerServiceDTO1).isEqualTo(customerServiceDTO2);
        customerServiceDTO2.setId(2L);
        assertThat(customerServiceDTO1).isNotEqualTo(customerServiceDTO2);
        customerServiceDTO1.setId(null);
        assertThat(customerServiceDTO1).isNotEqualTo(customerServiceDTO2);
    }
}
