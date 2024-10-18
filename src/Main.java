// Интерфейс для отправки уведомлений
interface Notifier {
    void send(String message);
}

// Отправка по email
class EmailSender implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

// Отправка SMS
class SmsSender implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

// Класс для отправки уведомлений
class NotificationService {
    private Notifier notifier;

    // Зависимость внедряется через конструктор
    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendNotification(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailSender();
        Notifier smsNotifier = new SmsSender();

        NotificationService emailService = new NotificationService(emailNotifier);
        emailService.sendNotification("Hello via Email!");

        NotificationService smsService = new NotificationService(smsNotifier);
        smsService.sendNotification("Hello via SMS!");
    }
}
