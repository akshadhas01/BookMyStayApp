import java.util.Map;

public class UseCase4RoomSearch {

    // Method to search available rooms
    public void searchAvailableRooms(RoomInventory inventory,
                                     Room singleRoom,
                                     Room doubleRoom,
                                     Room suiteRoom) {

        // Get availability from inventory (read-only)
        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms:");

        // Check Single Room
        if (availability.get("Single Room") != null && availability.get("Single Room") > 0) {
            System.out.println("\nSingle Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Single Room"));
        }

        // Check Double Room
        if (availability.get("Double Room") != null && availability.get("Double Room") > 0) {
            System.out.println("\nDouble Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Double Room"));
        }

        // Check Suite Room
        if (availability.get("Suite Room") != null && availability.get("Suite Room") > 0) {
            System.out.println("\nSuite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Suite Room"));
        }
    }

    // Main method to test UC4
    public static void main(String[] args) {
        // Create room objects
        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create UC4 object
        UseCase4RoomSearch uc4 = new UseCase4RoomSearch();

        // Search available rooms
        uc4.searchAvailableRooms(inventory, single, doubleRoom, suite);
    }
}