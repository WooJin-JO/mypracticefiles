package lab_08_01;

import javax.swing.JLabel;

class TimerThread extends Thread {
	JLabel timerLabel;
	public TimerThread(JLabel timerLabel){
		this.timerLabel = timerLabel;
	}
	public void run(){
		int n = 0;
		while(true){
			timerLabel.setText(Integer.toString(n));
			n++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}