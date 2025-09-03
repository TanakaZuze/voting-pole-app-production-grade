package dev.tanaka.voting_pole_app_production_grade.exception;

public class OutOfBoundsPollOption extends RuntimeException {

    public  OutOfBoundsPollOption(String errorMessage) {
        super (errorMessage);
    }
}
