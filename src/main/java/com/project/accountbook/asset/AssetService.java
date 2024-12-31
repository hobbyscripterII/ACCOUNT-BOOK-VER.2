package com.project.accountbook.asset;

import org.springframework.stereotype.Service;

@Service
public class AssetService {
	private final AssetMapper assetMapper;
	
	public AssetService(AssetMapper assetMapper) {
		this.assetMapper = assetMapper;
	}
}
