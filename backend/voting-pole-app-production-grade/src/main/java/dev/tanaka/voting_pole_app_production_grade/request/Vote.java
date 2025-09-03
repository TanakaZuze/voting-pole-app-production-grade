package dev.tanaka.voting_pole_app_production_grade.request;

public class Vote {
    private Long pollId;
    private int pollOptionIndex;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public int getPollOptionIndex() {
        return pollOptionIndex;
    }

    public void setPollOptionIndex(int pollOptionIndex) {
        this.pollOptionIndex = pollOptionIndex;
    }
}
