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

        public static void main(String[] args) throws IOException {
            clientSocket = new Socket("localhost", 4004);
            reader = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println(in.readLine());
            System.out.println();


        }
}
