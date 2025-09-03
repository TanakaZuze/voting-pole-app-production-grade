package dev.tanaka.voting_pole_app_production_grade.service;

import dev.tanaka.voting_pole_app_production_grade.exception.OutOfBoundsPollOption;
import dev.tanaka.voting_pole_app_production_grade.exception.PollNotFoundException;
import dev.tanaka.voting_pole_app_production_grade.model.PollOption;
import dev.tanaka.voting_pole_app_production_grade.model.Poll;
import dev.tanaka.voting_pole_app_production_grade.repository.PollRepository;
import dev.tanaka.voting_pole_app_production_grade.request.Vote;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PollService implements PollServiceI{
//    IoC
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    @Override
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Override
    public Poll getById(Long id) {
            return pollRepository.findById(id)
                    .orElseThrow(() -> new PollNotFoundException(id+" not found"));
    }

    @Override
    public void voteOnPollOption(Long pollId, int pollOptionIndex) {
//        obtaing poll object
        Poll selectedPoll = pollRepository.findById(pollId)
                .orElseThrow(() -> new PollNotFoundException(pollId+" not found"));

//        extract all poll options from selected poll

        List<PollOption> pollOptions =selectedPoll.getOptions();

//        throw error if option index is out of bounds which
//        should be impossible from UI unless triggered from server
        if(pollOptionIndex <=0 || pollOptionIndex > pollOptions.size()){
            throw new OutOfBoundsPollOption(pollId+" not found");
        }
//        extract select vote
        PollOption selectedPollOption = pollOptions.get(pollOptionIndex);

//        increment the vote for the selected option
        selectedPollOption.setVoteCount(selectedPollOption.getVoteCount()+1);


        pollRepository.save(selectedPoll);

    }


}
