package Main;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PasswordChecker {
	static PasswordChecker checker;
	JFrame window;
	JTextField textField;
	JLabel restrictionList;
	JLabel lengthRest, numberRest, symbolRest, captRest;
	String passString = "";

	public static void main(String[] args) {
		checker = new PasswordChecker();
	}
	
	public PasswordChecker(){
		window = new JFrame("Simple Password Checker");
		
		window.setSize(400, 160);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setResizable(false);
		window.setLayout(null);
		
		textField = new JTextField("enter password here...");
		textField.setBounds(10, 100, 200, 20);
		
		restrictionList = new JLabel("<html>Use the list to the<br>right, and create a<br>password.");
		restrictionList.setBounds(10, 10, 110, 50);
		
		lengthRest = new JLabel("8 characters");
		numberRest = new JLabel("2 numbers");
		symbolRest = new JLabel("?!@#$%&");
		captRest = new JLabel("1 uppercase");
		lengthRest.setBounds(290, 10, 100, 20);
		numberRest.setBounds(290, 30, 100, 20);
		symbolRest.setBounds(290, 50, 100, 20);
		captRest.setBounds(290, 70, 100, 20);
		
		textField.addFocusListener(new textListener());
		textField.addKeyListener(new keyListener());
		
		window.getContentPane().add(restrictionList);
		window.getContentPane().add(textField);
		window.getContentPane().add(lengthRest);
		window.getContentPane().add(numberRest);
		window.getContentPane().add(symbolRest);
		window.getContentPane().add(captRest);
		window.setVisible(true);
	
	}
	class textListener implements FocusListener{
		public void focusGained(FocusEvent arg0) {
			textField.setText("");
		}
		public void focusLost(FocusEvent arg0) {
		}		
	}
	class keyListener implements KeyListener{
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
		}
		public void keyTyped(KeyEvent arg0) {
			setColors();
		}
	}
	private void setColors(){
		passString = textField.getText();
		System.out.println("string before setColors: " + passString);
		if(!passString.equals(passString.toLowerCase())){
			captRest.setForeground(Color.GREEN);
			System.out.println("green reached");
		}
		else{
			captRest.setForeground(Color.RED);
			System.out.println("red reached");
		}
		lengthRest.setForeground(Color.RED);
		symbolRest.setForeground(Color.RED);
		numberRest.setForeground(Color.RED);
		//can also use html like multiline label
		//ex. lengthRest.setText("<html><font color = 'red'> this is red</font></html>");
	}
	
}
