import entites.Reservation;

import java.awt.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner tc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int roomNumber = tc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(tc.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(tc.next());

        if (!checkout.after(checkin)) {
            System.out.println("Error in reservation: Check-out date must be before Check-in date ");
        }
        else{
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: "+reservation);


            System.out.println("UpDate reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(tc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(tc.next());

            String error = reservation.upDateDates(checkin, checkout);
            if (error != null) {
                System.out.println("Error in reservation: "+error);
            }
            else {
                System.out.println("Reservation: "+reservation);
            }
        }

        tc.close();
    }
}