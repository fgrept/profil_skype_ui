package com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans;


public class SkypeProfileBean {
	// DONNEES DU PROFIL
	// ******************************************************************************
	//syntaxe d'un SIP (RFC 3261) : URI = sip:x@y:Port x=nom d’utilisateur et y=hôte (domaine ou IP)

	private String SIP;
	private String enterpriseVoiceEnabled;	
	private String voicePolicy;
	private String dialPlan;
	private String samAccountName;
	private String exUmEnabled;
	private String exchUser;
	private String objectClass;
	//statut du profil : activé, désactivé, expiré
	private StatusSkypeProfileEnum statusProfile;	


	private String collaboraterId;


	public String getSIP() {
		return SIP;
	}


	public void setSIP(String sIP) {
		SIP = sIP;
	}


	public String getEnterpriseVoiceEnabled() {
		return enterpriseVoiceEnabled;
	}


	public void setEnterpriseVoiceEnabled(String enterpriseVoiceEnabled) {
		this.enterpriseVoiceEnabled = enterpriseVoiceEnabled;
	}


	public String getVoicePolicy() {
		return voicePolicy;
	}


	public void setVoicePolicy(String voicePolicy) {
		this.voicePolicy = voicePolicy;
	}


	public String getDialPlan() {
		return dialPlan;
	}


	public void setDialPlan(String dialPlan) {
		this.dialPlan = dialPlan;
	}


	public String getSamAccountName() {
		return samAccountName;
	}


	public void setSamAccountName(String samAccountName) {
		this.samAccountName = samAccountName;
	}


	public String getExUmEnabled() {
		return exUmEnabled;
	}


	public void setExUmEnabled(String exUmEnabled) {
		this.exUmEnabled = exUmEnabled;
	}


	public String getExchUser() {
		return exchUser;
	}


	public void setExchUser(String exchUser) {
		this.exchUser = exchUser;
	}


	public String getObjectClass() {
		return objectClass;
	}


	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}


	public StatusSkypeProfileEnum getStatusProfile() {
		return statusProfile;
	}


	public void setStatusProfile(StatusSkypeProfileEnum statusProfile) {
		this.statusProfile = statusProfile;
	}


	public String getCollaboraterId() {
		return collaboraterId;
	}


	public void setCollaboraterId(String collaboraterId) {
		this.collaboraterId = collaboraterId;
	}


	@Override
	public String toString() {
		return "SkypeProfileBean [SIP=" + SIP + ", enterpriseVoiceEnabled=" + enterpriseVoiceEnabled + ", voicePolicy="
				+ voicePolicy + ", dialPlan=" + dialPlan + ", samAccountName=" + samAccountName + ", exUmEnabled="
				+ exUmEnabled + ", exchUser=" + exchUser + ", objectClass=" + objectClass + ", statusProfile="
				+ statusProfile + ", collaboraterId=" + collaboraterId + "]";
	}
	
}
