package mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel  extends JPanel{
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField occupationField;
	private JTextField nameField;
	private JButton okBtn;
	private JButton imprimir;
	
	private FormListener formListener;
	
	
	public FormPanel(){
		
		Dimension  dim= getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);
		
		nameLabel=new JLabel("nombre");
		occupationLabel=new JLabel("ocupacion");
		nameField=new JTextField(10);
		occupationField=new JTextField(10); 
		okBtn=new JButton("OK");
		okBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name =nameField.getText();
				String occupation = occupationField.getText();
				FormEvent ev=new FormEvent(this,name ,occupation);
				if(formListener!=null){
					formListener.FormEventOcurred(ev);
				}
				
				
				
			}
			
		});
		
		
		
		Border innerBorder=BorderFactory.createTitledBorder("agregar persona");
		Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc= new  GridBagConstraints();
		
		
		
		/////////////////////////First row /////////////
		
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.gridy=0;
		
		 gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,5);
		add(nameLabel,gc);
		 
		 
		 
		 
		 gc.gridx=1;
		 gc.gridy=0;
		 gc.insets=new Insets(0,0,0,0);
		 gc.anchor=GridBagConstraints.LINE_START;
		 add(nameField,gc);
		 
		 ///////////////////////// second row/////////
		 
		 gc.weightx=1;
		 gc.weighty=0.1;
		 
		 gc.gridx=0;
		 gc.gridy=1;
		 gc.insets=new Insets(0,0,0,5);
		 gc.anchor=GridBagConstraints.LINE_END;
		 add(occupationLabel,gc);
		 
		 gc.gridx=1;
		 gc.gridy=1;
		 gc.insets=new Insets(0,0,0,0);
		 gc.anchor=GridBagConstraints.LINE_START;
		 add(occupationField,gc);
		 
		 ///////////// third row//////////////////////
		
		 gc.weightx=1;
		 gc.weighty=2.0;
		 
		 
		 gc.gridx=1;
		 gc.gridy=2;
		 gc.insets=new Insets(0,0,0,5);
		 gc.anchor=GridBagConstraints.FIRST_LINE_START;
		 add(okBtn,gc);
		 
	}
	
	
	public void setFormListener(FormListener listener){
		this.formListener=listener;
		
		
	}
	
	
	
}
