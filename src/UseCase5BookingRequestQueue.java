import java.util.LinkedList;
import java.util.Queue;

// Reservation class
class Reservation {
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

// BookingRequestQueue class
class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next booking request
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if pending requests exist
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

// UC5 driver
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process queued booking requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + next.getGuestName() +
                    ", Room Type: " + next.getRoomType());
        }
    }
}