package fr.uga.l3miage.example.exception.technical;

import fr.uga.l3miage.example.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class ResponseEntityNotFoundException extends RuntimeException {

    public ResponseEntityNotFoundException(String message) {
            super(message);
        }
    public HttpStatus getHttpStatus() {
            return HttpStatus.NOT_FOUND;
        }
    public ErrorCode getErrorCode() {
            return ErrorCode.TEST_IS_NOT_FOUND;
        }


}
