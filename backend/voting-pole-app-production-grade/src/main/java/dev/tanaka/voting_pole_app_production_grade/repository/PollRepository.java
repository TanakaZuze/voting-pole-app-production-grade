package dev.tanaka.voting_pole_app_production_grade.repository;

import dev.tanaka.voting_pole_app_production_grade.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
}
