package lab_08_02;

class TimerThread1 extends Thread{
	int[] n;
	public TimerThread1(int[] one){
		this.n = one;
	}
	public void run(){
		int i = 0;
		int[] one = {1, 2, 3, 4, 5, 6, 7, 8};
		while(i < one.length){
			System.out.println(one[i]);
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

