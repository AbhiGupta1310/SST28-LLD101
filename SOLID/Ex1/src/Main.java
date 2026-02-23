public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");

        FakeDb db = new FakeDb();

        // Wire up collaborators — Main is the composition root.
        OnboardingService svc = new OnboardingService(
            new RawInputParser(),
            new StudentValidator(),
            db,                        // FakeDb implements StudentRepository
            new OnboardingPrinter()
        );

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
