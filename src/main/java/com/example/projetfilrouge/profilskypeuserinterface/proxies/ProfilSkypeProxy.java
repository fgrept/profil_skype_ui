package com.example.projetfilrouge.profilskypeuserinterface.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.projetfilrouge.profilskypeuserinterface.beans.CollaboraterBean;
import com.example.projetfilrouge.profilskypeuserinterface.beans.ItCorrespondantDtoCreate;
import com.example.projetfilrouge.profilskypeuserinterface.beans.SkypeProfileCreateBean;
import com.example.projetfilrouge.profilskypeuserinterface.beans.SkypeProfileSearchBean;



@FeignClient(name = "profil-skype", url = "localhost:8181")
public interface ProfilSkypeProxy {
	
	@PostMapping(value = "/v1/collaborater/listbis")
	public ResponseEntity<List<CollaboraterBean>> listBis(@RequestBody CollaboraterBean collab);
	
	@GetMapping(value = "/v1/collaborater/list")
	public ResponseEntity<List<CollaboraterBean>> listCollaborater();
	
	@PostMapping("/v1/collaborater/list/criteria/{numberPage}/{sizePage}/{criteria}")
	public ResponseEntity<List<CollaboraterBean>> listCollaboraterCriteriaPage(@RequestBody CollaboraterBean collaboraterDto,@PathVariable("numberPage") int numberPage, @PathVariable("sizePage") int sizePage, @PathVariable("criteria") String criteria);
	
	@PostMapping("/v1/profile/list/criteria/{numberPage}/{sizePage}/{criteria}")
	public ResponseEntity<List<SkypeProfileSearchBean>> listAllProfilByCriteriaPage(@RequestBody SkypeProfileSearchBean searchCriteria,@PathVariable("numberPage") int numberPage, @PathVariable("sizePage") int sizePage, @PathVariable("criteria") String criteria);

	@GetMapping("/v1/profile/list/all")
	public ResponseEntity<List<SkypeProfileSearchBean>> listAllProfil();
	
	@PostMapping("/v1/users/create")
	public ResponseEntity<String> createItCorrespondantFromCollab(@RequestBody ItCorrespondantDtoCreate dto);
	
	@PostMapping("/v1/profile/update")
	public ResponseEntity<String> updateSkypeProfil(@RequestBody SkypeProfileCreateBean skypeProfile);

	@PostMapping("/v1/create")
	public ResponseEntity<String> createSkypeProfil(@RequestBody SkypeProfileCreateBean skypeProfile);
}