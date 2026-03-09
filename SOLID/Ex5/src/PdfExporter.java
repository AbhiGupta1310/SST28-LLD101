import java.nio.charset.StandardCharsets;

// Checkpoint C: PdfExporter honours the base Exporter contract.
// Instead of throwing (which tightened the precondition), it returns an error ExportResult.
// Callers need no try/catch or instanceof — they inspect result.isError.
public class PdfExporter extends Exporter {
    private static final int MAX_CHARS = 20;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req.body != null && req.body.length() > MAX_CHARS) {
            return ExportResult.error("PDF cannot handle content > " + MAX_CHARS + " chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
