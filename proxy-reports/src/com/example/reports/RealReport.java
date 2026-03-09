package com.example.reports;

/**
 * RealSubject in the Proxy pattern.
 *
 * Responsibilities:
 * - Performs the expensive disk load exactly once (on first display).
 * - Displays the report content to the user.
 *
 * This class should NOT be used directly by clients; clients should
 * always go through ReportProxy.
 */
public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    // Lazily loaded content — null until loadFromDisk() runs
    private String content;

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        if (content == null) {
            content = loadFromDisk();
        }
        System.out.println("REPORT -> id=" + reportId
                + " title=" + title
                + " classification=" + classification
                + " openedBy=" + user.getName());
        System.out.println("CONTENT: " + content);
    }

    public String getClassification() {
        return classification;
    }

    // Simulates an expensive I/O operation
    private String loadFromDisk() {
        System.out.println("[disk] loading report " + reportId + " ...");
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Internal report body for " + title;
    }
}
