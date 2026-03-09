public class LaundryAddOnPricing implements AddOnPricing {
    @Override public boolean matches(AddOn addOn) { return addOn == AddOn.LAUNDRY; }
    @Override public double monthlyExtra() { return 500.0; }
}
