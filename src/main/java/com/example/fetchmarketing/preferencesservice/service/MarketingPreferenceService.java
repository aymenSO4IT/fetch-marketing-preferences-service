package com.example.fetchmarketing.preferencesservice.service;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;

import java.util.List;

public interface MarketingPreferenceService {
    List<MarketingPreference> fetchMarketingPreferences();
}
