package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service("submissionService")
public class SubmissionService implements SubmissionServiceInterface {

	@Autowired
	private SubmissionRepository submissionRepository;

	@Autowired
	private AccelerationRepository accelerationRepository;

	@Override
	public Submission save(Submission submission) {
		return submissionRepository.save(submission);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		Optional<Submission> submissaoMaiorPontuacao = this.submissionRepository
				.findFirstByIdChallengeIdOrderByScoreDesc(challengeId);

		BigDecimal higherScore = submissaoMaiorPontuacao.isPresent() ? BigDecimal.valueOf(submissaoMaiorPontuacao.get().getScore()) : BigDecimal.ZERO;

		return higherScore;
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {

		return this.accelerationRepository.findById(accelerationId).get().getChallenge().getSubmissions().stream()
				.filter(submission -> submission.getId().getChallenge().getId().equals(challengeId))
				.collect(Collectors.toList());

	}

}
