package com.github.csgrebo.rewardspoints.repository;

import com.github.csgrebo.rewardspoints.model.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerRecord, Long> {
    Optional<CustomerRecord> findByUserId(String userId);
}
