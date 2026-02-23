public class TripleRoomPricing implements RoomPricing {
    @Override public boolean matches(int roomType) { return roomType == LegacyRoomTypes.TRIPLE; }
    @Override public double monthlyBase() { return 12000.0; }
}
