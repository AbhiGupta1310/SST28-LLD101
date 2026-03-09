// Checkpoint D: Persistence abstraction for invoices.
// CafeteriaSystem depends on this interface, not on FileStore directly.
public interface InvoiceStore {
    void save(String invId, String content);
    int countLines(String invId);
}
