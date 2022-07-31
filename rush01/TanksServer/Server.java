import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final Integer PORT = 7000;
    private static ServerSocket serverSocket;
    private static Socket clientSocket1;
    private static Socket clientSocket2;
    private static BufferedReader in;
    private static BufferedWriter out;


    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    public void connect() throws IOException {
        clientSocket1 = serverSocket.accept();
        clientSocket2 = serverSocket.accept();

    }
}

/*

TODO: resources: schema, db.properties

*/
