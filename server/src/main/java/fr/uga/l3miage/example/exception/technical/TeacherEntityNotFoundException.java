package fr.uga.l3miage.example.exception.technical;

import fr.uga.l3miage.example.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeacherEntityNotFoundException extends RuntimeException {
    
    private Long id;

    public TeacherEntityNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public TeacherEntityNotFoundException(String message,  Long id, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.TEST_IS_NOT_FOUND;
    }

}
