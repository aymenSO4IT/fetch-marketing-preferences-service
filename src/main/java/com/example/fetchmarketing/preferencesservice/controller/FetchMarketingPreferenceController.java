package com.example.fetchmarketing.preferencesservice.controller;

import com.example.fetchmarketing.preferencesservice.model.MarketingPreferenceDto;
import com.example.fetchmarketing.preferencesservice.service.MarketingPreferenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/marketingpreferences", produces = MediaType.APPLICATION_JSON_VALUE)
@SwaggerDefinition(tags = {@Tag( name = "Save marketing preference")})
public class FetchMarketingPreferenceController {

    private MarketingPreferenceService marketingPreferenceService;

    public FetchMarketingPreferenceController(MarketingPreferenceService marketingPreferenceService) {
        this.marketingPreferenceService = marketingPreferenceService;
    }

    @ApiOperation(value = "Fetch marketing preference")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MarketingPreferenceDto>> getMarketingPreferences() {
        return ResponseEntity.ok(marketingPreferenceService.fetchMarketingPreferences()
                .stream()
                .map(marketingPreference ->
                        new MarketingPreferenceDto(
                                marketingPreference.getId(),
                                marketingPreference.getType(),
                                marketingPreference.getEmail(),
                                marketingPreference.getPhoneNumber(),
                                marketingPreference.getPostalCode(),
                                marketingPreference.getCity(),
                                marketingPreference.getAddress()))
                .collect(Collectors.toList()));
    }
}


