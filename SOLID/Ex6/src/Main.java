// Checkpoint D: Main no longer needs try/catch to safely use any NotificationSender subtype.
// All senders are substitutable — callers work uniformly with the base type.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender email = new EmailSender(audit);
        NotificationSender sms   = new SmsSender(audit);
        NotificationSender wa    = new WhatsAppSender(audit);

        // No try/catch needed — any subtype is safely substitutable for NotificationSender.
        email.send(n);
        sms.send(n);
        wa.send(n);   // handles invalid phone internally, no exception thrown

        System.out.println("AUDIT entries=" + audit.size());
    }
}
