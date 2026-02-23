// Checkpoint C: WhatsAppSender honours the base contract.
// No longer throws — instead it prints a clear error and records to audit internally.
// Callers need no try/catch or instanceof to be safe with any NotificationSender.
public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            // Record and print gracefully — no exception crosses the public boundary.
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return;
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
