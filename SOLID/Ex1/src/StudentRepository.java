// Checkpoint D: Persistence interface.
// OnboardingService depends on this abstraction, not on FakeDb directly.
public interface StudentRepository {
    void save(StudentRecord record);
    int count();
}
