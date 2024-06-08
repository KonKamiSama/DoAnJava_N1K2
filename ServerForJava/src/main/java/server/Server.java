package server;

import java.io.BufferedReader;
import client.*;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.SinhVienDAO;

public class Server {
	private ServerSocket serverSocket;
	private Client client;

	public Server(Client client){
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
				System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
				new ClientHandler(clientSocket).start();
			}
		} catch (Exception e) {
			System.out.println("chua khoi tao sv: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private class ClientHandler extends Thread {
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		private SinhVienDAO svd;

		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}

		 public void run() {
	            try {
	                out = new PrintWriter(clientSocket.getOutputStream(), true);
	                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	                String data = in.readLine();
	                while (data != null) {
	                    JSONObject jsonObject = new JSONObject(data);
	                    String action = jsonObject.getString("action");

	                        switch (action) {
	                        case "Edit":
	                            svd.Edit(data);
	                            break;
	                        case "Save":
	                            svd.Save(data);
	                            break;
	                        case "Delete":
	                            svd.Delete(data);
	                            break;
	                        case "Show":
	                            JSONArray jsArray = svd.SelectAll();
	                            out.println(jsArray);
	                            break;
	                        case "Check":
	                            JSONArray jsAccount = svd.selectAllAccounts();
	                            out.println(jsAccount);
	                            break;
	                        }
	                    }
	                    data = in.readLine();
	            } catch (Exception e) {
	                System.out.println("Connection failed: " + e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }
}
