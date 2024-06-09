package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.SinhVienDAO;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private SinhVienDAO svd;
    
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            InputStream i = clientSocket.getInputStream();
            OutputStream o = clientSocket.getOutputStream();
            InputStreamReader inn = new InputStreamReader(i);
            this.in = new BufferedReader(inn);
            this.out = new PrintWriter(o, true);
        } catch (IOException e) {
            System.out.println("Can't open IO stream in server: " + e.getMessage());
            e.printStackTrace();
        }
    }

	public void run() {
		try {
			System.out.println(2);
//			String data = in.readLine();
			System.out.println(3);
//			chưa chạy đến đấy, vì biến data k nhận được nên hàm k chạy nữa
			while (!clientSocket.isClosed()) {
				String data = in.readLine();
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
					out.println(jsArray.toString());
					break;
				case "Check":
					JSONArray jsAccount = svd.selectAllAccounts();
					out.println(jsAccount.toString());
					break;
					default:
				}
				data = in.readLine();
			}
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
