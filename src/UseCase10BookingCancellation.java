import java.util.*;

public class UseCase10BookingCancellation {

    // Stack for rollback
    private static Stack<String> releasedRoomIds = new Stack<>();

    // Reservation map
    private static Map<String, String> reservationRoomTypeMap = new HashMap<>();

    // Inventory map
    private static Map<String, Integer> roomInventory = new HashMap<>();

    // Initialize inventory
    public static void initializeInventory() {
        roomInventory.put("Single", 5);
        roomInventory.put("Double", 3);
    }

    // Register booking
    public static void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking
    public static void cancelBooking(String reservationId) {

        // Validation
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Error: Reservation not found or already cancelled.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Push to stack
        releasedRoomIds.push(reservationId);

        // Restore inventory
        int count = roomInventory.getOrDefault(roomType, 0);
        roomInventory.put(roomType, count + 1);

        // Remove booking
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public static void showRollbackHistory() {
        System.out.println("Rollback History (Most Recent First):");

        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }

    // Show inventory
    public static void displayInventory() {
        for (String type : roomInventory.keySet()) {
            System.out.println("Updated " + type + " Room Availability: " + roomInventory.get(type));
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Step 1: Initialize inventory
        initializeInventory();

        // Step 2: Register booking
        registerBooking("Single-1", "Single");

        // Step 3: Cancel booking
        cancelBooking("Single-1");

        // Step 4: Show rollback
        showRollbackHistory();

        // Step 5: Show inventory
        displayInventory();
    }
}