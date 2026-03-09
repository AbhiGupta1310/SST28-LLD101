public class DoubleRoomPricing implements RoomPricing {
    @Override public boolean matches(int roomType) { return roomType == LegacyRoomTypes.DOUBLE; }
    @Override public double monthlyBase() { return 15000.0; }
}
