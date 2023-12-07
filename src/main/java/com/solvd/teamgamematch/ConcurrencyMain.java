package com.solvd.teamgamematch;

import com.solvd.teamgamematch.connection.Client;
import com.solvd.teamgamematch.output.CurrentOutput;
import com.solvd.teamgamematch.output.IOutput;

import java.util.stream.IntStream;

public class ConcurrencyMain {
    public static void main(String[] args) {
        IOutput output = CurrentOutput.getCurrentOutput();

        Runnable runnable1 = () -> IntStream.rangeClosed(1, 20).forEach(i -> {
            Client client = new Client("Client " + i);
            client.getConnectionFromPool();
            output.displayOutput(client.toString());
            client.freeConnection();
        });
        Runnable runnable2 = () -> IntStream.rangeClosed(101, 120).forEach(i -> {
            Client client = new Client("Client " + i);
            client.getConnectionFromPool();
            output.displayOutput(client.toString());
            client.freeConnection();
        });

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
