/*
package fr.uga.l3miage.example.exception.technical;

import fr.uga.l3miage.example.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeacherEntityNotFoundException extends RuntimeException {
    
    private String username;

    public TeacherEntityNotFoundException(String message, String username) {
        super(message);
        this.username = username;
    }

    public TeacherEntityNotFoundException(String message, String username, Throwable cause) {
        super(message, cause);
        this.username = username;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.TEST_IS_NOT_FOUND;
    }

}
*/
