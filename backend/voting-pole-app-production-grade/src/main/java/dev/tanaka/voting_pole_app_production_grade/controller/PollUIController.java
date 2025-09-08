package dev.tanaka.voting_pole_app_production_grade.controller;

import dev.tanaka.voting_pole_app_production_grade.model.Poll;
import dev.tanaka.voting_pole_app_production_grade.request.Vote;
import dev.tanaka.voting_pole_app_production_grade.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PollUIController {
//    create poll,get al polls and get poll by id

//    IoC
    private final PollService pollService;

    public PollUIController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/create-poll")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping("/get-all-polls")
    @ResponseStatus(code =HttpStatus.OK)
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/get-poll-by-id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Poll getPollById(@PathVariable Long id){
        return pollService.getById(id);
    }

    @PostMapping("/vote")
    @ResponseStatus(code = HttpStatus.OK)
    public void voteOnPollOption(@RequestBody Vote vote){
        pollService.voteOnPollOption(vote.getPollId(),vote.getPollOptionIndex());
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePollById(@PathVariable Long id  ){
        pollService.deletePoll(id);
    }
}
