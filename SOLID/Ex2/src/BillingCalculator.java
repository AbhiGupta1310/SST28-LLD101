import java.util.*;

// Checkpoint B: Single responsibility — compute all billing figures from an order.
// Returns an InvoiceSummary; knows nothing about formatting or persistence.
public class BillingCalculator {
    private final TaxPolicy      taxPolicy;
    private final DiscountPolicy discountPolicy;

    public BillingCalculator(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.taxPolicy      = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public InvoiceSummary compute(String invId,
                                  String customerType,
                                  List<OrderLine> lines,
                                  Map<String, MenuItem> menu) {
        List<String> descs = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            descs.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }

        double taxPct  = taxPolicy.taxPercent(customerType);
        double tax     = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());
        double total   = subtotal + tax - discount;

        return new InvoiceSummary(invId, descs, subtotal, taxPct, tax, discount, total);
    }
}
