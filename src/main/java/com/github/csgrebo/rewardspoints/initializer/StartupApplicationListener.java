package com.github.csgrebo.rewardspoints.initializer;

import com.github.csgrebo.rewardspoints.model.CustomerRecord;
import com.github.csgrebo.rewardspoints.model.PurchaseRecord;
import com.github.csgrebo.rewardspoints.repository.CustomerRepository;
import com.github.csgrebo.rewardspoints.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(StartupApplicationListener.class);

    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;

    public StartupApplicationListener(CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Loading Demo Data");
        CustomerRecord coberg = new CustomerRecord();
        coberg.setUserId("coberg");
        coberg.setFirstName("Christopher");
        coberg.setLastName("Oberg");
        coberg = customerRepository.save(coberg);
        CustomerRecord ebridg = new CustomerRecord();
        ebridg.setUserId("ebridg");
        ebridg.setFirstName("Ezra");
        ebridg.setLastName("Bridger");
        ebridg = customerRepository.save(ebridg);
        CustomerRecord golaak = new CustomerRecord();
        golaak.setUserId("golaak");
        golaak.setFirstName("Laa'ki");
        golaak.setLastName("The Goblin");
        golaak = customerRepository.save(golaak);
        CustomerRecord jsmith = new CustomerRecord();
        jsmith.setUserId("jsmith");
        jsmith.setFirstName("John");
        jsmith.setLastName("Smith");
        jsmith = customerRepository.save(jsmith);

        PurchaseRecord p1 = new PurchaseRecord(BigDecimal.valueOf(250.00), LocalDateTime.of(2020,10,30,2,30,0), ebridg);
        purchaseRepository.save(p1);
        PurchaseRecord p2 = new PurchaseRecord(BigDecimal.valueOf(200.00), LocalDateTime.of(2021,5,30,6,59,6), ebridg);
        purchaseRepository.save(p2);
        PurchaseRecord p3 = new PurchaseRecord(BigDecimal.valueOf(350.00), LocalDateTime.of(2021,6,1,12,0,0), coberg);
        purchaseRepository.save(p3);
        PurchaseRecord p4 = new PurchaseRecord(BigDecimal.valueOf(350.00),LocalDateTime.of(2021,7,1,12,0,0),coberg);
        purchaseRepository.save(p4);
        PurchaseRecord p5 = new PurchaseRecord(BigDecimal.valueOf(350.00),LocalDateTime.of(2021,8,1,12,0,0),coberg);
        purchaseRepository.save(p5);
        PurchaseRecord p6 = new PurchaseRecord(BigDecimal.valueOf(5000.00),LocalDateTime.of(2021,8,15,13,42,6),golaak);
        purchaseRepository.save(p6);
        PurchaseRecord p7 = new PurchaseRecord(BigDecimal.valueOf(350.00),LocalDateTime.of(2021,9,1,12,0,0),coberg);
        purchaseRepository.save(p7);
        PurchaseRecord p8 = new PurchaseRecord(BigDecimal.valueOf(20.00),LocalDateTime.of(2021,9,26,20,15,49),jsmith);
        purchaseRepository.save(p8);
        PurchaseRecord p9 = new PurchaseRecord(BigDecimal.valueOf(10.00),LocalDateTime.of(2021,9,26,23,55,16),jsmith);
        purchaseRepository.save(p9);
        PurchaseRecord p10 = new PurchaseRecord(BigDecimal.valueOf(30.00),LocalDateTime.of(2021,9,27,8,30,57),jsmith);
        purchaseRepository.save(p10);
        PurchaseRecord p11 = new PurchaseRecord(BigDecimal.valueOf(80.00),LocalDateTime.of(2021,9,28,10,3,7),jsmith);
        purchaseRepository.save(p11);
        PurchaseRecord p12 = new PurchaseRecord(BigDecimal.valueOf(250.00),LocalDateTime.of(2021,9,30,16,58,49),ebridg);
        purchaseRepository.save(p12);
        log.info("Demo Data Loaded");
    }
}
