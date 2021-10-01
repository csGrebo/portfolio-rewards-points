package com.github.csgrebo.rewardspoints;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.github.csgrebo.rewardspoints.dto.RewardPointsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardsControllerTest {

    @Test
    void cobergPoints(@Autowired TestRestTemplate restTemplate) {
        RewardPointsDTO result = restTemplate.getForObject("/reward-balance?userId=coberg", RewardPointsDTO.class);
        assertNotNull(result);
        assertEquals(1650, result.getRewardPoints());
        assertEquals(3, result.getValidPurchases().size());
    }

    @Test
    void golaakPoints(@Autowired TestRestTemplate restTemplate) {
        RewardPointsDTO result = restTemplate.getForObject("/reward-balance?userId=golaak", RewardPointsDTO.class);
        assertNotNull(result);
        assertNotEquals(1650, result.getRewardPoints());
        assertEquals(1, result.getValidPurchases().size());
        assertEquals("golaak", result.getUserId());
    }
}
