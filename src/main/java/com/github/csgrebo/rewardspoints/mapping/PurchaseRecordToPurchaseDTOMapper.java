package com.github.csgrebo.rewardspoints.mapping;

import com.github.csgrebo.rewardspoints.dto.PurchaseDTO;
import com.github.csgrebo.rewardspoints.model.PurchaseRecord;
import org.springframework.stereotype.Component;

@Component
public class PurchaseRecordToPurchaseDTOMapper {

    public PurchaseDTO convert(PurchaseRecord record) {
        return new PurchaseDTO(record.getPurchaseDate(), record.getPurchaseAmount(), record.getPurchaseId());
    }
}
