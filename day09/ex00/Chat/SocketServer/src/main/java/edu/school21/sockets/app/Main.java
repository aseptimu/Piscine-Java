package edu.school21.sockets.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final String portClientArg = "--port=";
    public static void main(String[] args) {
//        HikariDataSource hikari = new HikariDataSource(new HikariConfig());
        if (args.length != 1 && !args[0].startsWith(portClientArg)) {
            System.err.println("Wrong args");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0].substring(portClientArg.length()));
        try {
            Server server1 = new Server(port);
            server1.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
