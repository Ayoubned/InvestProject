package com.example.investhub.Service;

import com.example.investhub.Model.Asset;
import com.example.investhub.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public Asset createAsset(Asset asset) {
        // Add validation and business logic
        return assetRepository.save(asset);
    }

    public Asset getAssetBySymbol(String symbol) {
        return assetRepository.findBySymbol(symbol)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    // Other asset-related methods
}
