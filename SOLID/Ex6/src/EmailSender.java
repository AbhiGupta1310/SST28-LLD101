// Checkpoint C: EmailSender honours the base contract.
// Removed silent truncation — callers relying on full body delivery are no longer surprised.
public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
