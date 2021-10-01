package com.github.csgrebo.rewardspoints.repository;

import com.github.csgrebo.rewardspoints.model.CustomerRecord;
import com.github.csgrebo.rewardspoints.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<PurchaseRecord, Long> {
    List<PurchaseRecord> findAllByCustomer(CustomerRecord customer);
}
