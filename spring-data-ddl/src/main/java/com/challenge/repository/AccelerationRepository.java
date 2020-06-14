package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{

    Optional<Acceleration> findByName(String name);

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);
	
}
