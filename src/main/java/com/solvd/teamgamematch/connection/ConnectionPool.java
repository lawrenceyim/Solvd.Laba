package com.solvd.teamgamematch.connection;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class ConnectionPool {
    private final int MAX_CONNECTIONS = 5;
    private static ConnectionPool instance = null;
    private volatile CopyOnWriteArrayList<Connection> occupiedConnections = new CopyOnWriteArrayList<>();
    private volatile ConcurrentLinkedQueue<Connection> freeConnections = new ConcurrentLinkedQueue<>();

    private ConnectionPool() {
        IntStream.rangeClosed(1, MAX_CONNECTIONS).forEach(i -> {
            Connection connection = new Connection();
            connection.setName("Connection " + i);
            freeConnections.add(connection);
        });
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (freeConnections.isEmpty()) {
            return null;
        }
        Connection connection = freeConnections.remove();
        occupiedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        occupiedConnections.remove(connection);
        freeConnections.add(connection);
    }
}
