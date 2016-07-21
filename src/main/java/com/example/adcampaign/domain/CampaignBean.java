package com.example.adcampaign.domain;

public class CampaignBean {

	private String partnerId;

	private int duration;

	private String adContent;

	public CampaignBean() {

	}

	public CampaignBean(String partId, int time, String content) {
		this.partnerId = partId;
		this.duration = time;
		this.adContent = content;

	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	@Override

	public String toString() {
		return new StringBuffer(" Partner Id : ").append(this.partnerId).append(" Duration : ").append(this.duration)
				.append(" Content : ").append(this.adContent).toString();
	}

}
