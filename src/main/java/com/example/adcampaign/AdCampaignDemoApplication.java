package com.example.adcampaign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.adcampaign.domain.CampaignBean;

@SpringBootApplication
public class AdCampaignDemoApplication {

	public static Map<String, CampaignBean> campaignRepository;

	public static void main(String[] args) {
		campaignRepository = new HashMap<String, CampaignBean>();

		CampaignBean firstCampaign = new CampaignBean("partner1", 11, "My first(1) campaign");
		campaignRepository.put(new String(firstCampaign.getPartnerId()), firstCampaign);

		CampaignBean secondCampaign = new CampaignBean("partner2", 12, "My second(2) campaign");
		campaignRepository.put(new String(secondCampaign.getPartnerId()), secondCampaign);

		CampaignBean thirdCampaign = new CampaignBean("partner3", 13, "My third(3) campaign");
		campaignRepository.put(new String(thirdCampaign.getPartnerId()), thirdCampaign);

		CampaignBean fourthCampaign = new CampaignBean("partner1", 14, "My fourth(4) campaign");
		campaignRepository.put(new String(fourthCampaign.getPartnerId()), fourthCampaign);

		CampaignBean fifthCampaign = new CampaignBean("partner2", 15, "My fifth(5) campaign");
		campaignRepository.put(new String(fifthCampaign.getPartnerId()), fifthCampaign);

		SpringApplication.run(AdCampaignDemoApplication.class, args);
	}
}
