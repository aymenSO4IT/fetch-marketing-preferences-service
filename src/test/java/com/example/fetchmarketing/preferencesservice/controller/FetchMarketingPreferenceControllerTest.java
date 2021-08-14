package com.example.fetchmarketing.preferencesservice.controller;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;
import com.example.fetchmarketing.preferencesservice.model.MarketingPreferenceType;
import com.example.fetchmarketing.preferencesservice.service.MarketingPreferenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FetchMarketingPreferenceController.class)
public class FetchMarketingPreferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarketingPreferenceService marketingPreferenceService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createMarketingPreferenceControllerTest() throws Exception {
        //setup
        MarketingPreference marketingPreference = new MarketingPreference(MarketingPreferenceType.EMAIL, "test@gmail.com", null, null, null, null);
        marketingPreference.setId("1");
        Mockito.when(marketingPreferenceService.fetchMarketingPreferences()).thenReturn(Collections.singletonList(marketingPreference));
        //action
        mockMvc.perform(get("/v1/marketingpreferences")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}
