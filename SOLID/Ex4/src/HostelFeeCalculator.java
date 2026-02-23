import java.util.*;

// OCP-compliant: HostelFeeCalculator is closed for modification.
// New room type or add-on = new class + wire in Main. No edits here.
public class HostelFeeCalculator {
    private final List<RoomPricing>   roomPricings;
    private final List<AddOnPricing>  addOnPricings;
    private final FakeBookingRepo     repo;

    public HostelFeeCalculator(List<RoomPricing> roomPricings,
                               List<AddOnPricing> addOnPricings,
                               FakeBookingRepo repo) {
        this.roomPricings  = roomPricings;
        this.addOnPricings = addOnPricings;
        this.repo          = repo;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        // Find room base price — loop replaces the switch-case.
        double base = roomPricings.stream()
            .filter(rp -> rp.matches(req.roomType))
            .findFirst()
            .map(RoomPricing::monthlyBase)
            .orElse(0.0);

        // Sum add-on extras — loop replaces the if-chain.
        double addOns = 0.0;
        for (AddOn a : req.addOns) {
            for (AddOnPricing ap : addOnPricings) {
                if (ap.matches(a)) {
                    addOns += ap.monthlyExtra();
                    break;
                }
            }
        }

        return new Money(base + addOns);
    }
}
