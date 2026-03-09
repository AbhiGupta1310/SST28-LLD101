import java.util.Optional;

// Rule: student must have no disciplinary flag.
public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE)
            return Optional.of("disciplinary flag present");
        return Optional.empty();
    }
}
