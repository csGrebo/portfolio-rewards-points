package com.github.csgrebo.rewardspoints.dto;

import com.github.csgrebo.rewardspoints.model.PurchaseRecord;

import java.util.List;

public class RewardPointsDTO {

    private String userId;
    private Long rewardPoints;
    private List<PurchaseDTO> validPurchases;

    public RewardPointsDTO(String userId, Long rewardPoints, List<PurchaseDTO> validPurchases) {
        this.userId = userId;
        this.rewardPoints = rewardPoints;
        this.validPurchases = validPurchases;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public List<PurchaseDTO> getValidPurchases() {
        return validPurchases;
    }

    public void setValidPurchases(List<PurchaseDTO> validPurchases) {
        this.validPurchases = validPurchases;
    }
}
