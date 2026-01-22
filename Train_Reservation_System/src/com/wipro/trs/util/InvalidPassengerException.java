package com.wipro.trs.util;

public class InvalidPassengerException extends Exception {
    @Override
    public String toString() {
        return "InvalidPassengerException: Passenger does'nt Exist.";
    }
}