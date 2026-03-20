import java.util.*;

public class UseCase8BookingHistoryReport {

    // Reservation class
    static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    // Booking History class
    static class BookingHistory {
        private List<Reservation> history;

        public BookingHistory() {
            history = new ArrayList<>();
        }

        public void addReservation(Reservation reservation) {
            history.add(reservation);
        }

        public List<Reservation> getAllReservations() {
            return history;
        }
    }

    // Report Service class
    static class BookingReportService {
        public void generateReport(List<Reservation> reservations) {
            System.out.println("Booking History Report");

            for (Reservation r : reservations) {
                System.out.println("Guest: " + r.getGuestName()
                        + ", Room Type: " + r.getRoomType());
            }
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");

        // Create booking history
        BookingHistory bookingHistory = new BookingHistory();

        // Add confirmed bookings
        bookingHistory.addReservation(new Reservation("Abhi", "Single"));
        bookingHistory.addReservation(new Reservation("Subha", "Double"));
        bookingHistory.addReservation(new Reservation("Vanmathi", "Suite"));

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(bookingHistory.getAllReservations());
    }
}