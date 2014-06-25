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
	
	ArrayList<FormEvent> Lista =new ArrayList<FormEvent>();
	
	public MainFrame() {
		super("Hello World");
		
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		textPanel = new TextPanel();
		formPanel=new FormPanel();
	
		
		
		formPanel.setFormListener(new FormListener(){

			@Override
			public void FormEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				
				String name = e.getName();
				String occupation= e.getOcupation();
				textPanel.appendText(name+":"+ "   " +occupation +"\n");
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
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
