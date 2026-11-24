package ro.ubm.paw.lab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ro.ubm.paw.lab1.notificare.NotificationService;

@Component
public class StartupRunner implements CommandLineRunner {
    private final ApplicationContext context;

    public StartupRunner(ApplicationContext context) { this.context = context; }

    @Override
    public void run(String... args) {
        context.getBeansOfType(NotificationService.class)
                .forEach((nume, bean) -> System.out.println("Bean: " + nume));
        VisitCounter a = context.getBean(VisitCounter.class);
        VisitCounter b = context.getBean(VisitCounter.class);
        System.out.println("Aceeasi instanta? " + (a == b));  // false; cu singleton: true
    }
}
