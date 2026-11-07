package com.sevasetu.organization_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevasetu.organization_service.entity.Organization;
import com.sevasetu.organization_service.service.OrganizationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
	private final OrganizationService organizationService;
	
	
	public OrganizationController(OrganizationService organizationService) {
		super();
		this.organizationService = organizationService;
	}


	@GetMapping("/ping")
	public String ping() {
		return "SevaSetu Organization service is working!";
		
	}
	@PostMapping
	public Organization createOrganization(@Valid @RequestBody Organization organization) {
		return organizationService.SaveOrganization(organization);
	}
	
	@GetMapping
	public List<Organization> getAllOrganizations(){
		return organizationService.getAllOrganizations();
	}
	
	@GetMapping("/{id}")
	public Organization getOrganizationById(@PathVariable Long id) {
		return organizationService.getOrganizationById(id);
	}
	
	@PutMapping("/{id}")
	public Organization updateOrganization(
			@PathVariable Long id ,@Valid @RequestBody Organization organization) {
		return organizationService.updateOrganization(id, organization);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrganization(@PathVariable Long id) {
		organizationService.deleteOrganization(id);
	}
	
}
