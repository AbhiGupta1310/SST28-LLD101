import java.util.List;

// Refactored per SRP: OnboardingService only *orchestrates* the workflow.
// It no longer parses, validates, persists, or prints directly.
public class OnboardingService {
    private final RawInputParser    parser;
    private final StudentValidator  validator;
    private final StudentRepository repository;
    private final OnboardingPrinter printer;

    public OnboardingService(RawInputParser parser,
                             StudentValidator validator,
                             StudentRepository repository,
                             OnboardingPrinter printer) {
        this.parser     = parser;
        this.validator  = validator;
        this.repository = repository;
        this.printer    = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        ParsedInput input = parser.parse(raw);

        List<String> errors = validator.validate(input);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id  = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(id, input.name, input.email, input.phone, input.program);

        repository.save(rec);

        printer.printSuccess(rec, repository.count());
    }
}
