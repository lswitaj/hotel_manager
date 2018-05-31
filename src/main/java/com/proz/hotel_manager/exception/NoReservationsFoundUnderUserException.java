package com.proz.hotel_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No reservations found under this user")
public class NoReservationsFoundUnderUserException extends RuntimeException{

   private static final long serialVersionUID = 3935230281455340039L;
}
