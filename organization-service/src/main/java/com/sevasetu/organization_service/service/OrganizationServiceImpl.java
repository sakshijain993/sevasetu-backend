package com.sevasetu.organization_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sevasetu.organization_service.entity.Organization;
import com.sevasetu.organization_service.exception.ResourceNotFoundException;
import com.sevasetu.organization_service.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	private final OrganizationRepository organizationRepository;

	public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}

	@Override
	public Organization SaveOrganization(Organization organization) {
	
		return organizationRepository.save(organization);
	}

	@Override
	public List<Organization> getAllOrganizations() {
		
		return organizationRepository.findAll();
	}

	@Override
	public Organization getOrganizationById(Long id) {
		
		return organizationRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Organization not found with id: "+id));
	}

	@Override
	public Organization updateOrganization(Long id, Organization organization) {
		Organization existingOrganization = organizationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("organization not found with id: " + id));
		
		if(existingOrganization == null) {
			return null;
		}
		
		 existingOrganization.setName(organization.getName());
		 existingOrganization.setType(organization.getType());
         existingOrganization.setDescription(organization.getDescription());
	     existingOrganization.setAddress(organization.getAddress());
	     existingOrganization.setCity(organization.getCity());
	     existingOrganization.setState(organization.getState());
   	     existingOrganization.setPincode(organization.getPincode());
	     existingOrganization.setContactNumber(organization.getContactNumber());

	
		return organizationRepository.save(existingOrganization);
	}

	@Override
	public void deleteOrganization(Long id) {
		
		Organization organization = organizationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization not found with i: "+id));
	  organizationRepository.delete(organization);
		
	}
	

}
