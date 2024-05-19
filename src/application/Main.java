package application;

import model.entites.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner tc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int roomNumber = tc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(tc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(tc.next());

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("UpDate reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(tc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(tc.next());

            reservation.upDateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format! ");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error ! ");
        }
        tc.close();
    }


    }
