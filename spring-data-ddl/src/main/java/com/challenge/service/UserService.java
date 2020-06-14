package com.challenge.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

@Service("userService")
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private CompanyRepository  companyRepository;
	

	
	@Override
	public User save(User user) {
	
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return this.candidateRepository.findByIdAccelerationName(name)
				.stream()
				.map(candidate -> candidate.getId()
			    .getUser())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<User> findByCompanyId(Long companyId) {
		return this.candidateRepository.findByIdCompanyId(companyId).stream()
	            .map(candidate -> candidate.getId().getUser())
	            .collect(Collectors.toList());
	}
	
	

}
