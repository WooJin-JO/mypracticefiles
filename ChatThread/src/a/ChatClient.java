package a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		//console창에 입력되는 parameter가 2개가 아니면 사용법을 설명해준다.
		if(args.length != 2){
			System.out.println("사용법 : java ChatClient id 접속할서버ip");
			System.exit(1);
		}
		Socket sock = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		boolean endflag = false;
		try{
			sock = new Socket(args[1], 10001);
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			//System.in을 통해서 키보드에 입력하는것을 입력을 받는다.
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// 사용자의 id를 전송한다.
			pw.println(args[0]);
			pw.flush();
			//입력하는 도중 다른 유저의 채팅에 입력을 방해받지않도록 듣는 기능을 하는 Thread를 구현
			InputThread it = new InputThread(sock, br);
			it.start();
			String line = null;
			//채팅을 지속하는 동안 유지될 while문
			while((line = keyboard.readLine()) != null){
				pw.println(line);
				pw.flush();
				//종료
				if(line.equals("/quit")){
					endflag = true;
					break;
				}
			}
			System.out.println("클라이언트의 접속을 종료합니다.");
		}catch(Exception ex){
			if(!endflag)
				System.out.println(ex);	
		}finally{
			try{
				if(pw != null)
					pw.close();
			}catch(Exception ex){}
			try{
				if(br != null)
					br.close();
			}catch(Exception ex){}
			try{
				if(sock != null)
					sock.close();
			}catch(Exception ex){}
		} // finally
	} // main
} // class

class InputThread extends Thread{
	private Socket sock = null;
	private BufferedReader br = null;
	public InputThread(Socket sock, BufferedReader br){
		this.sock = sock;
		this.br = br;
	}
	public void run(){
		try{
			String line = null;
			//듣는것을 창에 뛰워주기
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		}catch(Exception ex){
		}finally{
			try{
				if(br != null)
					br.close();
			}catch(Exception ex){}
			try{
				if(sock != null)
					sock.close();
			}catch(Exception ex){}
		}
	} // InputThread
}