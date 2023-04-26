package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class MiahootAlreadyExistException extends Exception{

    private final Long id;

    public MiahootAlreadyExistException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public MiahootAlreadyExistException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

}
