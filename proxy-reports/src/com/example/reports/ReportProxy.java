package com.example.reports;

/**
 * Proxy in the Proxy pattern.
 *
 * Responsibilities (all three requirements satisfied here):
 * 1. ACCESS CONTROL  — checks that the user's role permits seeing this report.
 * 2. LAZY LOADING    — creates the RealReport only when display() is first called
 *                      with an authorised user; never during construction.
 * 3. CACHING         — keeps the same RealReport instance for repeated views
 *                      through this proxy (no re-creation or disk re-read).
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final AccessControl accessControl = new AccessControl();

    // Null until a permitted user triggers the first load (lazy + cached)
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        // NOTE: RealReport is NOT created here — that is the whole point of lazy loading.
    }

    @Override
    public void display(User user) {
        // 1. Access control check — happens before any loading
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("[proxy] ACCESS DENIED: "
                    + user.getName() + " (" + user.getRole() + ")"
                    + " cannot access report " + reportId
                    + " (requires " + classification + ")");
            return;
        }

        // 2. Lazy load + 3. Cache: create RealReport only on the first authorised call
        if (realReport == null) {
            System.out.println("[proxy] First access — creating RealReport for " + reportId);
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] Cache hit — reusing RealReport for " + reportId);
        }

        // Delegate actual display to the real subject
        realReport.display(user);
    }
}
