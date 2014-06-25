package calculadora2;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomKey  extends JPanel {
	
	public CustomKey(){
		this.setLayout( new GridLayout(4,3,5,5));
		JButton b= new JButton("9");
		b.addMouseListener(new MyListener());
		
		add(b);
		add(new JButton("8"));
		add(new JButton("7"));
		
		add(new JButton("6"));
		add(new JButton("/"));
		add(new JButton("5"));
		add(new JButton("4"));
		add(new JButton("*"));
		add(new JButton("3"));
		add(new JButton("2"));
		add(new JButton("1"));
		add(new JButton("0"));
		add(new JButton("+"));
		add(new JButton("-"));
		add(new JButton("="));

		
		
	}
	
	
	//clase teclado implementes operaciones suma resta divicion multimplicacion 
	
	
	
	
	class MyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton clicked= (JButton)e.getSource();
			if(clicked!=null){
				System.out.println(e);
			}
				
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	

}
