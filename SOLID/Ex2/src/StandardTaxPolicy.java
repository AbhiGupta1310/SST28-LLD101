// Checkpoint D: Concrete tax policy — wraps the original TaxRules logic.
// SRP: sole responsibility is determining the tax rate per customer type.
public class StandardTaxPolicy implements TaxPolicy {
    @Override
    public double taxPercent(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return 5.0;
        if ("staff".equalsIgnoreCase(customerType))   return 2.0;
        return 8.0;
    }
}
