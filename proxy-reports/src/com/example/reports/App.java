package com.example.reports;

/**
 * CampusVault entry point — after refactor.
 *
 * Clients create ReportProxy objects (not ReportFile directly).
 * The proxy transparently handles:
 *   - access control
 *   - lazy loading
 *   - caching (no repeated disk I/O for the same proxy)
 *
 * Scenario covered:
 *   1. Student views a PUBLIC report              → allowed, disk loaded once
 *   2. Student tries a FACULTY report             → blocked by proxy
 *   3. Faculty views the same FACULTY report      → allowed, disk loaded
 *   4. Admin views an ADMIN report                → allowed, disk loaded
 *   5. Admin views the SAME ADMIN report again    → cache hit, no disk I/O
 */
public class App {

    public static void main(String[] args) {
        // ----- Users -----
        User student = new User("Jasleen", "STUDENT");
        User faculty = new User("Prof. Noor", "FACULTY");
        User admin   = new User("Kshitij",   "ADMIN");

        // ----- Proxies (no RealReport created yet — lazy) -----
        Report publicReport  = new ReportProxy("R-101", "Orientation Plan", "PUBLIC");
        Report facultyReport = new ReportProxy("R-202", "Midterm Review",   "FACULTY");
        Report adminReport   = new ReportProxy("R-303", "Budget Audit",     "ADMIN");

        ReportViewer viewer = new ReportViewer();

        System.out.println("=== CampusVault Demo ===");
        System.out.println();

        // 1. Student opens PUBLIC → should succeed, disk loaded
        System.out.println("--- [1] Student opens PUBLIC report ---");
        viewer.open(publicReport, student);
        System.out.println();

        // 2. Student tries FACULTY → should be denied (no disk access)
        System.out.println("--- [2] Student opens FACULTY report (should be DENIED) ---");
        viewer.open(facultyReport, student);
        System.out.println();

        // 3. Faculty opens FACULTY → should succeed, disk loaded
        System.out.println("--- [3] Faculty opens FACULTY report ---");
        viewer.open(facultyReport, faculty);
        System.out.println();

        // 4. Admin opens ADMIN → should succeed, disk loaded
        System.out.println("--- [4] Admin opens ADMIN report ---");
        viewer.open(adminReport, admin);
        System.out.println();

        // 5. Admin opens SAME ADMIN report again → cache hit, no disk I/O
        System.out.println("--- [5] Admin opens ADMIN report again (cache hit expected) ---");
        viewer.open(adminReport, admin);
    }
}
