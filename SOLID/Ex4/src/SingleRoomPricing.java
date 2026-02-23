public class SingleRoomPricing implements RoomPricing {
    @Override public boolean matches(int roomType) { return roomType == LegacyRoomTypes.SINGLE; }
    @Override public double monthlyBase() { return 14000.0; }
}
