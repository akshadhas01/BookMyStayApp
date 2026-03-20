import java.util.*;

public class UseCase9ErrorHandlingValidation {

    static class InvalidBookingException extends Exception {
        public InvalidBookingException(String message) {
            super(message);
        }
    }

    static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() { return guestName; }
        public String getRoomType() { return roomType; }
    }

    static class RoomInventory {
        private Map<String, Integer> rooms = new HashMap<>();

        public RoomInventory() {
            rooms.put("Single", 2);
            rooms.put("Double", 2);
            rooms.put("Suite", 1);
        }

        public boolean isAvailable(String roomType) {
            return rooms.containsKey(roomType) && rooms.get(roomType) > 0;
        }

        public void bookRoom(String roomType) throws InvalidBookingException {
            if (!rooms.containsKey(roomType)) {
                throw new InvalidBookingException("Invalid room type selected.");
            }

            int count = rooms.get(roomType);
            if (count <= 0) {
                throw new InvalidBookingException("No rooms available for selected type.");
            }

            rooms.put(roomType, count - 1);
        }
    }

    static class ReservationValidator {
        public void validate(String guestName, String roomType, RoomInventory inventory)
                throws InvalidBookingException {

            if (guestName == null || guestName.trim().isEmpty()) {
                throw new InvalidBookingException("Guest name cannot be empty.");
            }

            if (!roomType.equals("Single") &&
                    !roomType.equals("Double") &&
                    !roomType.equals("Suite")) {
                throw new InvalidBookingException("Invalid room type selected.");
            }

            if (!inventory.isAvailable(roomType)) {
                throw new InvalidBookingException("Room not available.");
            }
        }
    }

    static class BookingRequestQueue {
        private Queue<Reservation> queue = new LinkedList<>();

        public void addRequest(Reservation r) {
            queue.offer(r);
        }
    }

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String type = scanner.nextLine();

            validator.validate(name, type, inventory);

            Reservation reservation = new Reservation(name, type);
            bookingQueue.addRequest(reservation);
            inventory.bookRoom(type);

            System.out.println("Booking successful for " + name);

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}