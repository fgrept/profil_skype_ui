package com.example.projetfilrouge.profilskypeuserinterface.controller;

import com.example.projetfilrouge.profilskypeuserinterface.beans.*;
import com.example.projetfilrouge.profilskypeuserinterface.proxies.ProfilSkypeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ClientController {


	private static Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	ProfilSkypeProxy mProfilSkype;

	
	@RequestMapping("/")
	public String accueil(Model model) {
		
		List<CollaboraterBean> collaboraters = mProfilSkype.listCollaborater().getBody();
		model.addAttribute("collaboraters",collaboraters);
		return "Accueil";
	}
	
	@GetMapping("/profile/all")
	public String profileAll(Model model) {
		
		List<SkypeProfileSearchBean> profils = mProfilSkype.listAllProfil().getBody();
		SkypeProfileSearchBean profil = new SkypeProfileSearchBean();
		model.addAttribute("skypeProfiles", profils);
		model.addAttribute("profil", profil);
		
		return "profileAll";
	}

	@PostMapping(value = "profile/update", params = "action=Edit")
	public String profilesUpdate(@ModelAttribute("profil") SkypeProfileSearchBean skypeProfile, Model model) {
	
		SkypeProfileSearchBean profilEdit = new SkypeProfileSearchBean();
		if (skypeProfile.getCollaboraterId() == null) {
			logger.error("pas de collaborater id");
			model.addAttribute("skypeProfile", profilEdit);
			return "profileUpdate";
		}
		profilEdit.setCollaboraterId(skypeProfile.getCollaboraterId());
		for (SkypeProfileSearchBean profileList : mProfilSkype.listAllProfil().getBody()) {
			if (profileList.getCollaboraterId().equals(profilEdit.getCollaboraterId())){
				profilEdit.setDialPlan(profileList.getDialPlan());
				profilEdit.setEnterpriseVoiceEnabled(profileList.getEnterpriseVoiceEnabled());
				profilEdit.setExchUser(profileList.getExchUser());
				profilEdit.setExUmEnabled(profileList.getExUmEnabled());
				profilEdit.setFirstName(profileList.getFirstName());
				profilEdit.setLastName(profileList.getLastName());
				profilEdit.setObjectClass(profileList.getObjectClass());
				profilEdit.setOrgaUnityCode(profileList.getOrgaUnityCode());
				profilEdit.setSamAccountName(profileList.getSamAccountName());
				profilEdit.setSIP(profileList.getSIP());
				profilEdit.setSiteCode(profileList.getSiteCode());
				profilEdit.setStatusProfile(profileList.getStatusProfile());
				profilEdit.setVoicePolicy(profileList.getVoicePolicy());
			}
		}

		model.addAttribute("skypeProfile", profilEdit);
		return "profileUpdate";
	}

	@PostMapping(value = "profile/update", params = "action=Delete")
	public String profileDelete(@ModelAttribute("profil") SkypeProfileSearchBean skypeProfile, Model model) {

		return "profileDelete";
	}
	
	@PostMapping("profile/update/valid")
	public String profilesUpdateValid(@ModelAttribute("skypeProfile") SkypeProfileSearchBean skypeProfile, Model model) {

		SkypeProfileCreateBean skypeProfilUpdate = new SkypeProfileCreateBean(skypeProfile, "update", "000000");
		mProfilSkype.updateSkypeProfil(skypeProfilUpdate);
		
		List<SkypeProfileSearchBean> profils = mProfilSkype.listAllProfil().getBody();
		SkypeProfileSearchBean profil = new SkypeProfileSearchBean();
		model.addAttribute("skypeProfiles", profils);
		model.addAttribute("profil", profil);
		
		return "profilsAll";
	}

	@GetMapping("user/create")
	public String userCreateForm(Model model) {
		
		model.addAttribute("userForm",new UserCreateBean());
		return "userCreateForm";
	}
	
	@PostMapping("users/create")
	public String userCreateResult(@ModelAttribute("userForm") UserCreateBean userCreate, Model model) {
		
		String message="l'utilisateur";
		if(userCreate!=null) {

		}else {
			logger.error("objet null");
			return "Accueil";
		}
		
		ItCorrespondantDtoCreate userDtoCreate = new ItCorrespondantDtoCreate();
		userDtoCreate.setCollaboraterId(userCreate.getCollaboraterId());
		Set<RoleTypeEnum> roles = new HashSet<RoleTypeEnum>();
		switch (userCreate.getRole())
		{
			case "admin":

				roles.add(RoleTypeEnum.ROLE_ADMIN);
				roles.add(RoleTypeEnum.ROLE_RESP);
				roles.add(RoleTypeEnum.ROLE_USER);
				break;
			case "resp":

				roles.add(RoleTypeEnum.ROLE_RESP);
				roles.add(RoleTypeEnum.ROLE_USER);
				break;
			case "user":

				roles.add(RoleTypeEnum.ROLE_USER);
				break;
			default:
				break;
		}
		if (mProfilSkype.createItCorrespondantFromCollab(userDtoCreate).getStatusCode()!=HttpStatus.CREATED) {
			message = "n'a pas été créé";
		}
		else {
			message = "a été créé";
		}
		model.addAttribute("message",message);

		return "userCreateResult";
	}

	@GetMapping("/profile/create/search")
	public String profilCreateSearch(Model model) {
		
		CollaboraterBean collaborater = new CollaboraterBean();
		collaborater.setCollaboraterId("300005");

		model.addAttribute("collaborater", collaborater);
		return "profileCreateSearch";
	}
	
	@PostMapping("/profile/create/select")
	public String profileCreateSelect(@ModelAttribute("collaborater") CollaboraterBean collaborater, Model model) {

		CollaboraterBean collaboraterSelect = new CollaboraterBean();

		List<CollaboraterBean> listCollaborater = mProfilSkype.listCollaboraterCriteriaPage(collaborater, 0, 100, "collaboraterId").getBody();
		model.addAttribute("listCollaborater", listCollaborater);
		model.addAttribute("collaboraterSelect",collaboraterSelect);
		return "profileCreateSelect";
	}
	
	@PostMapping("/profile/create/form")
	public String profileCreateForm(@ModelAttribute("collaboraterSelect") CollaboraterBean collaborater, Model model) {

		SkypeProfileCreateBean skypeProfile = new SkypeProfileCreateBean();
		skypeProfile.setCollaboraterId(collaborater.getCollaboraterId());
		skypeProfile.setStatusProfile(StatusSkypeProfileEnum.ENABLED);
		model.addAttribute("skypeProfile",skypeProfile);

		return "profileCreateForm";
	}

	@PostMapping(value = "/profile/create/valid", params = "action=Create")
	public String profileCreateValid(@ModelAttribute("skypeProfile") SkypeProfileCreateBean skypeProfile) {

		skypeProfile.setItCorrespondantId("000000");
		mProfilSkype.createSkypeProfil(skypeProfile);
		return "profileAll";
	}
}
