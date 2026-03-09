import java.util.*;

// Main is the composition root — wires all pricing components.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        List<RoomPricing> rooms = List.of(
            new SingleRoomPricing(),
            new DoubleRoomPricing(),
            new TripleRoomPricing(),
            new DeluxeRoomPricing()   // fallback — must be last
        );

        List<AddOnPricing> addOns = List.of(
            new MessAddOnPricing(),
            new LaundryAddOnPricing(),
            new GymAddOnPricing()
        );

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(rooms, addOns, new FakeBookingRepo());
        calc.process(req);
    }
}
