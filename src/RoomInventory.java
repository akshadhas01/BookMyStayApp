import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    // This stores room type -> available count
    private Map<String, Integer> roomAvailability;

    // Constructor: automatically sets default availability
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();  // fill the map
    }

    // Private method to set default availability
    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    // Get current availability
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Update availability for a specific room type
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}