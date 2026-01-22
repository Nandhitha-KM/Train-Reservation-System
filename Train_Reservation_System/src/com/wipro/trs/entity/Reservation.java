package com.wipro.trs.entity;

public class Reservation {

    private String reservationId;
    private String passengerId;
    private String trainId;
    private String travelDate;
    private double fare;

    public Reservation() {}

    public Reservation(String reservationId, String passengerId, String trainId, String travelDate, double fare) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
        this.trainId = trainId;
        this.travelDate = travelDate;
        this.fare = fare;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return reservationId + "  Train: " + trainId + "  Date: " + travelDate + " Fare: "+ fare;
              
    }
}