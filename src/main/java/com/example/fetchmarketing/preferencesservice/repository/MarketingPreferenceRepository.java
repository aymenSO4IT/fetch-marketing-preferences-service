package com.example.fetchmarketing.preferencesservice.repository;

import com.example.fetchmarketing.preferencesservice.entity.MarketingPreference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingPreferenceRepository extends MongoRepository<MarketingPreference, String> {

}

