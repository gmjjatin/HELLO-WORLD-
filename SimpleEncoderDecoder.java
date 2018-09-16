package simpleEncoderDecoder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleEncoderDecoder implements ActionListener{
	
	JTextField jtfEncodedText;
	JTextField jtfDecodedText;
	static JLabel jlabDText =new JLabel("Plain Text:");
	static JLabel jlabEText=new JLabel("Encoded Text:");
	static JButton jbtnEText=new JButton("encode it");
	static JButton jbtnDText=new JButton("decode it");
	static JButton jbtnRText=new JButton("reset");
	
	public SimpleEncoderDecoder() {

	 	
		JFrame jfrm=new JFrame("Simple Encoder Decoder");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(340, 120);
		jfrm.setVisible(true);
		
		
	
		jtfDecodedText=new JTextField(20);
		jtfEncodedText=new JTextField(20);
		
		jbtnEText.setActionCommand("encode");
		jbtnDText.setActionCommand("decode");
		jtfEncodedText.setActionCommand("decode");
		jtfDecodedText.setActionCommand("encode");
		
		jbtnEText.addActionListener(this);
		jbtnDText.addActionListener(this);
		jbtnRText.addActionListener(this);
		jtfEncodedText.addActionListener(this);
		jtfDecodedText.addActionListener(this);
		char[] a= {67,11,0,65535};
		System.out.println('6');
		System.out.println('0');
		System.out.println(a[0]);
		
		
		
		jfrm.add(jlabDText);
		jfrm.add(jtfDecodedText);
		jfrm.add(jlabEText);
		jfrm.add(jtfEncodedText);
		jfrm.add(jbtnEText);
		jfrm.add(jbtnDText);
		jfrm.add(jbtnRText);
	
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("encode")) {
			StringBuilder str=new StringBuilder(jtfDecodedText.getText());
			
			for (int i = 0; i < str.length(); i++) {
				str.setCharAt(i,(char)((str.charAt(i)*3+1)%65535));
			}
			jtfEncodedText.setText(str.toString());
		}
		else if (ae.getActionCommand().equals("decode")) {
			StringBuilder str=new StringBuilder(jtfEncodedText.getText());
			
			for (int i = 0; i < str.length(); i++) {
				int ch=((str.charAt(i)-1)/3)%65535;
				if (ch<0) {
					ch=ch*(-1);
					}
				str.setCharAt(i,(char)ch);
			}
			jtfDecodedText.setText(str.toString());
			
		}
		else {
			jtfEncodedText.setText("");
			jtfDecodedText.setText("");
		}
		
		
	}
	public static void main(String[] args) {

		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new SimpleEncoderDecoder();
			}
		});
	}

}
