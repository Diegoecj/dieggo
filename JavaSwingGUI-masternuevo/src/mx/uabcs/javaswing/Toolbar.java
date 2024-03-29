package mx.uabcs.javaswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener {
	private JButton helloButton;
	private JButton goodbyeButton;
	private JButton mostrarInfo;
	private JButton eliminar;
	DateBaseLayer dbl;
	//private TextPanel textPanel;
	private ArrayList<FormEvent> myList;
	
	private StringListener textListener;
	private ArrayFormListener arrayListener;
	
	public Toolbar() {
		dbl=new DateBaseLayer();
		helloButton = new JButton("HOLA");
		goodbyeButton = new JButton("ADIOS");
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		mostrarInfo = new JButton("Mostrar");
		mostrarInfo.addActionListener(this);
		eliminar = new JButton ("ELIMINAR");
		eliminar.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloButton);
		add(goodbyeButton);
		add(mostrarInfo);
		add(eliminar);
	}
	
	
	
	public void setArrayList(ArrayList<FormEvent> list){
		this.myList = list;
	}
	
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}
	
	public void setArrayFormListener(ArrayFormListener listener){
		this.arrayListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		if(clicked == helloButton){
			//textPanel.appendText("Hello\n");
			if(textListener!= null){
				textListener.textEmitted("Hello\n");
			}
		}else if(clicked == goodbyeButton){
			//textPanel.appendText("Goodbye\n");
			if(textListener!= null){
				textListener.textEmitted("Goodbye\n");
			}
		}else if(clicked == mostrarInfo){
			//textPanel.appendText("Goodbye\n")
			if(arrayListener!= null){
				//textListener.textEmitted("Goodbye\n");
				arrayListener.arrayEmitted(this.myList);
				//System.out.println(myList);
			
					
				}
				
			
		}
		
			}
		
	
}


