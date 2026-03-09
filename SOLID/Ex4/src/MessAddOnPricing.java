public class MessAddOnPricing implements AddOnPricing {
    @Override public boolean matches(AddOn addOn) { return addOn == AddOn.MESS; }
    @Override public double monthlyExtra() { return 1000.0; }
}
