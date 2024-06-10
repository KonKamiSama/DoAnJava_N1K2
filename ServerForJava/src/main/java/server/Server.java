package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import client.Client;
import dao.SinhVienDAO;

public class Server {
    private ServerSocket serverSocket;

    public Server(Client client) {
        try {
            serverSocket = new ServerSocket(7331);
            System.out.println("Server started on port 7331");
            SinhVienDAO svd = new SinhVienDAO();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("1");
                new ClientHandler(clientSocket, svd).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
