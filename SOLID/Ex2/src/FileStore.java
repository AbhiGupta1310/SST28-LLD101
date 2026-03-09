import java.util.*;

// Checkpoint D: FileStore now implements InvoiceStore so CafeteriaSystem
// depends only on the interface, not on this concrete class.
public class FileStore implements InvoiceStore {
    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(String name, String content) { files.put(name, content); }

    @Override
    public int countLines(String name) {
        String c = files.getOrDefault(name, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}
