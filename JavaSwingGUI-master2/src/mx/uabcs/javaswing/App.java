package mx.uabcs.javaswing;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				//ArrayList<FormEvent> Lista =new ArrayList<FormEvent>();
				
				//FormEvent P = Lista.get(0);
				//Lista.add(new FormEvent("","diego","castro"));
				
				/*for(FormEvent p: Lista){
					
					System.out.println(p.getName()+" ____"+p.getOcupation());

				}*/
				
				new MainFrame();
				

				
				
				

			}
		});	
	}

}
