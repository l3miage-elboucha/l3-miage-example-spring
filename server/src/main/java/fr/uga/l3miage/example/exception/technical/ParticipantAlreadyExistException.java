package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class ParticipantAlreadyExistException extends RuntimeException{
    public ParticipantAlreadyExistException(String message){
        super(message);
    }
}
