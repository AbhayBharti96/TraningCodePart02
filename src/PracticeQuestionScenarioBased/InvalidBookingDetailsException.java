package PracticeQuestionScenarioBased;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class InvalidBookingDetailsException extends Exception {
    public InvalidBookingDetailsException(String message) {
        super(message);
    }
}


class HotelBooking {

    // ---------- Validate User Details ----------
    public void validateUserDetails(int age, String email, String creditCard)
            throws InvalidBookingDetailsException {

        if (age < 18 || age > 100) {
            throw new InvalidBookingDetailsException("Invalid age");
        }

        if (!email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.com$")) {
            throw new InvalidBookingDetailsException("Invalid email");
        }

        if (!creditCard.matches("^\\d{16}$")) {
            throw new InvalidBookingDetailsException("Invalid credit card number");
        }
    }

    // ---------- Validate Booking Details ----------
    public void validateBookingDetails(String hotelName, String roomType,
                                       String checkIn, String checkOut)
            throws InvalidBookingDetailsException {

        List<String> validHotels =
                Arrays.asList("Hilton", "Hyatt", "Marriott", "Taj");

        if (!validHotels.contains(hotelName)) {
            throw new InvalidBookingDetailsException("Invalid hotel name");
        }

        if (!(roomType.equals("Standard") ||
              roomType.equals("Deluxe") ||
              roomType.equals("Suite"))) {
            throw new InvalidBookingDetailsException("Invalid room type");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkInDate;
        LocalDate checkOutDate;

        try {
            checkInDate = LocalDate.parse(checkIn, formatter);
            checkOutDate = LocalDate.parse(checkOut, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidBookingDetailsException("Invalid date format");
        }
        if (!checkOutDate.isAfter(checkInDate)) {
            throw new InvalidBookingDetailsException("Invalid check-out date");
        }
    }

    // ---------- Calculate Booking Cost ----------
    public double calculateBookingCost(String roomType, int numNights,
                                       boolean breakfastIncluded) {

        int ratePerDay = 0;

        switch (roomType) {
            case "Standard":
                ratePerDay = 1000;
                break;
            case "Deluxe":
                ratePerDay = 2000;
                break;
            case "Suite":
                ratePerDay = 3000;
                break;
        }

        double total = ratePerDay;

        if (breakfastIncluded) {
            total += 100 * numNights;
        }

        return total;
    }
}



class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelBooking booking = new HotelBooking();

        try {
            System.out.println("Enter Name");
            String name = sc.nextLine();

            System.out.println("Enter Age");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Email");
            String email = sc.nextLine();

            System.out.println("Enter Credit Card Number");
            String creditCard = sc.nextLine();

            booking.validateUserDetails(age, email, creditCard);

            System.out.println("Enter Hotel Name");
            String hotelName = sc.nextLine();

            System.out.println("Select Room Type");
            String roomType = sc.nextLine();

            System.out.println("Enter Check-in Date (yyyy-MM-dd)");
            String checkIn = sc.nextLine();

            System.out.println("Enter Check-out Date (yyyy-MM-dd)");
            String checkOut = sc.nextLine();

            booking.validateBookingDetails(
                    hotelName, roomType, checkIn, checkOut
            );

            int nights = (int)
                    (LocalDate.parse(checkOut)
                    .toEpochDay() -
                     LocalDate.parse(checkIn).toEpochDay());
            double cost =
                    booking.calculateBookingCost(roomType, nights, false);

            System.out.printf("Total Booking Cost: $%.2f%n", cost);

        } catch (InvalidBookingDetailsException e) {
            System.out.println(e.getMessage());
        }
    }
}

