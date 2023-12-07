package com.solvd.teamgamematch.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {
    private final int MAX_CONNECTIONS = 5;
    private static ConnectionPool instance = null;
    private List<Connection> connections = new ArrayList<>();

    private ConnectionPool() {
        IntStream.rangeClosed(1,5).forEach(i -> {
            Connection connection = new Connection();
            connection.setName("Connection " + i);
            connections.add(connection);
        });
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {

        return null;
    }

    public synchronized void releaseConnection(Connection connection) {

    }
}
