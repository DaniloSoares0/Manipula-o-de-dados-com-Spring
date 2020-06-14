package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@Service("accelerationService")
public class AccelerationService implements AccelerationServiceInterface {

	@Autowired
    private AccelerationRepository accelarationRepository;
	
	@Override
	public Acceleration save(Acceleration aceleration) {
		return this.accelarationRepository.save(aceleration);
	}

	@Override
	public Optional<Acceleration> findById(Long id) {
		return accelarationRepository.findById(id);
	}

	@Override
	public List<Acceleration> findByCompanyId(Long companyId) {
        return this.accelarationRepository.findByCandidatesIdCompanyId(companyId);
	}

	@Override
	public Optional<Acceleration> findByName(String name) {
		return accelarationRepository.findByName(name);
	}

}
