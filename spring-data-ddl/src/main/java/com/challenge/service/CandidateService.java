package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

@Service("candidateService")
public class CandidateService implements CandidateServiceInterface {

	@Autowired
	private CandidateRepository candidateRepository;
	
	
	@Override
	public Candidate save(Candidate candidate) {
		return this.candidateRepository.save(candidate);
	}


	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return this.candidateRepository.findById(id);
	}


	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		return this.candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
	}


	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		
		return this.candidateRepository.findByIdCompanyId(companyId);
	}


	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		
		return  this.candidateRepository.findByIdAccelerationId(accelerationId);
	}

	

}
