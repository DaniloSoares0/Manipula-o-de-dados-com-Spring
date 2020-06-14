package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

	Optional<Submission> findFirstByIdChallengeIdOrderByScoreDesc(Long challengeId);
	
    List<Submission> findByIdChallengeId(Long challengeId);

	
	
}
