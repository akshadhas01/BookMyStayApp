import java.util.*;

/**
 * UC7: Add-On Service Selection
 */
public class UseCase7AddOnServiceSelection {

    /** --- Classes defined inside the same file --- */

    // Add-on service
    static class AddOnService {
        private String serviceName;
        private double cost;

        public AddOnService(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public String getServiceName() { return serviceName; }
        public double getCost() { return cost; }
    }

    // Manager for add-on services attached to reservations
    static class AddOnServiceManager {
        private Map<String, List<AddOnService>> servicesByReservation;

        public AddOnServiceManager() {
            servicesByReservation = new HashMap<>();
        }

        // Attach a service to a reservation
        public void addService(String reservationId, AddOnService service) {
            servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
            servicesByReservation.get(reservationId).add(service);
        }

        // Calculate total add-on cost for a reservation
        public double getTotalAddOnCost(String reservationId) {
            List<AddOnService> list = servicesByReservation.getOrDefault(reservationId, new ArrayList<>());
            double total = 0;
            for (AddOnService s : list) {
                total += s.getCost();
            }
            return total;
        }

        // Display attached services for a reservation
        public void displayServices(String reservationId) {
            List<AddOnService> list = servicesByReservation.getOrDefault(reservationId, new ArrayList<>());
            System.out.println("Services for Reservation " + reservationId + ":");
            for (AddOnService s : list) {
                System.out.println("- " + s.getServiceName() + ": " + s.getCost());
            }
        }
    }

    /** --- Main method --- */
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Sample reservation IDs (assume these came from UC6 allocation)
        String res1 = "Single-1";
        String res2 = "Double-1";

        // Sample add-on services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 1000.0);

        // Attach services to reservations
        serviceManager.addService(res1, breakfast);
        serviceManager.addService(res1, spa); // multiple services allowed
        serviceManager.addService(res2, breakfast);

        // Display total add-on cost for Single-1
        System.out.println("Reservation ID: " + res1);
        serviceManager.displayServices(res1);
        System.out.println("Total Add-On Cost: " + serviceManager.getTotalAddOnCost(res1));

        // Display total add-on cost for Double-1
        System.out.println("\nReservation ID: " + res2);
        serviceManager.displayServices(res2);
        System.out.println("Total Add-On Cost: " + serviceManager.getTotalAddOnCost(res2));
    }
}