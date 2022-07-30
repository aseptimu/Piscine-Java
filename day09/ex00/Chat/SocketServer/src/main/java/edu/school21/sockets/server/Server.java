package edu.school21.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String CONNECT = "signUp";
    private ServerSocket server;
    private String name;
    private String password;
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public Server(int port) throws IOException {
        this.server = new ServerSocket(4004);
    }

    public void connect() throws IOException {
        clientSocket = server.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        out.write("Hello from Server!\n");
        out.flush();

        String word = in.readLine();
        while (!word.equals(CONNECT)) {
            out.write("Write \"signUp\" to connect\n");
            out.flush();
            word = in.readLine();
        }
        out.write("Enter username:\n");
        out.flush();
        name = in.readLine();
        out.write("Enter password:\n");
        out.flush();
        password = in.readLine();
        out.write("Successful!");

        in.close();
        out.close();
        server.close();
        clientSocket.close();
    }
}
