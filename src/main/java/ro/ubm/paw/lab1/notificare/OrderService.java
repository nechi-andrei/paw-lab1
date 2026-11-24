package ro.ubm.paw.lab1.notificare;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class OrderService {

    private final NotificationService notificare;        // primește @Primary (email)
    private final NotificationService notificareUrgenta; // primește bean-ul "sms"
    private final Clock clock;                           // bean-ul din AppConfig

    // un singur constructor => @Autowired nu este necesar
    public OrderService(NotificationService notificare,
                        @Qualifier("sms") NotificationService notificareUrgenta,
                        Clock clock) {
        this.notificare = notificare;
        this.notificareUrgenta = notificareUrgenta;
        this.clock = clock;
    }

    public String plaseazaComanda(String client, boolean urgenta) {
        String mesaj = "Comanda primita la " + LocalDateTime.now(clock).withNano(0);
        return urgenta ? notificareUrgenta.send(client, mesaj)
                : notificare.send(client, mesaj);
    }
}
