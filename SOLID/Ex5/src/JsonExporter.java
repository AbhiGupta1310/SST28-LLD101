import java.nio.charset.StandardCharsets;

// Checkpoint C: JsonExporter honours the base contract.
// Removed the inconsistent "if req == null return empty" — base contract
// does not promise to handle null requests, so all subtypes treat null
// the same way (let it fail uniformly if ever passed null).
public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
