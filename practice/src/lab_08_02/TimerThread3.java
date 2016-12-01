package lab_08_02;

public class TimerThread3 extends Thread{
	int[] n;
	public TimerThread3(int[] hundread){
		this.n = hundread;
	}
	public void run(){
		int i = 0;
		int[] hundread = {100, 200, 300};
		while(i < hundread.length){
			System.out.println(hundread[i]);
			i++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}
