package chatThread;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");
			while(true){
				Socket sock = server.accept();
				EchoThread echothread = new EchoThread(sock);
				echothread.start();//.start() => Thread에서 구현되어 있다.
			} // while
		}catch(Exception e){
			System.out.println(e);
		}
	} // main
}

class EchoThread extends Thread/*Thread => JAVA에서 제공하는 기본 class*/{
	private Socket sock;
	public EchoThread(Socket sock){
		this.sock = sock;
	} // 생성자
	public void run()/*run() => Thread에서 구현되어 있다.(overriding)*/{
		try{
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println("클라이언트로 부터 전송받은 문자열 : " + line);
				pw.println(line);
				pw.flush();
			}
			pw.close();
			br.close();
			sock.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	} // run
}