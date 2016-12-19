package a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient{

	public static void main(String[] args) {
		try{
			Socket sock = new Socket("127.0.0.1", 10001);//접속 IP와 포트번호
			//키보드의 입력을 받는 InputSteraeamReader를 이용해 BufferedReader를 구현
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			//반환받은 Socket으로부터 InputStream과 OutputStream을 구함
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			//OutputStream을 OutputStreamWriter을 통해 PrintWriter 형식으로 변환
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			//InputStream을 InputStreamReader을 통해 BufferedReader 형식으로 변환
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while((line = keyboard.readLine()) != null){
				if(line.equals("quit")) break;
				pw.println(line);
				pw.flush();
				String echo = br.readLine();
				System.out.println("서버 로부터 전달받은 문자열 :" + echo);
			}
			pw.close();
			br.close();
			sock.close();
		}catch(Exception e){
			System.out.println(e);
		}
	} // main
}