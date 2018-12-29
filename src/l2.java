import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
public class l2 extends JFrame{
	JButton butt;
	JTextField tf;
	JTextArea ta;
	int buttonClicked;
	
	public static void main(String[]args){
		new l2();
	}
	public l2(){
		
		this.setSize(900,900);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		this.setTitle("S Frame");
		
		JPanel pan=new JPanel();
		JLabel label=new JLabel("there is a button");
		pan.add(label);
		label.setToolTipText("this is very useful");
        butt=new JButton("a button");
        butt.setToolTipText("this ");
        
        ListenForButton lfb=new ListenForButton();
        butt.addActionListener(lfb);
        pan.add(butt);
 
        ListenForWindow lfw=new ListenForWindow();
        this.addWindowListener(lfw);
        

    this.add(pan);
    tf=new JTextField("type here",12);
    ListenForKeys  lfk=new ListenForKeys();
    tf.addKeyListener(lfk);
    
     pan.add(tf);
 ta= new JTextArea(13,22);
int numberOfLines=ta.getLineCount();
ta.append("number of lines is "+numberOfLines);
ta.setWrapStyleWord(true);
ta.setLineWrap(true);
JScrollPane sb=new JScrollPane(ta);
     ListenForMouse lfm=new ListenForMouse();
     pan.addMouseListener(lfm);

pan.add(ta);
pan.add(sb);
this.setVisible(true);
}
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==butt){
				buttonClicked++;
				ta.append("button clicked "+buttonClicked+" times");
				
			}
			}
		}
	private class ListenForKeys implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			ta.append("Key hit: "+e.getKeyChar()+"\n");
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ListenForWindow implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			ta.append("windows is opened \n");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			ta.append("window is minimized \n");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			ta.append("window is in normal state \n");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			ta.append("window is active \n");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			ta.append("window is not active \n");
			
		}
		
	}
	private class ListenForMouse implements MouseListener{
int click=0;
		@Override
		public void mouseClicked(MouseEvent e) {
			click++;
			ta.append("mouse clicked "+click);
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
		
	
	
}