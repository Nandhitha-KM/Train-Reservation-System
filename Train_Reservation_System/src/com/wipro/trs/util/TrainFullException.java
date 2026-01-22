package com.wipro.trs.util;

public class TrainFullException extends Exception {
    @Override
    public String toString() {
        return "TrainFullException: No Seats Available.";
    }
}