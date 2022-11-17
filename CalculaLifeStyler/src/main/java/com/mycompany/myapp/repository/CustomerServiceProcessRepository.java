package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.CustomerServiceProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CustomerServiceProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerServiceProcessRepository extends JpaRepository<CustomerServiceProcess, Long> {
    Optional<CustomerServiceProcess> findByProcessInstanceId(Long processInstanceId);
}
