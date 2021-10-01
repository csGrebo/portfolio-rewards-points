package com.github.csgrebo.rewardspoints.controller;

import com.github.csgrebo.rewardspoints.dto.RewardPointsDTO;
import com.github.csgrebo.rewardspoints.exception.CustomerNotFoundException;
import com.github.csgrebo.rewardspoints.service.RewardCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class RewardsController {

    private final RewardCalculationService rewardCalculationService;

    public RewardsController(RewardCalculationService rewardCalculationService) {
        this.rewardCalculationService = rewardCalculationService;
    }

    @GetMapping(path = "/reward-balance")
    public RewardPointsDTO getRewardBalance(@RequestParam @NotNull String userId) throws CustomerNotFoundException {
        return rewardCalculationService.calculateRewards(userId);
    }
}
