package com.project.accountbook.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssetController {
	private final AssetService assetService;
	
	public AssetController(AssetService assetService) {
		this.assetService = assetService;
	}
	
	@GetMapping("/asset")
	public String asset() {
		return "asset";
	}
}