package com.wipro.trs.util;

public class ReservationNotFoundException extends Exception {
    @Override
    public String toString() {
        return "ReservationNotFoundException: Reservation ID Not Found.";
    }
}