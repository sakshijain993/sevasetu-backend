
package com.sevasetu.need_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sevasetu.need_service.dto.NeedRequestDTO;
import com.sevasetu.need_service.dto.NeedResponseDTO;
import com.sevasetu.need_service.entity.Need;
import com.sevasetu.need_service.service.ServiceNeed;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/needs")
public class NeedController {

    private final ServiceNeed serviceNeed;

    public NeedController(ServiceNeed serviceNeed) {
        this.serviceNeed = serviceNeed;
    }

    @GetMapping("/ping")
    public String checkService() {
        return "SevaSetu Need Service is working";
    }

    // Get all needs
    @GetMapping
    public List<NeedResponseDTO> getAllNeeds() {

        return serviceNeed.getAllNeeds()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
    
    @GetMapping("/{id}")
    public NeedResponseDTO getNeedById(@PathVariable Long id) {

        Need need = serviceNeed.getNeedById(id);

        return convertToDTO(need);
    }

    // Create new need
    @PostMapping
    public NeedResponseDTO createNeed(
            @Valid @RequestBody NeedRequestDTO dto) {

        Need need = new Need();

        need.setTitle(dto.getTitle());
        need.setCategory(dto.getCategory());
        need.setQuantity(dto.getQuantity());
        need.setUnit(dto.getUnit());
        need.setStatus(dto.getStatus());
        need.setOrganizationId(dto.getOrganizationId());
        need.setDescription(dto.getDescription());
        need.setTargetAmount(dto.getTargetAmount());
        need.setRaisedAmount(dto.getRaisedAmount());
        need.setPriority(dto.getPriority());

        Need savedNeed = serviceNeed.createNeed(need);

        return convertToDTO(savedNeed);
    }

    // Delete need
    @DeleteMapping("/{id}")
    public void deleteNeed(@PathVariable Long id) {

        serviceNeed.deleteNeed(id);
    }

    // Update existing need
    @PutMapping("/{id}")
    public NeedResponseDTO updateNeed(
            @PathVariable Long id,
            @Valid @RequestBody NeedRequestDTO dto) {

        Need need = new Need();

        need.setTitle(dto.getTitle());
        need.setCategory(dto.getCategory());
        need.setQuantity(dto.getQuantity());
        need.setUnit(dto.getUnit());
        need.setStatus(dto.getStatus());
        need.setOrganizationId(dto.getOrganizationId());
        need.setDescription(dto.getDescription());
        need.setTargetAmount(dto.getTargetAmount());
        need.setRaisedAmount(dto.getRaisedAmount());
        need.setPriority(dto.getPriority());

        Need updatedNeed = serviceNeed.updateNeed(id, need);

        if (updatedNeed == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Need not found"
            );
        }

        return convertToDTO(updatedNeed);
    }

    // Convert Entity into Response DTO
    private NeedResponseDTO convertToDTO(Need need) {

        NeedResponseDTO dto = new NeedResponseDTO();

        dto.setId(need.getId());
        dto.setTitle(need.getTitle());
        dto.setCategory(need.getCategory());
        dto.setQuantity(need.getQuantity());
        dto.setUnit(need.getUnit());
        dto.setStatus(need.getStatus());
        dto.setOrganizationId(need.getOrganizationId());
        dto.setDescription(need.getDescription());
        dto.setTargetAmount(need.getTargetAmount());
        dto.setRaisedAmount(need.getRaisedAmount());
        dto.setPriority(need.getPriority());
        dto.setCreatedAt(need.getCreatedAt());
        dto.setUpdatedAt(need.getUpdatedAt());

        return dto;
    }
}
