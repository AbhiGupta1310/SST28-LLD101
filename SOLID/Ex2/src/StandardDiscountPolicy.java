// Checkpoint D: Concrete discount policy — preserves the original DiscountRules logic.
// SRP: sole responsibility is determining the discount amount.
public class StandardDiscountPolicy implements DiscountPolicy {
    @Override
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        if ("student".equalsIgnoreCase(customerType)) {
            if (subtotal >= 180.0) return 10.0;
            return 0.0;
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            if (distinctLines >= 3) return 15.0;
            return 5.0;
        }
        return 0.0;
    }
}
