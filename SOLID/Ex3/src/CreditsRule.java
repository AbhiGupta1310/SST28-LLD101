import java.util.Optional;

// Rule: student must have earned enough credits.
public class CreditsRule implements EligibilityRule {
    private final int minCredits;

    public CreditsRule(int minCredits) { this.minCredits = minCredits; }

    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.earnedCredits < minCredits)
            return Optional.of("credits below " + minCredits);
        return Optional.empty();
    }
}
