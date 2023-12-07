package com.solvd.teamgamematch.connection;

public class Client {
    private Connection connection = null;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void getConnectionFromPool() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        while (connection == null) {
            connection = connectionPool.getConnection();
        }
    }

    public void freeConnection() {
        ConnectionPool.getInstance().releaseConnection(connection);
        connection = null;
    }

    @Override
    public String toString() {
        return "Client " + name + " is connected to " + connection.getName();
    }
}
