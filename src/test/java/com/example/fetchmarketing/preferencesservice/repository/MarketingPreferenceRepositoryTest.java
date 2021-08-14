package com.example.fetchmarketing.preferencesservice.repository;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;
import com.example.fetchmarketing.preferencesservice.model.MarketingPreferenceType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataMongoTest
@RunWith(SpringRunner.class)
public class MarketingPreferenceRepositoryTest {

    @Autowired
    private MarketingPreferenceRepository marketingPreferenceRepository;

    @AfterEach
    public void cleanUp() {
        this.marketingPreferenceRepository.deleteAll();
    }

    @Test
    public void fetchMarketingPreferenceTest() {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "email@gmail.com", null, null, null, null);
        marketingPreferenceRepository.save(marketingPreference);
        //action
        List<MarketingPreference> response = marketingPreferenceRepository.findAll();
        //verify
        Assert.assertEquals(response.size(), 1);
    }

    @Test
    public void fetchEmptyMarketingPreferenceTest() {
        //action
        List<MarketingPreference> response = marketingPreferenceRepository.findAll();
        //verify
        Assert.assertEquals(response.size(), 0);
    }
}