package a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		//consoleâ�� �ԷµǴ� parameter�� 2���� �ƴϸ� ������ �������ش�.
		if(args.length != 2){
			System.out.println("���� : java ChatClient id �����Ҽ���ip");
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
			//System.in�� ���ؼ� Ű���忡 �Է��ϴ°��� �Է��� �޴´�.
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			// ������� id�� �����Ѵ�.
			pw.println(args[0]);
			pw.flush();
			//�Է��ϴ� ���� �ٸ� ������ ä�ÿ� �Է��� ���ع����ʵ��� ��� ����� �ϴ� Thread�� ����
			InputThread it = new InputThread(sock, br);
			it.start();
			String line = null;
			//ä���� �����ϴ� ���� ������ while��
			while((line = keyboard.readLine()) != null){
				pw.println(line);
				pw.flush();
				//����
				if(line.equals("/quit")){
					endflag = true;
					break;
				}
			}
			System.out.println("Ŭ���̾�Ʈ�� ������ �����մϴ�.");
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
			//��°��� â�� �ٿ��ֱ�
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