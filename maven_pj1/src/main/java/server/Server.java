package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.SinhVienDAO;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private SinhVienDAO svd;

	public void startServer(int port) {
		try {
			serverSocket = new ServerSocket(7331);
			System.out.println("Server started on port " + 7331);
			while (true) {
				clientSocket = serverSocket.accept();
				try {
					out = new PrintWriter(clientSocket.getOutputStream(), true);
					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
					String data = in.readLine();
					out.println("Data received " + data);
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
					default:
						out.println("Invalid action");
					}
				} catch (Exception e) {
					System.out.println("Connection failed: " + e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("Could not start server: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
