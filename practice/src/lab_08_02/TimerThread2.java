package lab_08_02;

public class TimerThread2 extends Thread{
	int[] n;
	public TimerThread2(int[] ten){
		this.n = ten;
	}
	public void run(){
		int i = 0;
		int[] ten = {10, 20, 30, 40, 50};
		while(i < ten.length){
			System.out.println(ten[i]);
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
