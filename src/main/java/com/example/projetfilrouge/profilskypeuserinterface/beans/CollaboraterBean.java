package com.example.projetfilrouge.profilskypeuserinterface.beans;

public class CollaboraterBean {
	
	private String collaboraterId;
	private String lastName;
	private String firstName;
	private String deskPhoneNumber;
	private String mobilePhoneNumber;
	private String mailAdress;
	private String orgaUnitCode;
	private String orgaUnityType;
	private String orgaShortLabel;
	private String siteCode;
	private String siteName;
	private String siteAddress;
	private String sitePostalCode;
	private String siteCity;
	
	public CollaboraterBean() {
		
		this.collaboraterId="";
		this.lastName="";
		this.firstName="";
		this.deskPhoneNumber="";
		this.mobilePhoneNumber="";
		this.mailAdress="";
		this.orgaUnitCode="";
		this.orgaUnityType="";
		this.orgaShortLabel="";
		this.siteCode="";
		this.siteName="";
		this.siteAddress="";
		this.sitePostalCode="";
		this.siteCity="";
	}
	
	public String getCollaboraterId() {
		return collaboraterId;
	}
	public void setCollaboraterId(String collaboraterId) {
		this.collaboraterId = collaboraterId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDeskPhoneNumber() {
		return deskPhoneNumber;
	}
	public void setDeskPhoneNumber(String deskPhoneNumber) {
		this.deskPhoneNumber = deskPhoneNumber;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public String getOrgaUnitCode() {
		return orgaUnitCode;
	}
	public void setOrgaUnitCode(String orgaUnitCode) {
		this.orgaUnitCode = orgaUnitCode;
	}
	public String getOrgaUnityType() {
		return orgaUnityType;
	}
	public void setOrgaUnityType(String orgaUnityType) {
		this.orgaUnityType = orgaUnityType;
	}
	public String getOrgaShortLabel() {
		return orgaShortLabel;
	}
	public void setOrgaShortLabel(String orgaShortLabel) {
		this.orgaShortLabel = orgaShortLabel;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getSitePostalCode() {
		return sitePostalCode;
	}
	public void setSitePostalCode(String sitePostalCode) {
		this.sitePostalCode = sitePostalCode;
	}
	public String getSiteCity() {
		return siteCity;
	}
	public void setSiteCity(String siteCity) {
		this.siteCity = siteCity;
	}
	@Override
	public String toString() {
		return "CollaboraterBean [collaboraterId=" + collaboraterId + ", lastName=" + lastName + ", firstName="
				+ firstName + ", deskPhoneNumber=" + deskPhoneNumber + ", mobilePhoneNumber=" + mobilePhoneNumber
				+ ", mailAdress=" + mailAdress + ", orgaUnitCode=" + orgaUnitCode + ", orgaUnityType=" + orgaUnityType
				+ ", orgaShortLabel=" + orgaShortLabel + ", siteCode=" + siteCode + ", siteName=" + siteName
				+ ", siteAddress=" + siteAddress + ", sitePostalCode=" + sitePostalCode + ", siteCity=" + siteCity
				+ "]";
	}
	

}
