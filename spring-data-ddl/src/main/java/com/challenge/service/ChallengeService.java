package com.challenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@Service("challengeService")
public class ChallengeService implements ChallengeServiceInterface {

	@Autowired
    private ChallengeRepository challengeRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public Challenge save(Challenge challenge) {
		return challengeRepository.save(challenge);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return this.candidateRepository.findByIdAccelerationIdAndIdUserId(accelerationId, userId).stream()
				.map(candidate -> candidate.getId().getAcceleration().getChallenge())
				.collect(Collectors.toList());



	}

}
