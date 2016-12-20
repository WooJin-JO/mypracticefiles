/* 
 * �а� : �����к�
 * �й� : 2012048908
 * �̸� : ������
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;				

public class ChatServer {				

	public static void main(String[] args) {			
		try{		
			ServerSocket server = new ServerSocket(10001);	
			System.out.println("������ ��ٸ��ϴ�.");	
			HashMap hm = new HashMap();	
			while(true){	
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock, hm);
				chatthread.start();
			} // while	
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
	//�� ���͸��� ���� ���ڿ�
	String[] ban = {"����", "����", "���", "ȣ��", "�ٺ�"};
	//���� �ð��� ǥ���ϱ� ���� �ڵ�
	long time = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("[hh�� mm�� ss��]");
	String daytime = sdf.format(new Date(time));
	//���� �ð��� ǥ���ϱ� ���� �ڵ� end
	public ChatThread(Socket sock, HashMap hm){		
		this.sock = sock;	
		this.hm = hm;	
		try{	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));	
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	
			id = br.readLine();	
			broadcast(id + "���� �����Ͽ����ϴ�.");	
			System.out.println("������ ������� ���̵�� " + id + "�Դϴ�.");	
			synchronized(hm){	
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
				if(line.equals("/quit"))	
					break;
				if(line.indexOf("/to ") == 0){	
					sendmsg(line);
				}else if(line.indexOf("/userlist") == 0){
					//userlist������ ���� ���ɹ� ����
					senduserlist();
				}//�弳 ���͸�
				else if(line.indexOf(ban[0]) == 0){
					ban();
				}else if(line.indexOf(ban[1]) == 0){
					ban();
				}else if(line.indexOf(ban[2]) == 0){
					ban();
				}else if(line.indexOf(ban[3]) == 0){
					ban();
				}else if(line.indexOf(ban[4]) == 0){
					ban();
				}else{
					broadcast(id + " : " + line);
				}
			}		
		}catch(Exception ex){			
			System.out.println(ex);		
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
		int start = msg.indexOf(" ") +1;			
		int end = msg.indexOf(" ", start);			
		if(end != -1){			
			String to = msg.substring(start, end);		
			String msg2 = msg.substring(end+1);		
			Object obj = hm.get(to);		
			if(obj != null){		
				PrintWriter pw = (PrintWriter)obj;	
				pw.println(daytime + id + " ���� ������ �ӼӸ��� �����̽��ϴ�. :" + msg2);	
				pw.flush();	
			} // if	
		}		
	} // sendmsg			
	public void broadcast(String msg){
		synchronized(hm){
			Collection collection = hm.values();	
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println(daytime + msg);
				pw.flush();
			}
		}		
	} // broadcast
	//userlist���
	public void senduserlist(){
		synchronized(hm){
			Collection collection = hm.keySet();
			Iterator iter = collection.iterator();
			//hm���� id�� �޾ƿͼ� ��üȭ
			Object obj = hm.get(id);
			if(obj != null){
				//��üȭ�� id�� ����Ҽ� �ֵ��� PrintWriter�� ���� ���߾��ֱ�
				PrintWriter pw = (PrintWriter)obj;
				while(iter.hasNext()){
					String str = (String)iter.next();
					//������� ���̵� ���
					pw.println(str);
					pw.flush();
				}
				//���� ������ ���� �˷��ִ� �ڵ�
				pw.println("�� " + hm.size() + "�� ���� ��");
				pw.flush();
			}
		}
	}
	public void ban(){
		synchronized(hm){
			Collection collection = hm.keySet();
			Iterator iter = collection.iterator();
			Object obj = hm.get(id);
			if(obj != null){
				PrintWriter pw = (PrintWriter)obj;
				pw.println("��������!");
				pw.flush();
			}
		}
	}
}

/*
 * (1) InputThread�� ����� ����ϴ� ������ ����� ����
 * ä���� �Է��ϰ� �ִ��߿� �ٸ������ ä���� �Ͽ� �޼����� ������� CMDâ������ ���ڸ� �Է��ϰ� �ִ� Ŀ���� �ٷεڿ� ����� �ȴ�.
 * ���� �̶� Thread�� ������� ������ ���� ����� ä���� �� ��� ä���� �Է��ϴ� ��� ������� �޼����� �������� ä���� �Ҽ��� ���Եȴ�.
 * �׷��� �������� �������� ��� �� �� �ֵ��� InputThread�� ����Ͽ� �Է��� �޴´�.
 * 
 * (2) broadcast()&sendmsg()���� hm���� ����
 * hm(HashMap)�� �������� ID�� �����ϰ�, �̸� broadcast()�� ���� hm�� key�� ��ϵǾ� �ִ� ��� ����� ID�� ��� �޼����� ������ �Ѵ�.
 * sendmsg()�� hm���� �ӼӸ��� �������� �ϴ� ������ ID�� hm�� ��ϵǾ� �ִ� key���� ���Ͽ� ��ġ�ϴ� ������Ը� �޼����� �����Ѵ�.
 * 
 * (3)
 * broadcast()�� sendmsg()�� �����ϴ� ���ڿ� �տ� ���� �ð��� ��Ÿ���ִ� daytime�� �߰�
 * 
 * (4)
 * while���� ����ؼ� ID�� ������ְ�, �� �ο����� while�� ������ ���� 1���� ���
 * 
 * (5)
 * HashMap���� ID�� �޾ƿͼ� if���� ��� �ڽŰ� ���� ID��� broadcast()���� �޼��� ���ۿ��� �����Ϸ�������
 * ����
 * 
 * (6)
 * ����� �迭�� ����� �̸� �Է��ϰ� �Ǹ� ban()�� �̿��ؼ� �ش� ������Ը� "��������!"��� ������ ���
 * 
 * (7) Ŭ���̾�Ʈ���� ��뱸�� HashMap���� �����Ͽ� ����ϰ� �ϴ� ��� ����
 * run()���� if���� �̿� +���ڰ� �ԷµǸ� sendmsg()�� ���� ó���� ���� ���� "+ ��"�� "# ��"���� ��ȯ�Ͽ� put�޼ҵ带 �̿�
 * key������ ��뱸�� ����� ����(���� ���ÿ��� "# ��")�� ����ϰ�, ����ؾ��� ����(���� ���ÿ��� "�ȳ��ϼ���")�� value������ �ϴ� HashMap��ü ����,
 * key ������ ä�ÿ� �Է��̵Ǹ� run()�� if-else���� ó���� �Ͽ��� value���� ��µǵ��� �Ѵ�.
 * 
 * (8) Ŭ���̾�Ʈ �� ���� ���α׷����� ���� ���� ��� ����
 * "$ �����̸�"�� ���ؼ� FileInputStream�� �����Ͽ� �ش� ������ �о����, ObjectInputStream�� ���ؼ� ��üȭ�� �ϰ�,
 * �̰��� �������� �����ϰ� ������ �޴� ����� ��� "$ �����̸�"�� �����ϸ� FileOutputStream�� ObjectOutputStream�� �̿��ؼ� ����ȭ �Ѵ�.
 */