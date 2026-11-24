package ro.ubm.paw.lab1.notificare;

import org.springframework.stereotype.Service;

@Service("sms")  // numele bean-ului, folosit cu @Qualifier("sms")
public class SmsNotificationService implements NotificationService {
    public String send(String destinatar, String mesaj) {
        return "[SMS] catre " + destinatar + ": " + mesaj;
    }
}