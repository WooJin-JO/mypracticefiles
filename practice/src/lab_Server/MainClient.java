package lab_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {
		try{
			Socket c_socket = new Socket("127.0.0.1", 8888);
			System.out.println("Client Start");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			
			OutputStream ops = c_socket.getOutputStream();
			InputStream ips = c_socket.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(ops));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(ips));
			String line = null;
			
			while((line = br1.readLine()) != null){
				if(line.equals("exit")){
					break;
				}
				pw.println(line);
				pw.flush();
				String echo = br2.readLine();
				System.out.println(echo);
			}
			pw.close();
			br2.close();
			c_socket.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
