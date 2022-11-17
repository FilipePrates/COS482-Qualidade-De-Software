package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CustomerService;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CustomerService entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Long> {}
