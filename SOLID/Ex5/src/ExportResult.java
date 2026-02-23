// Checkpoint B: ExportResult carries both successful and error outcomes.
// Callers can inspect isError without needing try/catch or instanceof.
public class ExportResult {
    public final String  contentType;
    public final byte[]  bytes;
    public final boolean isError;
    public final String  errorMessage;

    /** Success result. */
    public ExportResult(String contentType, byte[] bytes) {
        this.contentType  = contentType;
        this.bytes        = bytes;
        this.isError      = false;
        this.errorMessage = null;
    }

    /** Error result — no bytes produced. */
    public static ExportResult error(String message) {
        return new ExportResult(message);
    }

    // Private constructor for error path
    private ExportResult(String errorMessage) {
        this.contentType  = "";
        this.bytes        = new byte[0];
        this.isError      = true;
        this.errorMessage = errorMessage;
    }
}
