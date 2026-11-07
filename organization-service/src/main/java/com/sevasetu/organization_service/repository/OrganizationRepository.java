package com.sevasetu.organization_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevasetu.organization_service.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>
{

}
