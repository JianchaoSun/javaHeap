import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.*;
public class learn extends JFrame {
	JButton button1;
	JTextField textField;
	JTextArea textArea;
	int buttonClicked;
	
	
	
	
	
	
	
	public static void main (String[]args){
		new learn();
	}
	public learn(){
		this.setSize(500,500);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		this.setTitle("S Frame");
		
		
		
		JPanel pan=new JPanel();
		JLabel label=new JLabel("there is a button");
				pan.add(label);
				label.setToolTipText("this is very useful");
		JButton butt=new JButton("a button");
		butt.setToolTipText("this ");
		pan.add(butt);
		
		
		this.add(pan);
		JTextField tf=new JTextField("type here",12);
		pan.add(tf);
		JTextArea ta= new JTextArea(13,22);
		int numberOfLines=ta.getLineCount();
		ta.append("number of lines is "+numberOfLines);
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);
		JScrollPane sb=new JScrollPane(ta);
		
		pan.add(ta);
	    pan.add(sb);
		this.setVisible(true);
		
		
		
	}
	
}
