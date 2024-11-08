// FacilityRepository.java
package com.arenaconnect.backend.repositories;

import com.arenaconnect.backend.models.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // Additional query methods (if needed) can be defined here
}
