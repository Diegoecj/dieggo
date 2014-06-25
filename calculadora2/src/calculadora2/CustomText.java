package calculadora2;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CustomText  extends JPanel{

	
	JTextArea text;
	private int x;
	private int y;
	
	public CustomText(){
		setLayout(new BorderLayout());
		text= new  JTextArea();
		add(text);
		add(text,BorderLayout.CENTER);	
		
		
	}
	

}
