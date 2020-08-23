package com.bnpparibas.projetfilrouge.profilskypeuserinterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.CollaboraterBean;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.ItCorrespondantDtoCreate;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.RoleTypeEnum;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.SkypeProfileSearchBean;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.UserCreateBean;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.proxies.ProfilSkypeProxy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

@Controller
public class ClientController {

	@Autowired
	ProfilSkypeProxy  mProfilSkype;
	
	@RequestMapping("/")
	public String accueil(Model model) {
		
		List<CollaboraterBean> collaboraters = mProfilSkype.listCollaborater().getBody();
		model.addAttribute("collaboraters",collaboraters);
		return "Accueil";
	}
	@GetMapping("/profiles/all")
	public String profileAll(Model model) {
		
//		List<SkypeProfileSearchBean> profils = mProfilSkype.listAllProfilByCriteriaPage(searchCriteria, numberPage, sizePage, criteria)
		
		List<SkypeProfileSearchBean> profils = mProfilSkype.listAllProfil().getBody();
		System.out.println("nb list : "+profils.size());
		model.addAttribute("skypeProfiles", profils);
		
		return "profilsAll";
	}
	
	@PostMapping("profiles/update")
	public String profilesUpdate(@RequestAttribute("toto") SkypeProfileSearchBean skypeProfile) {
		
		System.out.print("Méthode 1 ");
		System.out.print("skypeProfile id "+skypeProfile.getCollaboraterId());
		return "profilsUpdate";
	}
	
	@GetMapping("profiles/update2/{skypeProfile}")
	public String profilesUpdate2(@PathVariable("skypeProfile") SkypeProfileSearchBean skypeProfile) {
	
		System.out.print("Méthode 2 ");
		System.out.print("skypeProfile id "+skypeProfile.getCollaboraterId());

		return "profilsUpdate";
	}
	
	@GetMapping("users/create")
	public String userCreateForm(Model model) {
		
		model.addAttribute("userForm",new UserCreateBean());
		return "userCreateForm";
	}
	
	@PostMapping("users/create")
	public String userCreateResult(@ModelAttribute("userForm") UserCreateBean userCreate, Model model) {
		
		String message="toto";
		if(userCreate!=null) {
			System.out.println("userCreate, id "+userCreate.getCollaboraterId());
			System.out.println("userCreate, role "+userCreate.getRole());
		}else {
			System.out.println("objet null");
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
	//	userDtoCreate.setRoles(userCreate.getRole());
		return "userCreateResult";
	}
	
}
