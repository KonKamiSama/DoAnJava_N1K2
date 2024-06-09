package server;

import java.io.*;
import java.net.*;

import client.Client;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.SinhVienDAO;

public class Server {
    private ServerSocket serverSocket;
    private Client client;

    public Server(Client client) {
        this.client = client;
        startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(7331);
            System.out.println("Server started on port " + 7331);
            client.connectServer();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
                System.out.println(1);
            }
        } catch (Exception e) {
            System.out.println("Could not initialize server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
