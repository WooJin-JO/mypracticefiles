package lab_08_02;

public class LabEx {
	public static void main(String[] args) {
		int[] one = null;
		int[] ten = null;
		int[] hundread = null;
		Thread th1 = new TimerThread1(one);
		Thread th2 = new TimerThread2(ten);
		Thread th3 = new TimerThread3(hundread);
		
		th1.start();
		th2.start();
		th3.start();
	}
}
