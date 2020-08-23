package com.bnpparibas.projetfilrouge.profilskypeuserinterface.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.CollaboraterBean;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.ItCorrespondantDtoCreate;
import com.bnpparibas.projetfilrouge.profilskypeuserinterface.beans.SkypeProfileSearchBean;



@FeignClient(name = "profil-skype", url = "localhost:8181")
public interface ProfilSkypeProxy {
	
	@GetMapping(value = "/collaborater/list")
	public ResponseEntity<List<CollaboraterBean>> listCollaborater();
	
	@GetMapping("/profile/list/criteria/{numberPage}/{sizePage}/{criteria}")
	public ResponseEntity<List<SkypeProfileSearchBean>> listAllProfilByCriteriaPage(@RequestBody SkypeProfileSearchBean searchCriteria,@PathVariable("numberPage") int numberPage, @PathVariable("sizePage") int sizePage, @PathVariable("criteria") String criteria);

	@GetMapping("/profile/list/all")
	public ResponseEntity<List<SkypeProfileSearchBean>> listAllProfil();
	
	@PostMapping("/users/create")
	public ResponseEntity<String> createItCorrespondantFromCollab(@RequestBody ItCorrespondantDtoCreate dto);
	
}