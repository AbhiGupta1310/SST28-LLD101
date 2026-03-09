// Checkpoint D: Tax policy abstraction.
// New tax rules can be added without touching CafeteriaSystem.
public interface TaxPolicy {
    /** Returns the tax percentage to apply (e.g. 5.0 for 5%). */
    double taxPercent(String customerType);
}
