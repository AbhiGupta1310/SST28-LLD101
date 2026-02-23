import java.util.Optional;

// Rule: student attendance percentage must meet the configured minimum.
public class AttendanceRule implements EligibilityRule {
    private final int minAttendance;

    public AttendanceRule(int minAttendance) { this.minAttendance = minAttendance; }

    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.attendancePct < minAttendance)
            return Optional.of("attendance below " + minAttendance);
        return Optional.empty();
    }
}
