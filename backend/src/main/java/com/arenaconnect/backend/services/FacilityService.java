// FacilityService.java (Service)
package com.arenaconnect.backend.services;

import com.arenaconnect.backend.models.Facility;
import com.arenaconnect.backend.repositories.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    // Create a new facility
    public Facility createFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    // Get all facilities
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    // Get a facility by ID
    public Optional<Facility> getFacilityById(Long id) {
        return facilityRepository.findById(id);
    }

    // Update an existing facility
    public Facility updateFacility(Long id, Facility facilityDetails) {
        return facilityRepository.findById(id)
                .map(facility -> {
                    facility.setName(facilityDetails.getName());
                    facility.setLocation(facilityDetails.getLocation());
                    facility.setType(facilityDetails.getType());
                    facility.setCapacity(facilityDetails.getCapacity());
                    return facilityRepository.save(facility);
                })
                .orElseThrow(() -> new RuntimeException("Facility not found with id " + id));
    }

    // Delete a facility by ID
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}
