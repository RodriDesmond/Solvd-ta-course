package thread.connectionpool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thread.ThreadExample;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    /*
    Create Connection Pool.
    Use collection from java.util.concurrent package.
    Connection class may be mocked.
    The pool should be threadsafe and lazy initialized.
     */
    private static final int MAX_CONNECTIONS = 5;
    //LinkedBlockingQueue is a thread-safe queue
    private final LinkedBlockingQueue<String> poolQueue;
    //AtomicInteger is a thread-safe integer
    private final AtomicInteger activeConnections = new AtomicInteger(0);
    private static ConnectionPool INSTANCE = null;

    private ConnectionPool() {
        this.poolQueue = new LinkedBlockingQueue<>(MAX_CONNECTIONS);
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null){
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }
        return INSTANCE;
    }

    public void init(){
        try {
            poolQueue.put(" Connection " + getActiveConnections());
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }

    }
    public AtomicInteger getActiveConnections() {
        return activeConnections;
    }

    public String getConnection() throws InterruptedException {
        if (poolQueue.size() == 0 && activeConnections.get() < MAX_CONNECTIONS) {
            synchronized (ConnectionPool.class) {
                if (poolQueue.size() == 0 && activeConnections.get() < MAX_CONNECTIONS) {
                    INSTANCE.init();
                    getActiveConnections().incrementAndGet();
                }
            }
        }
        return poolQueue.take();
    }

    public void releaseConnection(String connection) {
        if (connection != null) {
            try {
                poolQueue.put(connection);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }

    public void closeAllConnections() {
        while (activeConnections.get() > 0) {
            String connection;
            try {
                connection = poolQueue.take();
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
            activeConnections.decrementAndGet();
        }
    }

}
