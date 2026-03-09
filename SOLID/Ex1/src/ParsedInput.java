// Checkpoint B: Simple data holder produced by RawInputParser.
// SRP: this class is only responsible for holding parsed field values.
public class ParsedInput {
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public ParsedInput(String name, String email, String phone, String program) {
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.program = program;
    }
}
