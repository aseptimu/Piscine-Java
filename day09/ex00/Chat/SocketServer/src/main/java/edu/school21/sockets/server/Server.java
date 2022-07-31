package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import edu.school21.sockets.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    private final AnnotationConfigApplicationContext context;

    public Server(int port) throws IOException {
        this.server = new ServerSocket(port);
        this.context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
    }

    public void connect() throws IOException {
        UsersService usersService = context.getBean("userService", UsersService.class);

        clientSocket = server.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        out.write("Hello from Server!\n");
        out.flush();

        String word = in.readLine();
        while (!word.equals(CONNECT)) {
            System.out.println("Connection refused"); //DEBUG
            out.write("Write \"signUp\" to connect\n");
            out.flush();
            word = in.readLine();
        }
        System.out.println("Connection established");
        out.write("Enter username:\n");
        out.flush();
        name = in.readLine();
        System.out.println("New user: " + name);
        out.write("Enter password:\n");
        out.flush();
        password = in.readLine();
        System.out.println("Users " + name + " password stored.");
        out.write("Successful!");
        out.flush();
        usersService.processData(name, password);

        in.close();
        out.close();
        server.close();
        clientSocket.close();
    }
}
