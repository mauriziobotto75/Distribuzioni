
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;



public class Main extends JFrame {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		  
		//Scacchiera.inizializza();
		  Interface ramin=new Interface();
		  Interface.statusLabel.setText("Benvenuto :) ");
		  IniziaBoard.PutLyout(Color.pink);
			
			
		  Client c=new Client();
			while (true){
				
				c.connetti();
				c.Comunica();
			}
		         
}
}