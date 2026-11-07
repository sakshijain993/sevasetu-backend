
package com.sevasetu.need_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.sevasetu.need_service.client.OrganizationClient;
import com.sevasetu.need_service.entity.Need;
import com.sevasetu.need_service.repository.NeedRepository;

@Service
public class NeedImplementation implements ServiceNeed {

    private final NeedRepository needRepository;
    private final OrganizationClient organizationClient;

    public NeedImplementation(
            NeedRepository needRepository,
            OrganizationClient organizationClient) {

        this.needRepository = needRepository;
        this.organizationClient = organizationClient;
    }

    // Validate organization
    private void validateOrganization(Long organizationId) {

        try {
            organizationClient.getOrganizationById(organizationId);

        } catch (RestClientResponseException e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Organization ID does not exist"
            );
        }
    }

    // Create Need
    @Override
    public Need createNeed(Need need) {

        validateOrganization(need.getOrganizationId());

        return needRepository.save(need);
    }

    // Get all Needs
    @Override
    public List<Need> getAllNeeds() {

        return needRepository.findAll();
    }

    // Delete Need
    @Override
    public void deleteNeed(Long id) {

        Need existingNeed = needRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Need not found"
                ));

        needRepository.delete(existingNeed);
    }

    // Update Need
    @Override
    public Need updateNeed(Long id, Need need) {

        Need existingNeed = needRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Need not found"
                ));

        validateOrganization(need.getOrganizationId());

        existingNeed.setTitle(need.getTitle());
        existingNeed.setCategory(need.getCategory());
        existingNeed.setQuantity(need.getQuantity());
        existingNeed.setUnit(need.getUnit());
        existingNeed.setStatus(need.getStatus());
        existingNeed.setOrganizationId(need.getOrganizationId());

        // New fields
        existingNeed.setDescription(need.getDescription());
        existingNeed.setTargetAmount(need.getTargetAmount());
        existingNeed.setRaisedAmount(need.getRaisedAmount());
        existingNeed.setPriority(need.getPriority());

        return needRepository.save(existingNeed);
    }

	@Override
	public Need getNeedById(Long id) {
		 return needRepository.findById(id)
		            .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
		                    org.springframework.http.HttpStatus.NOT_FOUND,
		                    "Need not found with id: " + id
		            ));
	}
}
