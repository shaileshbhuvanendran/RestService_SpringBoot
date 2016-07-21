package com.example.adcampaign.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adcampaign.AdCampaignDemoApplication;
import com.example.adcampaign.domain.CampaignBean;

@RestController
@RequestMapping(value = "/adcampaigns")
public class AdCampaignController {

	// --------Retrieve all ADCampaigns----------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, CampaignBean> fetchAllAds() {
		return AdCampaignDemoApplication.campaignRepository;
	}

	// --------Create a ADCampaign----------
	@RequestMapping(value = "/ad", method = RequestMethod.POST)
	public CampaignBean createCampaign(@RequestParam(value = "partnerId") String partnerId,
			@RequestParam(value = "duration") int duration, @RequestParam(value = "adContent") String adContent) {
		CampaignBean campaign = new CampaignBean(partnerId, duration, adContent);
		if (AdCampaignDemoApplication.campaignRepository.containsKey(new String(campaign.getPartnerId()))) {
			AdCampaignDemoApplication.campaignRepository.put(new String(campaign.getPartnerId()), campaign);
		} else {
			throw new IllegalArgumentException("The partner id already exists");
		}

		return campaign;
	}

	// --------Fetch a ADCampaign----------
	@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET)
	public CampaignBean fetchAd(@PathVariable("partnerId") String partnerId) {
		if (StringUtils.isEmpty(partnerId)) {
			throw new NoSuchElementException("PartnerId " + partnerId + " does not exist");
		}
		return AdCampaignDemoApplication.campaignRepository.get(partnerId);
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleNotFound(IllegalArgumentException e) {
		return e.getMessage();
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public String handleNotFound(NoSuchElementException e) {
		return e.getMessage();
	}

}
