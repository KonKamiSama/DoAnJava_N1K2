package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class Client {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public void sentData(JSONObject jsonSv) {
		try {
			socket = new Socket("localhost", 7331);
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(jsonSv);
			System.out.println("Connected to server successfully!");
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void getData() {
		
	}
}
