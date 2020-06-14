package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId>{

	  List<Candidate> findByIdAccelerationName(String name);
	  
	  List<Candidate> findByIdCompanyName(String name);	
	  
	  List<Candidate> findByIdCompanyId(Long id);
	  
	  List<Candidate> findByIdAccelerationId(Long accelerationId);
	  
	  List<Candidate>  findByIdAccelerationIdAndIdUserId(Long accelerationId, Long userId);
	  
	  Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);
	  
}
