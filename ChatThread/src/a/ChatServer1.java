package a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/*
��� ����
----------------------Lab(2016.12.08)----------------------
1.������(array list�� ���� ����� �����صд�. & �ӼӸ���ɰ� ���� ����� ������ broadcast�� �����ʰ� �ش� id���� �������� �޼����� �����ش�.)
2.�󸮱�(��ü ä�ñ��� / �� �ʰ� broadcast�� ���� �ʰ� �Ѵ�.)
3.���� �� ����� �ο��ϱ�(HashMap�� ID�� ��ü�� ���� ������ �ο�)
4.���� ��������(HashMap���� ID�� ������ֱ�)
5.����(HashMap���� ID�� �����. => broadcast�� ���� ���ϰԵȴ�.)
6.���̵� ����(HashMap���� ID�� �����ϰ� value���� ���� ���� ID�� �־��ش�.)
7.����(�����ð����� broadcast�ϰ� ���ش�.)
8.ä�ñ���(����)
9.��ũ��(client���� ����/ �� �ʿ� �ѹ��� �޼��� ����)
----------------------����(2016.12.13)----------------------
10.ȥ�ڸ�(�ڱ� value�� ������)
11.�弳 ����(�� ȸ �̻�� ä�ù濡�� ����)
 */

public class ChatServer1 {

	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");
			//HashMap : ��ġ�� ���� ã�� array�� �޸� ������ key�� �ο��Ͽ� ���� ex)ID
			HashMap hm = new HashMap();//note3.pdf ����
			//Socket�� accept �Ѵ�. �������� �޾ƾ��ϱ� ������ Thread�� ���� ����ؼ� accept �� �� �ֵ��� ���
			while(true){
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock, hm);
				chatthread.start();
			} // while
			//������ ���
		}catch(Exception e){
			System.out.println(e);
		}
	} // main
}

class ChatThread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private boolean initFlag = false;
	//ChatThread �ʱ�ȭ
	public ChatThread(Socket sock, HashMap hm){
		this.sock = sock;
		this.hm = hm;
		try{
			//PrintWriter�� OutputStreamWriter�� ���ؼ� ����Ѵ�.
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			//BufferedReader�� InputStreamReader�� ���ؼ� �Է��� �޴´�.
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = br.readLine();
			broadcast(id + "���� �����Ͽ����ϴ�.");
			System.out.println("������ ������� ���̵�� " + id + "�Դϴ�.");
			//synchronized�� ���ؼ� ���ÿ� ������ ��û�� ������ �ο��Ѵ�.
			synchronized(hm){
				//��û�� HashMap�� �־��ش�.
				//�̸� ���ؼ� broadcast�� ��ο��� �ȳ���(Ex:����, ����)�� �����ų� ���ο��� �ӼӸ��� �� �� �ְ� �Ѵ�.(id���)
				hm.put(this.id, pw);
			}
			initFlag = true;
		}catch(Exception ex){
			System.out.println(ex);
		}
	} // ������
	public void run(){
		try{
			String line = null;
			while((line = br.readLine()) != null){
				//����
				if(line.equals("/quit"))
					break;
				//�ӼӸ�
				if(line.indexOf("/to ") == 0){
					sendmsg(line);
					//����� �ӼӸ��� �ƴϸ� broadcast�� ���� ��ο��� ���Ѵ�.
				}else if(line.indexOf("/self ") == 0){
					selfmsg(line);
				}else if(line.indexOf("/userlist ") == 0){
					userlist();
				}else if(line.indexOf("/stopchat") == 0){
					stopchat();
				}else 
					broadcast(id + " : " + line);
			}
			//���� ���.
		}catch(Exception ex){
			System.out.println(ex);
			//Finally : try���� Error�� ������ �ݵ�� �������ش�.
		}finally{
			synchronized(hm){
				hm.remove(id);
			}
			broadcast(id + " ���� ���� �����Ͽ����ϴ�.");
			try{
				if(sock != null)
					sock.close();
			}catch(Exception ex){}
		}
	} // run
	public void sendmsg(String msg){
		//�������� �޼����� ������, � ������ ������������ ����
		int start = msg.indexOf(" ") +1;
		int end = msg.indexOf(" ", start);
		if(end != -1){
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end+1);

			Object obj = hm.get(to);
			if(obj != null){
				PrintWriter pw = (PrintWriter)obj;
				pw.println(id + " ���� ������ �ӼӸ��� �����̽��ϴ�. :" + msg2);
				pw.flush();
			} // if
		}
	} // sendmsg
	public void broadcast(String msg){
		synchronized(hm)/*note3.pdf ����*/{
			//HashMap�� key�� value�� ���� values�� ��� value��
			//Collection�� ���ؼ� value���� �迭�� ����
			Collection collection = hm.values();
			//Iterator : �ݺ���
			//collection.iterator collection�� iterator�� �ٲ��ش�.
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println(msg);
				pw.flush();
			}
		}//synchronized
	} // broadcast
	public void selfmsg(String msg){
		String msg2 = msg.substring(6);
		synchronized (hm){
			Object obj = hm.get(id);
			if(obj != null){
				PrintWriter pw = (PrintWriter)obj; 
				pw.println("ȥ�ڸ�: " + msg2);
				pw.flush();
			}
		}
	}
	public void userlist(){
		synchronized(hm){
			Collection collection = hm.keySet();
			Iterator iter = collection.iterator();
			Object obj = hm.get(id);
			if(obj != null){
				PrintWriter pw = (PrintWriter)obj;
				while(iter.hasNext()){
					String str = (String)iter.next();
					pw.println(str);
					pw.flush();
				}
			}
		}
	}
	public void stopchat(){
		synchronized(hm){
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println("10�ʰ� ä���� ����ϴ�.");
				try{
					Thread.sleep(10000);
				}catch(InterruptedException e){
					return;
				}
				pw.flush();
			}
		}
	}
}