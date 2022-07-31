package edu.school21.socket.app;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
        private static Socket clientSocket; //сокет для общения
        private static Scanner reader; // нам нужен ридер читающий с консоли, иначе как
        // мы узнаем что хочет сказать клиент?
        private static BufferedReader in; // поток чтения из сокета
        private static BufferedWriter out; // поток записи в сокет
        private static final String wrongConnectionWord = "Write \"signUp\" to connect";

        private static final String portServerArg = "--server-port=";

        public static void main(String[] args) throws IOException {
            if (args.length != 1 && !args[0].startsWith(portServerArg)) {
                System.err.println("Wrong args");
                System.exit(1);
            }
            int port = Integer.parseInt(args[0].substring(portServerArg.length()));
            clientSocket = new Socket("localhost", port);
            reader = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String checkAnswer = wrongConnectionWord;

            System.out.println(in.readLine());
            while (checkAnswer.equals(wrongConnectionWord)) {
                out.write(reader.nextLine() + '\n');
                out.flush();
                checkAnswer = in.readLine();
                System.out.println(checkAnswer);
            }
            for (int i = 0; i < 2; i++) {
                out.write(reader.nextLine() + '\n');
                out.flush();
                System.out.println(in.readLine());
            }

            clientSocket.close();
            in.close();
            out.close();
        }
}
