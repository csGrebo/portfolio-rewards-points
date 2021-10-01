package com.github.csgrebo.rewardspoints.service;

import com.github.csgrebo.rewardspoints.dto.PurchaseDTO;
import com.github.csgrebo.rewardspoints.dto.RewardPointsDTO;
import com.github.csgrebo.rewardspoints.exception.CustomerNotFoundException;
import com.github.csgrebo.rewardspoints.mapping.PurchaseRecordToPurchaseDTOMapper;
import com.github.csgrebo.rewardspoints.model.CustomerRecord;
import com.github.csgrebo.rewardspoints.model.PurchaseRecord;
import com.github.csgrebo.rewardspoints.repository.CustomerRepository;
import com.github.csgrebo.rewardspoints.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardCalculationService {
    private static final Logger log = LoggerFactory.getLogger(RewardCalculationService.class);

    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseRecordToPurchaseDTOMapper purchaseMapper;

    public RewardCalculationService(CustomerRepository customerRepository, PurchaseRepository purchaseRepository, PurchaseRecordToPurchaseDTOMapper purchaseMapper) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    public RewardPointsDTO calculateRewards(String userId) throws CustomerNotFoundException {
        CustomerRecord customer = customerRepository.findByUserId(userId).orElseThrow(() -> new CustomerNotFoundException(String.format("Customer ID %s not found", userId)));
        List<PurchaseDTO> relevantPurchases = purchaseRepository.findAllByCustomer(customer).stream().filter(this::isEligiblePurchase).map(purchaseMapper::convert).collect(Collectors.toList());
        long points = 0L;
        for (PurchaseDTO purchase : relevantPurchases) {
            if (purchase.getPurchaseAmount().compareTo(BigDecimal.valueOf(50)) < 0) {
                log.warn("Purchase with ID {} ineligible for rewards", purchase.getPurchaseId());
            } else if (purchase.getPurchaseAmount().compareTo(BigDecimal.valueOf(100)) < 0) {
                points+=purchase.getPurchaseAmount().longValue()-50;
            } else {
                points+=((purchase.getPurchaseAmount().longValue()-100)*2)+50;
            }
        }
        log.info("Total points for user {} - {}", userId, points);
        return new RewardPointsDTO(userId, points, relevantPurchases);
    }

    private boolean isEligiblePurchase(PurchaseRecord purchase) {
        return purchase.getPurchaseDate().isAfter(LocalDateTime.now().minusMonths(3L));
    }
}
