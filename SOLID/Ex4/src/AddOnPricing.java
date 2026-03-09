// OCP: each add-on is a closed unit behind this abstraction.
// New add-on = new implementing class, no edits to HostelFeeCalculator.
public interface AddOnPricing {
    boolean matches(AddOn addOn);
    double monthlyExtra();
}
