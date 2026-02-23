import java.util.List;
import java.util.Optional;

// OCP-compliant: EligibilityEngine is closed for modification.
// To add a new rule, create a new EligibilityRule class and wire it in Main.
public class EligibilityEngine {
    private final List<EligibilityRule>  rules;
    private final FakeEligibilityStore   store;

    public EligibilityEngine(List<EligibilityRule> rules, FakeEligibilityStore store) {
        this.rules = rules;
        this.store = store;
    }

    public void runAndPrint(StudentProfile s) {
        EligibilityEngineResult r = evaluate(s);
        new ReportPrinter().print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        // Iterate rules in order; stop at first failure (preserves original behavior).
        for (EligibilityRule rule : rules) {
            Optional<String> reason = rule.check(s);
            if (reason.isPresent()) {
                return new EligibilityEngineResult("NOT_ELIGIBLE", List.of(reason.get()));
            }
        }
        return new EligibilityEngineResult("ELIGIBLE", List.of());
    }
}
