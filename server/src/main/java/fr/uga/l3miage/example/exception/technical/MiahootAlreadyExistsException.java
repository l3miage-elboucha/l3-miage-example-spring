package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

@Getter
public class MiahootAlreadyExistsException extends Exception{

    private final Long id;

    public MiahootAlreadyExistsException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public MiahootAlreadyExistsException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

}
