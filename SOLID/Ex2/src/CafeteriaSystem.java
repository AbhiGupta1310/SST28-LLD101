import java.util.*;

// Refactored per SRP: CafeteriaSystem is a pure orchestrator.
// It no longer encodes tax/discount rules, formats strings, or knows FileStore.
public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final BillingCalculator     calculator;
    private final InvoiceFormatter      formatter;
    private final InvoiceStore          store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(BillingCalculator calculator,
                           InvoiceFormatter formatter,
                           InvoiceStore store) {
        this.calculator = calculator;
        this.formatter  = formatter;
        this.store      = store;
    }

    public void addToMenu(MenuItem item) { menu.put(item.id, item); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        InvoiceSummary summary  = calculator.compute(invId, customerType, lines, menu);
        String         printable = formatter.format(summary);

        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
