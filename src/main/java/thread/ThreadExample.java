package thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExample extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ThreadExample.class);

        @Override
        public synchronized void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }

}
