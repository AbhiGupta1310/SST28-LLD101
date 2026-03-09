import java.util.List;

// Main is the composition root — wires rules and engine.
// To add a new rule, just add it to the list here.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");

        RuleInput cfg = new RuleInput(); // holds thresholds (minCgr=8.0, minAttendance=75, minCredits=20)

        List<EligibilityRule> rules = List.of(
            new DisciplinaryFlagRule(),
            new CgrRule(cfg.minCgr),
            new AttendanceRule(cfg.minAttendance),
            new CreditsRule(cfg.minCredits)
        );

        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityEngine engine = new EligibilityEngine(rules, new FakeEligibilityStore());
        engine.runAndPrint(s);
    }
}
