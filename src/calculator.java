import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.text.NumberFormat;
import java.awt.event.*;
public class calculator extends JFrame {
	JButton butt;
	JLabel lb1,lb2,lb3;
	JTextField tf1,tf2;
	JCheckBox dollarSign,commaSeparator;
	JRadioButton addNums,subtractNum,multNum,dividNumber;
	JSlider howManyTimes;
	double number1,number2,totalCalc;
	
	
	public static void main(String []args){
		new calculator();
		
	}
	public calculator(){
		this.setSize(400,400);
		
		this.setTitle("S_Calculator");
		JPanel pan=new JPanel();
		butt=new JButton("calculate");
		ListenForButton lfb=new ListenForButton();
		butt.addActionListener(lfb);
		pan.add(butt);
		lb1=new JLabel("first");
		pan.add(lb1);
		
		
		
		tf1=new JTextField("",5);
		pan.add(tf1);
		
		lb2=new JLabel("second");
		pan.add(lb2);
		
		tf2=new JTextField("",5);
		pan.add(tf2);
		
		
		dollarSign=new JCheckBox("Dollar");
		commaSeparator=new JCheckBox("Commas");
		
		pan.add(dollarSign);
		pan.add(commaSeparator, true);
		
		addNums=new JRadioButton("Add");
		subtractNum=new JRadioButton("Subtract");
		multNum=new JRadioButton("Multiply");
		dividNumber=new JRadioButton("Divide");
		
		ButtonGroup operation=new ButtonGroup();
		operation.add(addNums);
		operation.add(subtractNum);
		operation.add(multNum);
		operation.add(dividNumber);
		
		JPanel pan2=new JPanel();
		Border bd=BorderFactory.createTitledBorder("Operation");
		pan2.setBorder(bd);
		pan2.add(addNums);
		pan2.add(subtractNum);
		pan2.add(multNum);
		pan2.add(dividNumber);
		
		addNums.setSelected(true);
	
		
		pan.add(pan2);
		
		lb3=new JLabel("Perform how many times");
		pan.add(lb3);
		
		howManyTimes =new JSlider(0,99,1);
		howManyTimes.setMinorTickSpacing(1);
		howManyTimes.setMajorTickSpacing(10);
		howManyTimes.setPaintTicks(true);
	
		pan.add(howManyTimes);
		
		ListenForSlider lfs =new ListenForSlider();
		howManyTimes.addChangeListener(lfs);
		
		
		
		this.add(pan);
		this.setVisible(true);
				}
	
	
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==butt){
				try{
					number1=Double.parseDouble(tf1.getText());
					number2=Double.parseDouble(tf2.getText());
				}
				catch(NumberFormatException ec){
					JOptionPane.showMessageDialog(calculator.this, "Please enter both number","error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(addNums.isSelected()){
				totalCalc =addNumbers(number1,number2,howManyTimes.getValue());
			}
			else if(subtractNum.isSelected()){
				totalCalc =subNumbers(number1,number2,howManyTimes.getValue());
			}
			else if(multNum.isSelected()){
				totalCalc =multNumbers(number1,number2,howManyTimes.getValue());
			}
			else {
				totalCalc =divNumbers(number1,number2,howManyTimes.getValue());
			}
			if(dollarSign.isSelected()){
				NumberFormat nf=NumberFormat.getCurrencyInstance();
				JOptionPane.showMessageDialog(calculator.this,nf.format(totalCalc),"Solution",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(commaSeparator.isSelected()){
				NumberFormat nf=NumberFormat.getNumberInstance();
				JOptionPane.showMessageDialog(calculator.this,nf.format(totalCalc),"Solution",JOptionPane.INFORMATION_MESSAGE);
			}else{
				
				JOptionPane.showMessageDialog(calculator.this,totalCalc,"Solution",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private class ListenForSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			if(e.getSource()==howManyTimes){
				lb3.setText("Perform How many Times?"+howManyTimes.getValue());
			}
		
		}
		
	}
	public static double addNumbers(double x,double y,double z){
		double total=(x+y)*z;
		return total;
	}
	public static double subNumbers(double x,double y,double z){
		double total=0;
		int i=0;
		while(i<z){
			total=total+(x-y);
			i++;
		}
		return total;
	}
	public static double divNumbers(double x,double y,double z){
		double total=0;
		int i=0;
		while(i<z){
			total=total+(x/y);
			i++;
		}
		return total;
	}
	public static double multNumbers(double x,double y,double z){
		double total=0;
		int i=0;
		while(i<z){
			total=total+(x*y);
			i++;
		}
		return total;
	}
	
	
	
	
	
	
	
	
	

}
