package com.springapp.mvc.event;

import com.google.common.eventbus.Subscribe;
import static java.lang.Thread.currentThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler {

    private static Logger logger = LoggerFactory.getLogger(EventHandler.class);

    @Subscribe
    public void handler(EventCustom eventCustom) {
        logger.info("current threadId " + currentThread().getId() + " handler begin");
        logger.info(eventCustom.toString());
        try {
            Thread.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            logger.error("handler ex : ", e);
        }
        logger.info("current threadId " + currentThread().getId() + " handler end");
    }
}
