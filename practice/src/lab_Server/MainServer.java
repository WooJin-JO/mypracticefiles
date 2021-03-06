package lab_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) {
		try{
			@SuppressWarnings("resource")
			ServerSocket s_socket = new ServerSocket(8888);
			Socket c_socket = s_socket.accept();
			System.out.println("Server Start");
			
			InputStream ips = c_socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ips));
			OutputStream ops = c_socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(ops));
			
			String line = null;
			
			while((line = br.readLine()) != null){
				System.out.println(line);
				pw.println(line);
				pw.flush();
			}
			pw.close();
			br.close();
			c_socket.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
