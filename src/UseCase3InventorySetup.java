public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status");

        // Create rooms
        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display room details + availability
        System.out.println("\nSingle Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single Room"));

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double Room"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite Room"));
    }
}