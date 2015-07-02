package com.springapp.mvc.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import static java.util.concurrent.Executors.newScheduledThreadPool;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EventService {

    private EventBus eventBus;

    private AtomicInteger count;

    public EventService() {
        this.eventBus = new AsyncEventBus("customEvent", newScheduledThreadPool(10));
        this.eventBus.register(new EventHandler());
        this.count = new AtomicInteger(0);
    }

    public int doEvent() {
        int number = count.incrementAndGet();
        this.eventBus.post(new EventCustom(number, "do event."));
        return number;
    }

}
