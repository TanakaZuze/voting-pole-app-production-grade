package dev.tanaka.voting_pole_app_production_grade.exception;

public class PollNotFoundException extends RuntimeException{
    public PollNotFoundException(String message){
        super(message);
    }
}
