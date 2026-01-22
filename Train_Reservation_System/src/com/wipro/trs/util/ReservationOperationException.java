package com.wipro.trs.util;

public class ReservationOperationException extends Exception {
    @Override
    public String toString() {
        return "ReservationOperationException: Invalid Reservation Operation.";
    }
}