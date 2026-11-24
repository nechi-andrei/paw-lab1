package ro.ubm.paw.lab1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class VisitCounter {
    private int count;
    public int increment() { return ++count; }
}