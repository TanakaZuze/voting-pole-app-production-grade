package dev.tanaka.voting_pole_app_production_grade.service;

import dev.tanaka.voting_pole_app_production_grade.model.Poll;

import java.util.List;

public interface PollServiceI {
//    create,get all polls and get by id abstrackt methods
    Poll createPoll(Poll poll);
    List<Poll> getAllPolls();
    Poll getById(Long id);
    void voteOnPollOption(Long pollId,int pollOptionIndex);
    void deletePoll(Long pollId);
}
