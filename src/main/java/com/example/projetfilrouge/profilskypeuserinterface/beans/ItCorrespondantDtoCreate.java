package com.example.projetfilrouge.profilskypeuserinterface.beans;

import java.util.Set;

public class ItCorrespondantDtoCreate {

	private String collaboraterId;
	
	private Set<RoleTypeEnum> roles;
	
	public String getCollaboraterId() {
		return collaboraterId;
	}
	public void setCollaboraterId(String collaboraterId) {
		this.collaboraterId = collaboraterId;
	}
	public Set<RoleTypeEnum> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleTypeEnum> roles) {
		this.roles = roles;
	}
	
}
