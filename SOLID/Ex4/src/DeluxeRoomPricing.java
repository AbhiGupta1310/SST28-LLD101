// Default: DELUXE or any unrecognized type.
public class DeluxeRoomPricing implements RoomPricing {
    @Override public boolean matches(int roomType) { return true; } // fallback
    @Override public double monthlyBase() { return 16000.0; }
}
