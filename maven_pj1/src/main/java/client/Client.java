package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
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
			String response = in.readLine();
			System.out.println("Response from server: " + response);
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public JSONArray getData() {
		try {
			String data = in.readLine();
			System.out.println("Response from server: " + data);
			return new JSONArray(data);
		} catch (Exception e) {
			System.out.println("Failed to receive data from server: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void closeConnection() {
        try {
          socket.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("Failed to close connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}