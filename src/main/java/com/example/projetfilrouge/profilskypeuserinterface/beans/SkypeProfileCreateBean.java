package com.example.projetfilrouge.profilskypeuserinterface.beans;

public class SkypeProfileCreateBean extends SkypeProfileBean{
	
	private String itCorrespondantId;
	private String eventComment;
	
	public SkypeProfileCreateBean() {
		
	}
	
	public SkypeProfileCreateBean(SkypeProfileBean skypeProfil, String event, String itCorrespondantId) {
		
		System.out.println(skypeProfil);
		this.setCollaboraterId(skypeProfil.getCollaboraterId());
		this.setDialPlan(skypeProfil.getDialPlan());
		this.setEnterpriseVoiceEnabled(skypeProfil.getEnterpriseVoiceEnabled());
		this.setExchUser(skypeProfil.getExchUser());
		this.setExUmEnabled(skypeProfil.getExUmEnabled());
		this.setObjectClass(skypeProfil.getObjectClass());
		this.setSamAccountName(skypeProfil.getSamAccountName());
		this.setSIP(skypeProfil.getSIP());
		this.setVoicePolicy(skypeProfil.getVoicePolicy());
		
		this.eventComment=event;
		this.itCorrespondantId=itCorrespondantId;
	}
	
	public String getItCorrespondantId() {
		return itCorrespondantId;
	}
	public void setItCorrespondantId(String itCorrespondantId) {
		this.itCorrespondantId = itCorrespondantId;
	}
	public String getEventComment() {
		return eventComment;
	}
	public void setEventComment(String eventComment) {
		this.eventComment = eventComment;
	}
	
}
