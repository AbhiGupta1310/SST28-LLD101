import java.util.Optional;

// Rule: student CGR must meet the configured minimum.
public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) { this.minCgr = minCgr; }

    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.cgr < minCgr)
            return Optional.of("CGR below " + minCgr);
        return Optional.empty();
    }
}
