
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;

public class Interface extends JFrame {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 static int[] ab =new int[2];
     static JFrame frm;
     static JPanel panel ;
     static JLabel labels[];
     static JPanel Down;
     static JPanel Left;
     static JLabel Num[];
     static JLabel Alpha[];   //alphabetic letters  to put down 
     static  Timer timer;
     static JPanel  imp;
     static JButton button1;
     static JButton button2;
     static  JLabel statusLabel; 
	 public Interface(){
	
		   JFrame frm=new JFrame("Schacciera");
		   frm.setLayout(new GridLayout(2, 1));
		    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frm.setSize(700,700);
		    final   JPanel panel = new JPanel(new GridLayout(8,8,0,0));
		    final   JPanel Down=  new JPanel(new GridLayout(1, 8));
		    final  JLabel Alpha[] = new JLabel[8];
		    final  JLabel Num[] = new JLabel[8];
		    final   JPanel Left= new JPanel(new GridLayout(8, 1));
		    final  JLabel labels[] = new JLabel[(8*8)];
		    final JPanel imp= new JPanel(new GridLayout(1, 3));
		    final JButton button1=new JButton("New Game");
		    button1.setPreferredSize(new Dimension(30, 30));
		    button1.setBackground(Color.darkGray);
		    button1.setOpaque(true);
		    final JButton button2=new JButton("Continue");
		    button2.setPreferredSize(new Dimension(30, 30));
		    button2.setBackground(Color.darkGray);
		    button2.setOpaque(true);
		    
		    final JLabel statusLabel= new JLabel("",JLabel.CENTER); 
		    statusLabel.setLayout(null);
		    statusLabel.setBackground(Color.red);
       
          
		    Interface.ab[0]=20;
		    Interface.ab[1]=20;
		    Interface.labels=labels;
            Interface.Alpha=Alpha;
            Interface.Num=Num;
            Interface.Left=Left;
		    Interface.panel=panel;
		    Interface.Down=Down;
		    Interface.imp=imp;
		    Interface.button1=button1;
		    Interface.button2=button2;
		    Interface.statusLabel=statusLabel;
		    
		    
		    Interface.frm=frm;	
		    Interface.panel.addComponentListener(cl);
		    button1.addActionListener(ramin);
		    button2.addActionListener(Countinue);
		    Interface.panel.addMouseListener(new MouseSpy());
		    
}
	static Image getScaledImage(Image srcImg, int w, int h){
		    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();
		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(srcImg, 0, 0, w, h, null);
		    g2.dispose();
		    return resizedImg;
		}
	
	   public static void  showComponentLocations(JPanel panel) {
	        Component[] all = Interface.panel.getComponents();
	        int  a= all[1].getLocation().x-all[0].getLocation().x;
	        int  b= all[8].getLocation().y-all[0].getLocation().y;  
	        ab[0]=a; ab[1]=b;
	    }
 
  ComponentListener cl = new ComponentAdapter() {	
    @Override
    public void componentResized(ComponentEvent ce) {
        
       Interface.showComponentLocations(Interface.panel);
        IniziaBoard.PutPezzi(Color.green);
    }

};
ActionListener ramin=new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       statusLabel.setText("Prima mossa per bianco");
       Scacchiera.posizione.clear();
       Scacchiera.posizione_backup.clear();
       Scacchiera.inizializza();
       Pezzo.turno=false;
       Scacchiera.stampa();
       IniziaBoard.PutPezzi(Color.GREEN);
       
       
    }          
 };
 
 ActionListener Countinue=new ActionListener(){
	 public void actionPerformed(ActionEvent e) {
		
	 try {

		Configuration.load();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();		
	}
    if(Pezzo.turno==false) statusLabel.setText("Prima mossa per bianco");
    else if(Pezzo.turno==true) statusLabel.setText("Prima mossa per nero");
	  IniziaBoard.PutPezzi(Color.orange);
	 Scacchiera.stampa();
	 
	 }
 
 };
     

}
	
	

