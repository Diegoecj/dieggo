import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends JPanel {
	
	
	private JTextArea textArea;
	private JTextArea textArea2;
	private JButton btn;
	private JButton btn2;

	
	//constructor
	public TextPanel(){
		
		setLayout(new BorderLayout());
		btn=new JButton("1");
		btn2=new JButton("2");
			
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("1");
				//textArea2.append("3");

			}
			
		});
		
		textArea=new JTextArea();
		textArea2=new JTextArea();

		add(btn,BorderLayout.SOUTH);
		add(btn2,BorderLayout.WEST);

		add(new JScrollPane(textArea),BorderLayout.NORTH);
		
		//add(new JScrollPane(textArea2),BorderLayout.CENTER);

		
	}

	
	

}
