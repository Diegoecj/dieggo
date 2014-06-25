package mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	private ArrayList<FormEvent> myList;
	
	DateBaseLayer dbl;
	
	public MainFrame() {
		super("EMPRESA PRIVADA DEL MZ.");
		dbl=new DateBaseLayer();
		setLayout(new BorderLayout());
		myList = new ArrayList<FormEvent>();
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		
		
		//toolbar.setTextPanel(textPanel);
		toolbar.setArrayList(myList);
		
		toolbar.setStringListener(new StringListener(){
			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
			}
		});
		
		toolbar.setArrayFormListener(new ArrayFormListener(){

			@Override
			public void arrayEmitted(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				if(dbl.isConnected()){
					ArrayList<FormEvent> Lista = dbl.resultqueryExec("select * from trabajador");
					
					for(FormEvent fe:Lista){
						textPanel.appendText("NOMBRE:"+fe.getName()+"\n" + 
								"OCUPACION:"+fe.getOccupation()+"\n"+
								"Empleado:"+fe.getEmpleadotexto()+"\n"+
								"RANGO EDAD:"+fe.getRangoedad()+"\n"+
								"Genero:"+" "+fe.getGenero()+"\n"+
								"NACIONALIDAD:"+fe.getChec()+"\n"+fe.getChec2()+"\n"+"--------------------------------------------"+"\n");
					
					 }
				}
			}
				
		});
		
		formPanel.setFormListener(new FormListener(){
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				myList.add(e);
				
				//String name = e.getName();
				//String occupation = e.getOccupation();
				//textPanel.appendText(name + ": " + occupation +"\n");	
			
				if (dbl.isConnected()){
					int edad=18;
					String sql="INSERT INTO trabajador" + " (nombre,ocupacion,edad,genero,pais,tipo_empleado) "+
						"VAlUES('"+e.getName()+"','"+e.getOccupation()+"','"+edad+"','"+e.getGenero()+"','"+e.getChec()+"','"+e.getEmpleadotexto()+"')";
					dbl.queryExect(sql);
				}
				
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});
		
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
