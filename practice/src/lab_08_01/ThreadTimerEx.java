package lab_08_01;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx(){
		setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
		setSize(250, 150);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}