package org.bobocode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EveningServletSocketClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8080)) {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("GET /evening?name=BUDDY HTTP/1.1");
            printWriter.println("Host: " + InetAddress.getLocalHost().getHostAddress());
            printWriter.println();
            printWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
