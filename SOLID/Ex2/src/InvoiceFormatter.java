// Checkpoint C: InvoiceFormatter now has real formatting responsibility.
// SRP: sole job is converting an InvoiceSummary into a printable string.
public class InvoiceFormatter {
    public String format(InvoiceSummary s) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(s.invId).append("\n");
        for (String line : s.lineDescriptions) {
            sb.append(line).append("\n");
        }
        sb.append(String.format("Subtotal: %.2f%n",         s.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f%n",      s.taxPct, s.tax));
        sb.append(String.format("Discount: -%.2f%n",        s.discount));
        sb.append(String.format("TOTAL: %.2f%n",            s.total));
        return sb.toString();
    }
}
