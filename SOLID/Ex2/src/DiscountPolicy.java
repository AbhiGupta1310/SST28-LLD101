// import java.util.List;

// Checkpoint D: Discount policy abstraction.
// New discount rules can be added without touching CafeteriaSystem.
public interface DiscountPolicy {
    /** Returns the flat discount amount to subtract from the total. */
    double discountAmount(String customerType, double subtotal, int distinctLines);
}
