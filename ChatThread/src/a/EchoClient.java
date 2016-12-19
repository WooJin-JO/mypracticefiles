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
			Socket sock = new Socket("127.0.0.1", 10001);//���� IP�� ��Ʈ��ȣ
			//Ű������ �Է��� �޴� InputSteraeamReader�� �̿��� BufferedReader�� ����
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			//��ȯ���� Socket���κ��� InputStream�� OutputStream�� ����
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			//OutputStream�� OutputStreamWriter�� ���� PrintWriter �������� ��ȯ
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			//InputStream�� InputStreamReader�� ���� BufferedReader �������� ��ȯ
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while((line = keyboard.readLine()) != null){
				if(line.equals("quit")) break;
				pw.println(line);
				pw.flush();
				String echo = br.readLine();
				System.out.println("���� �κ��� ���޹��� ���ڿ� :" + echo);
			}
			pw.close();
			br.close();
			sock.close();
		}catch(Exception e){
			System.out.println(e);
		}
	} // main
}