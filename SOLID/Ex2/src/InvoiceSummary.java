import java.util.List;

// Checkpoint B: Data holder for a computed invoice — no logic, just data.
// SRP: only responsibility is to carry invoice result fields.
public class InvoiceSummary {
    public final String invId;
    public final List<String> lineDescriptions; // e.g. "- Veg Thali x2 = 160.00"
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public InvoiceSummary(String invId,
                          List<String> lineDescriptions,
                          double subtotal,
                          double taxPct,
                          double tax,
                          double discount,
                          double total) {
        this.invId            = invId;
        this.lineDescriptions = lineDescriptions;
        this.subtotal         = subtotal;
        this.taxPct           = taxPct;
        this.tax              = tax;
        this.discount         = discount;
        this.total            = total;
    }
}
