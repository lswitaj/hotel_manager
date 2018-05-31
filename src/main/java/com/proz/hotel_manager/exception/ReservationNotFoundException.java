package com.proz.hotel_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No reservations found under this user")
public class ReservationNotFoundException extends RuntimeException{
   
   private static final long serialVersionUID = -694354952032299587L;
   
   private String reservationId;

   public ReservationNotFoundException(String reservationId) {
      this.reservationId = reservationId;
   }
   
   public String getReservationId() {
      return reservationId;
   }

}
