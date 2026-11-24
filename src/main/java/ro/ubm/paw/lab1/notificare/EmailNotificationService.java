package ro.ubm.paw.lab1.notificare;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary  // implementarea aleasă implicit când există mai multe
public class EmailNotificationService  implements NotificationService {
    public String send(String destinatar, String mesaj) {
        return "[EMAIL] catre " + destinatar + ": " + mesaj;
    }
}

