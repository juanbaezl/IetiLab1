package co.edu.escuelaing.exception;

import javax.ws.rs.InternalServerErrorException;

import org.springframework.http.HttpStatus;

import co.edu.escuelaing.error.ServerErrorResponseDto;

import co.edu.escuelaing.error.ErrorCodeEnum;

public class InvalidCredentialsException extends InternalServerErrorException {
    public InvalidCredentialsException() {

        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND)
                .getMessage());

    }
}
