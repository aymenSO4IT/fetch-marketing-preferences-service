package com.example.fetchmarketing.preferencesservice.service;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;
import com.example.fetchmarketing.preferencesservice.model.MarketingPreferenceType;
import com.example.fetchmarketing.preferencesservice.repository.MarketingPreferenceRepository;
import com.example.fetchmarketing.preferencesservice.service.impl.MarketingPreferenceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class FetchMarketingPreferenceServiceTest {

    @Mock
    private MarketingPreferenceRepository marketingPreferenceRepository;

    private MarketingPreferenceService marketingPreferenceService;

    @Before
    public void setup() {
        marketingPreferenceService = new MarketingPreferenceServiceImpl(marketingPreferenceRepository);
        ;
    }

    @Test
    public void getMarketingPreferencesTest() {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "test@gmail.com", null, null, null, null);
        marketingPreference.setId("1");
        Mockito.when(marketingPreferenceService.fetchMarketingPreferences()).thenReturn(Collections.singletonList(marketingPreference));
        //given
        when(marketingPreferenceRepository.findAll()).thenReturn(Collections.singletonList(marketingPreference));
        List<MarketingPreference> marketingPreferences = marketingPreferenceService.fetchMarketingPreferences();

        //verify
        Assert.assertEquals(marketingPreferences.get(0), marketingPreference);
    }
}