// OCP: each room type is a closed unit behind this abstraction.
// New room type = new implementing class, no edits to HostelFeeCalculator.
public interface RoomPricing {
    boolean matches(int roomType);
    double monthlyBase();
}
