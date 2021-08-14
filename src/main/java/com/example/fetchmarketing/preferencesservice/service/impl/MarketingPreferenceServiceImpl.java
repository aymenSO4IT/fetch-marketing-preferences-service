package com.example.fetchmarketing.preferencesservice.service.impl;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;
import com.example.fetchmarketing.preferencesservice.repository.MarketingPreferenceRepository;
import com.example.fetchmarketing.preferencesservice.service.MarketingPreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingPreferenceServiceImpl implements MarketingPreferenceService {

    private final MarketingPreferenceRepository marketingPreferenceRepository;

    public MarketingPreferenceServiceImpl(MarketingPreferenceRepository marketingPreferenceRepository) {
        this.marketingPreferenceRepository = marketingPreferenceRepository;
    }

    @Override
    public List<MarketingPreference> fetchMarketingPreferences() {
        return marketingPreferenceRepository.findAll();
    }
}
