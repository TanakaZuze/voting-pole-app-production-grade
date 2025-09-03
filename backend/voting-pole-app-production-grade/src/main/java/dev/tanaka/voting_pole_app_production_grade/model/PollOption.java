package dev.tanaka.voting_pole_app_production_grade.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PollOption {
    private String voteOption;
    private int voteCount = 0;

    public PollOption() {
    }

    public PollOption(String voteOption, int voteCount) {
        this.voteOption = voteOption;
        this.voteCount = voteCount;
    }

    public String getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String voteOption) {
        this.voteOption = voteOption;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
