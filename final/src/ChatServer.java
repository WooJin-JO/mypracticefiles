/* 
 * 학과 : 경제학부
 * 학번 : 2012048908
 * 이름 : 조우진
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
			System.out.println("접속을 기다립니다.");	
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
	//욕 필터링을 위한 문자열
	String[] ban = {"씨발", "병신", "찐따", "호구", "바보"};
	//현재 시간을 표시하기 위한 코드
	long time = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("[hh시 mm분 ss초]");
	String daytime = sdf.format(new Date(time));
	//현재 시간을 표시하기 위한 코드 end
	public ChatThread(Socket sock, HashMap hm){		
		this.sock = sock;	
		this.hm = hm;	
		try{	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));	
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	
			id = br.readLine();	
			broadcast(id + "님이 접속하였습니다.");	
			System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");	
			synchronized(hm){	
				hm.put(this.id, pw);
			}	
			initFlag = true;	
		}catch(Exception ex){		
			System.out.println(ex);	
		}		
	} // 생성자			
	public void run(){			
		try{		
			String line = null;	
			while((line = br.readLine()) != null){		
				if(line.equals("/quit"))	
					break;
				if(line.indexOf("/to ") == 0){	
					sendmsg(line);
				}else if(line.indexOf("/userlist") == 0){
					//userlist실행을 위한 명령문 설정
					senduserlist();
				}//욕설 필터링
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
			broadcast(id + " 님이 접속 종료하였습니다.");		
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
				pw.println(daytime + id + " 님이 다음의 귓속말을 보내셨습니다. :" + msg2);	
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
	//userlist출력
	public void senduserlist(){
		synchronized(hm){
			Collection collection = hm.keySet();
			Iterator iter = collection.iterator();
			//hm에서 id를 받아와서 객체화
			Object obj = hm.get(id);
			if(obj != null){
				//객체화한 id를 출력할수 있도록 PrintWriter로 형을 맞추어주기
				PrintWriter pw = (PrintWriter)obj;
				while(iter.hasNext()){
					String str = (String)iter.next();
					//사용자의 아이디를 출력
					pw.println(str);
					pw.flush();
				}
				//현재 접속자 수를 알려주는 코드
				pw.println("총 " + hm.size() + "명 접속 중");
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
				pw.println("욕하지마!");
				pw.flush();
			}
		}
	}
}

/*
 * (1) InputThread를 만들어 사용하는 이유와 사용방식 설명
 * 채팅을 입력하고 있는중에 다른사람이 채팅을 하여 메세지를 보낼경우 CMD창에서는 문자를 입력하고 있는 커서의 바로뒤에 출력이 된다.
 * 따라서 이때 Thread를 사용하지 않으면 많은 사람이 채팅을 할 경우 채팅을 입력하다 계속 출력으로 메세지가 끊어져서 채팅을 할수가 없게된다.
 * 그래서 언제든지 쓰던것을 계속 쓸 수 있도록 InputThread를 사용하여 입력을 받는다.
 * 
 * (2) broadcast()&sendmsg()에서 hm사용법 설명
 * hm(HashMap)에 접속자의 ID를 저장하고, 이를 broadcast()를 통해 hm에 key로 등록되어 있는 모든 사용자 ID에 모두 메세지를 보내게 한다.
 * sendmsg()는 hm에서 귓속말을 보내고자 하는 상대방의 ID와 hm에 등록되어 있는 key값과 비교하여 일치하는 사람에게만 메세지를 전송한다.
 * 
 * (3)
 * broadcast()와 sendmsg()에 전송하는 문자열 앞에 현재 시간을 나타내주는 daytime를 추가
 * 
 * (4)
 * while문을 사용해서 ID를 출력해주고, 총 인원수는 while문 밖으로 빼서 1번만 출력
 * 
 * (5)
 * HashMap에서 ID를 받아와서 if문을 사용 자신과 같은 ID라면 broadcast()에서 메세지 전송에서 제외하려했으나
 * 실패
 * 
 * (6)
 * 욕들의 배열을 만들고 이를 입력하게 되면 ban()을 이용해서 해당 사람에게만 "욕하지마!"라는 문구를 출력
 * 
 * (7) 클라이언트에서 상용구를 HashMap으로 관리하여 사용하게 하는 기능 설계
 * run()에서 if문을 이용 +문자가 입력되면 sendmsg()와 같은 처리를 통해 앞의 "+ 안"을 "# 안"으로 변환하여 put메소드를 이용
 * key값으로 상용구를 사용할 문자(문제 예시에서 "# 안")을 등록하고, 출력해야할 문자(문제 예시에서 "안녕하세요")를 value값으로 하는 HashMap객체 생성,
 * key 문구가 채팅에 입력이되면 run()의 if-else에서 처리를 하여서 value값이 출력되도록 한다.
 * 
 * (8) 클라이언트 및 서버 프로그램에서 파일 전송 기능 설계
 * "$ 파일이름"을 통해서 FileInputStream을 실행하여 해당 파일을 읽어오고, ObjectInputStream을 통해서 객체화를 하고,
 * 이것을 서버에서 전송하고 파일을 받는 사람의 경우 "$ 파일이름"을 수신하면 FileOutputStream과 ObjectOutputStream을 이용해서 파일화 한다.
 */