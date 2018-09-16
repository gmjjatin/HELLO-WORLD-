package stopwatch;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;



public class StopWatch implements ActionListener{

	 Long start;
	 JLabel jlab;
	 
	 public StopWatch() {
	
		 JFrame jfrm=new JFrame("Simple StopWatch");
		 jfrm.setSize(250, 120);
		 jfrm.getContentPane().setLayout(new FlowLayout());
		 jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jfrm.setVisible(true);
		 
		 
		 JButton btnstart=new JButton("Start");
		 JButton btnstop=new JButton("Stop");
		 btnstart.addActionListener((ActionListener) this);
		 btnstop.addActionListener((ActionListener) this);
		 
		 jlab=new JLabel("Press start to begin the stopwatch");
		 
		 jfrm.getContentPane().add(btnstart);
		 jfrm.getContentPane().add(btnstop);
		 jfrm.getContentPane().add(jlab);
		 
	 }
	 public static void main(String[] args) {
		 
		 SwingUtilities.invokeLater(new Runnable() {
			 
			 @Override
			public void run() {
				 new StopWatch();
				 
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Calendar cal=Calendar.getInstance();
		
		if(e.getActionCommand().equals("Start")) {
			start=cal.getTimeInMillis();
			jlab.setText("Stopwatch is running...");
			
		}else {
			jlab.setText("Time elapsed is : " +(double)(cal.getTimeInMillis()-start)/1000+" seconds");
			
		}
		
	}
}
