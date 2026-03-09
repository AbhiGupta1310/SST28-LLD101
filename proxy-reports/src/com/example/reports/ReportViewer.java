package com.example.reports;

/**
 * ReportViewer now depends only on the Report interface (not the concrete ReportFile).
 *
 * This makes it open for extension / closed for modification:
 * clients can pass either RealReport or ReportProxy without changing this class.
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
