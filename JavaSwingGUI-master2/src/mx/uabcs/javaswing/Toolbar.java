package mx.uabcs.javaswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener{
	
	private JButton helloButton;
	private JButton goodbyeButton;
	private JButton imprimir;

	private ArrayList<FormEvent> myList;
	
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		imprimir= new JButton("IMPRIMIR");
		

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
		add(imprimir);
		

	}
	
	
	public void setArrayList(ArrayList<FormEvent>list){
		this.myList=list;
	}
	public void setArrayFormListener(){
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
}
