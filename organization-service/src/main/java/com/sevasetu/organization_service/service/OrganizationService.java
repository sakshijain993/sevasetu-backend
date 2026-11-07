
package com.sevasetu.organization_service.service;


import java.util.List;

import com.sevasetu.organization_service.entity.Organization;



public interface OrganizationService {

   Organization SaveOrganization(Organization organization);
   List<Organization> getAllOrganizations();
   Organization getOrganizationById(Long id);
   Organization updateOrganization(Long id, Organization organization);
   void deleteOrganization(Long id);
}
