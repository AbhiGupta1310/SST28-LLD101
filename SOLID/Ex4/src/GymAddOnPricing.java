public class GymAddOnPricing implements AddOnPricing {
    @Override public boolean matches(AddOn addOn) { return addOn == AddOn.GYM; }
    @Override public double monthlyExtra() { return 300.0; }
}
