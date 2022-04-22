package thread;

import hospital.models.staff.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thread.connectionpool.ConnectionPool;

public class DoctorRunnable extends Doctor implements Runnable {

    private final Logger LOGGER = LogManager.getLogger(DoctorRunnable.class);
    private String threadName;
    private ConnectionPool pool;

    public DoctorRunnable(){
    }

    public DoctorRunnable(String threadName, ConnectionPool pool) {
        this.threadName = threadName;
        this.pool = pool;
    }
    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String name) {
        this.threadName = name;
    }

    @Override
    public synchronized void run() {
        String connection = null;
        try {
            connection = pool.getConnection();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        LOGGER.info("Executing " + threadName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.releaseConnection(connection);

    }
}
