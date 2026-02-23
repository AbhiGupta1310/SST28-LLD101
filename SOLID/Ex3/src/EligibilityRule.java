import java.util.Optional;

// OCP: each rule is a closed unit; new rules extend without editing EligibilityEngine.
public interface EligibilityRule {
    /**
     * Returns a non-empty Optional with the failure reason if the student
     * fails this rule, or Optional.empty() if they pass.
     */
    Optional<String> check(StudentProfile s);
}
