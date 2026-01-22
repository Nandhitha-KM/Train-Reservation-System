package com.wipro.trs.service;

import java.util.ArrayList;
import java.util.UUID;

import com.wipro.trs.entity.*;
import com.wipro.trs.util.*;

public class ReservationService {

    private ArrayList<Passenger> passengers;
    private ArrayList<Train> trains;
    private ArrayList<Reservation> reservations;

    public ReservationService(ArrayList<Passenger> passengers, ArrayList<Train> trains,  ArrayList<Reservation> reservations) {
        this.passengers = passengers;
        this.trains = trains;
        this.reservations = reservations;
    }

    public boolean validatePassenger(String passengerId)
            throws InvalidPassengerException {
        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(passengerId)) {
                return true;
            }
        }
        throw new InvalidPassengerException();
    }

    public Train findTrain(String trainId)
            throws ReservationOperationException {
        for (Train t : trains) {
            if (t.getTrainId().equals(trainId)) {
                return t;
            }
        }
        throw new ReservationOperationException();
    }

    public Reservation bookTicket(String passengerId, String trainId, String date)
            throws Exception {

        validatePassenger(passengerId);
        Train train = findTrain(trainId);

        if (train.getAvailableSeats() <= 0) {
            throw new TrainFullException();
        }

        double fare = calculateFare(train);
        String reservationId = "R" + UUID.randomUUID().toString().substring(0, 5);

        Reservation reservation = new Reservation(reservationId, passengerId, trainId, date, fare);
        reservations.add(reservation);
        train.setAvailableSeats(train.getAvailableSeats() - 1);

        return reservation;
    }

    public double calculateFare(Train train) {
        return train.getBaseFare();
    }

    public void cancelReservation(String reservationId)
            throws ReservationNotFoundException {

        Reservation target = null;

        for (Reservation r : reservations) {
            if (r.getReservationId().equals(reservationId)) {
                target = r;
                break;
            }
        }

        if (target == null) {
            throw new ReservationNotFoundException();
        }

        for (Train t : trains) {
            if (t.getTrainId().equals(target.getTrainId())) {
                t.setAvailableSeats(t.getAvailableSeats() + 1);
                break;
            }
        }

        reservations.remove(target);
    }

    public void printPassengerReservations(String passengerId) {
        for (Reservation r : reservations) {
            if (r.getPassengerId().equals(passengerId)) {
                System.out.println(r);
            }
        }
    }
}