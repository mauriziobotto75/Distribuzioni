
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class IniziaBoard  {
	
	public static  void PutLyout(Color c){
	
		 Border border = LineBorder.createGrayLineBorder();
	  for( int i=0;i<64;i++){
	  	Interface.labels[i] = new JLabel();
	  	Interface.labels[i].setBorder(border);
	  	if(i<8){
	  	if ((i%2!=0)){
	  	Interface.labels[i].setBackground(c);
	  	Interface.labels[i].setOpaque(true);
	  	 }
	  	}
	  	if(7<i&&i<16){
	  		if ((i%2==0)){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }
	  	}
	  	if(15<i&&i<24){
	  		if (i%2!=0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}
	  	if(23<i&&i<32){
	  		if (i%2==0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}
	  	if(31<i&&i<40){
	  		if (i%2!=0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}
	  	if(39<i&&i<48){
	  		if (i%2==0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}
	  	if(47<i&&i<56){
	  		if (i%2!=0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}
	  	if(55<i&&i<64){
	  		if (i%2==0){
	  			Interface.labels[i].setBackground(c);
	  			Interface.labels[i].setOpaque(true);
	  			 }	
	  	}   	
	  	Interface.panel.add(Interface.labels[i]);	      
	  }
	   Interface.Alpha[0]=new JLabel("A");
	   Interface.Down.add(Interface.Alpha[0]);
	   Interface.Alpha[1]=new JLabel("B");
	   Interface.Down.add(Interface.Alpha[1]);
	   Interface.Alpha[2]=new JLabel("C");
	   Interface.Down.add(Interface.Alpha[2]);
	   Interface.Alpha[3]=new JLabel("D");
	   Interface.Down.add(Interface.Alpha[3]);
	   Interface.Alpha[4]=new JLabel("E");
	   Interface.Down.add(Interface.Alpha[4]);
	   Interface.Alpha[5]=new JLabel("F");
	   Interface.Down.add(Interface.Alpha[5]);
	   Interface.Alpha[6]=new JLabel("G");
	   Interface.Down.add(Interface.Alpha[6]);
	   Interface.Alpha[7]=new JLabel("H");
	   Interface.Down.add(Interface.Alpha[7]);
	   
	   Interface.Num[7]=new JLabel("8");
	   Interface.Left.add(Interface.Num[7]);
	   Interface.Num[6]=new JLabel("7");
	   Interface.Left.add(Interface.Num[6]);
	   Interface.Num[5]=new JLabel("6");
	   Interface.Left.add(Interface.Num[5]);
	   Interface.Num[4]=new JLabel("5");
	   Interface.Left.add(Interface.Num[4]);
	   Interface.Num[3]=new JLabel("4");
	   Interface.Left.add(Interface.Num[3]);
	   Interface.Num[2]=new JLabel("3");
	   Interface.Left.add(Interface.Num[2]);
	   Interface.Num[1]=new JLabel("2");
	   Interface.Left.add(Interface.Num[1]);
	   Interface.Num[0]=new JLabel("1");
	   Interface.Left.add(Interface.Num[0]);
	   
	   Interface.frm.setLayout(new BorderLayout());
	   Interface.frm.add(Interface.Left,BorderLayout.WEST);
	   Interface.frm.add(Interface.panel);
	   Interface.frm.add(Interface.Down,BorderLayout.SOUTH);
	   Interface.imp.add(Interface.button1);
	   Interface.imp.add(Interface.button2); 
	   Interface.imp.add(Interface.statusLabel);
  	   Interface.frm.add(Interface.imp,BorderLayout.NORTH);
  	   
	   Interface.frm.setVisible(true);	  
}
	public static void PutPezzi(Color ca){	
	
		final ImageIcon Pedone_B = new ImageIcon("1.PNG")  ;
		final ImageIcon Pedone_N = new ImageIcon("2.PNG")  ;
		final ImageIcon RE_B = new ImageIcon("3.PNG")  ;
		final ImageIcon RE_N = new ImageIcon("4.PNG")  ;
		final ImageIcon REG_B = new ImageIcon("5.PNG")  ;
		final ImageIcon REG_N = new ImageIcon("6.PNG")  ;
		final ImageIcon T_B = new ImageIcon("7.PNG")  ;
		final ImageIcon T_N = new ImageIcon("8.PNG")  ;
		final ImageIcon A_B = new ImageIcon("9.PNG")  ;
		final ImageIcon A_N = new ImageIcon("10.PNG")  ;
		final ImageIcon C_B = new ImageIcon("11.PNG")  ;
		final ImageIcon C_N = new ImageIcon("12.PNG")  ;
		 
		
	    	Interface.panel.removeAll();
	        Interface.Down.removeAll();
	        Interface.Left.removeAll();
	    	IniziaBoard.PutLyout(ca);

		for(Casella c:Scacchiera.posizione){
			
			if((c.pezzo.nome.equals("P1B"))||(c.pezzo.nome.equals("P0B"))||(c.pezzo.nome.equals("P2B"))||(c.pezzo.nome.equals("P3B"))||(c.pezzo.nome.equals("P4B"))
					||(c.pezzo.nome.equals("P5B"))||(c.pezzo.nome.equals("P6B"))||(c.pezzo.nome.equals("P7B"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(Pedone_B.getImage(), Interface.ab[0], Interface.ab[1]));	
			    Interface.labels[c.x*8+c.y].setIcon(icon1);	          
			}
			else if ((c.pezzo.nome.equals("P1N"))||(c.pezzo.nome.equals("P0N"))||(c.pezzo.nome.equals("P2N"))||(c.pezzo.nome.equals("P3N"))||(c.pezzo.nome.equals("P4N"))
					||(c.pezzo.nome.equals("P5N"))||(c.pezzo.nome.equals("P6N"))||(c.pezzo.nome.equals("P7N"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(Pedone_N.getImage(), Interface.ab[0],Interface.ab[1]));	
			     Interface.labels[c.x*8+c.y].setIcon(icon1);     	
			}
			else if (c.pezzo.nome.equals("ReB")){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(RE_B.getImage(), Interface.ab[0], Interface.ab[1]));	
			    Interface.labels[c.x*8+c.y].setIcon(icon1);           				
			}
			else if (c.pezzo.nome.equals("ReN")){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(RE_N.getImage(),  Interface.ab[0], Interface.ab[1]));	
			    Interface.labels[c.x*8+c.y].setIcon(icon1);           				
			}
			else if  (c.pezzo.nome.equals("RGB")){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(REG_B.getImage(),  Interface.ab[0], Interface.ab[1]));
			    Interface.labels[c.x*8+c.y].setIcon(icon1);			
			}
			 if  (c.pezzo.nome.equals("RGN")){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(REG_N.getImage(),  Interface.ab[0], Interface.ab[1]));
			    Interface.labels[c.x*8+c.y].setIcon(icon1);	
			}
			 
			else if  ((c.pezzo.nome.equals("T1B"))||(c.pezzo.nome.equals("T2B"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(T_B.getImage(),  Interface.ab[0], Interface.ab[1]));	
			    Interface.labels[c.x*8+c.y].setIcon(icon1); 		
			}
			else if  ((c.pezzo.nome.equals("T3N"))||(c.pezzo.nome.equals("T4N"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(T_N.getImage(),  Interface.ab[0], Interface.ab[1]));	
			    Interface.labels[c.x*8+c.y].setIcon(icon1);		
			}
			else if  ((c.pezzo.nome.equals("A1B"))||(c.pezzo.nome.equals("A2B"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(A_B.getImage(), Interface.ab[0], Interface.ab[1]));
			    Interface.labels[c.x*8+c.y].setIcon(icon1);
    		
			}
			else if  ((c.pezzo.nome.equals("A3N"))||(c.pezzo.nome.equals("A4N"))){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(A_N.getImage(),  Interface.ab[0], Interface.ab[1]));
			    Interface.labels[c.x*8+c.y].setIcon(icon1);
	          		
			}
			else if  (c.pezzo.nome.equals("C1B")||c.pezzo.nome.equals("C2B")){
				ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(C_B.getImage(),  Interface.ab[0], Interface.ab[1]));
			    Interface.labels[c.x*8+c.y].setIcon(icon1);
			}  
		    else if  (c.pezzo.nome.equals("C3N")||c.pezzo.nome.equals("C4N")){
			    ImageIcon icon1 = new ImageIcon(Interface.getScaledImage(C_N.getImage(),  Interface.ab[0], Interface.ab[1]));
				   Interface.labels[c.x*8+c.y].setIcon(icon1);
		  }
			     Interface.frm.add(Interface.panel);
		         Interface.frm.setVisible(true);	
		}	
	
}

	public static  void sottoScaccoShowMode(Color c){
			if (Pezzo.showMode==4){	
				for(int i=Pezzo.posizioneRe.x; i>Pezzo.posizionePezzo.x-1;i--){
					Interface.labels[i*8+Pezzo.posizioneRe.y].setBackground(c);
		  			Interface.labels[i*8+Pezzo.posizioneRe.y].setOpaque(true);
		  	
				}
				  System.out.println("Il Re e Sotto scacco Dalla Torre !");
			
				Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Torre !");
					
		    	}
			
				else if (Pezzo.showMode==1){
					for(int i=Pezzo.posizioneRe.x; i<Pezzo.posizionePezzo.x+1;i++){
						Interface.labels[i*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[i*8+Pezzo.posizioneRe.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Torre !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Torre !");
				}
				else if (Pezzo.showMode==2){
					for(int i=Pezzo.posizioneRe.y; i<Pezzo.posizionePezzo.y+1;i++){
						Interface.labels[Pezzo.posizioneRe.x*8+i].setBackground(c);
			  			Interface.labels[Pezzo.posizioneRe.x*8+i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Torre !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Torre !");
				}
				else if (Pezzo.showMode==3){
					for(int i=Pezzo.posizioneRe.y; i>Pezzo.posizionePezzo.y-1;i--){
						Interface.labels[Pezzo.posizioneRe.x*8+i].setBackground(c);
			  			Interface.labels[Pezzo.posizioneRe.x*8+i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Torre !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Torre !");
				}
				else if (Pezzo.showMode==5){
				
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x)+1;i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x+i)*8+Pezzo.posizionePezzo.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8+Pezzo.posizionePezzo.y+i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Alfiere !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Alfiere !");
				}
				else if (Pezzo.showMode==6){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y+i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Alfiere !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Alfiere !");
				}
              else if (Pezzo.showMode==7){
					
					for(int i=0; i<(Pezzo.posizionePezzo.y-Pezzo.posizioneRe.y)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y+i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Alfiere !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Alfiere !");
				}
               else if (Pezzo.showMode==8){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y-i].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dalla Alfiere !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Alfiere !");
				}
               else if (Pezzo.showMode==9){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x);i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y].setOpaque(true);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8-8+Pezzo.posizionePezzo.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==10){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x);i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y].setOpaque(true);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8-8+Pezzo.posizionePezzo.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==11){
					
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x);i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setOpaque(true);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8-8+Pezzo.posizionePezzo.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==12){
					
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x);i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setOpaque(true);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8-8+Pezzo.posizionePezzo.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==13){
					
					for(int i=0; i<(Pezzo.posizioneRe.y-Pezzo.posizionePezzo.y);i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y+i].setOpaque(true);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==14){
					
					for(int i=0; i<(Pezzo.posizionePezzo.y-Pezzo.posizioneRe.y);i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y-i].setOpaque(true);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==15){
					
					for(int i=0; i<(Pezzo.posizionePezzo.y-Pezzo.posizioneRe.y);i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y-i].setOpaque(true);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==16){
					
					for(int i=0; i<(Pezzo.posizioneRe.y-Pezzo.posizionePezzo.y);i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y+i].setOpaque(true);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setOpaque(true);
					}
					System.out.println("Il Re e Sotto scacco Dal Cavallo !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Cavallo !");
				}
               else if (Pezzo.showMode==17){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x)+1;i++)
					{
						Interface.labels[(Pezzo.posizionePezzo.x-i)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x-i)*8+Pezzo.posizionePezzo.y].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==18){
					
					for(int i=0; i<(Pezzo.posizionePezzo.y-Pezzo.posizioneRe.y)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y+i].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==19){
					
					for(int i=0; i<(Pezzo.posizioneRe.y-Pezzo.posizionePezzo.y)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y-i].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==20){
					
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x)+1;i++)
					{
						Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==21){
					
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x)+1;i++)
					{   
						Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x-i)*8+Pezzo.posizioneRe.y-i].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==22){
					
					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x)+1;i++)
					{   
						Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y+i].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x+i)*8+Pezzo.posizioneRe.y+i].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==23){
					
					for(int i=0; i<(Pezzo.posizioneRe.x-Pezzo.posizionePezzo.x)+1;i++)
					{   
						Interface.labels[(Pezzo.posizionePezzo.x+i)*8+Pezzo.posizionePezzo.y-i].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x+i)*8+Pezzo.posizionePezzo.y-i].setOpaque(true);
			 
					}
					System.out.println("Il Re e Sotto scacco Dalla Regina !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
				}
               else if (Pezzo.showMode==24){
					
     					for(int i=0; i<(Pezzo.posizionePezzo.x-Pezzo.posizioneRe.x)+1;i++)
     					{   
     						Interface.labels[(Pezzo.posizionePezzo.x-i)*8+Pezzo.posizionePezzo.y+i].setBackground(c);
     			  			Interface.labels[(Pezzo.posizionePezzo.x-i)*8+Pezzo.posizionePezzo.y+i].setOpaque(true);  			 
     					}
     					System.out.println("Il Re e Sotto scacco Dalla Regina !");
     					Interface.statusLabel.setText("Il Re e Sotto scacco Dalla Regina !");
     				}

               else if (Pezzo.showMode==25||Pezzo.showMode==26||Pezzo.showMode==27||Pezzo.showMode==28){
					
						Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizionePezzo.x)*8+Pezzo.posizionePezzo.y].setOpaque(true);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setBackground(c);
			  			Interface.labels[(Pezzo.posizioneRe.x)*8+Pezzo.posizioneRe.y].setOpaque(true);
			 
					
					System.out.println("Il Re e Sotto scacco Dal Pedone !");
					Interface.statusLabel.setText("Il Re e Sotto scacco Dal Pedone !");
				}
              
	  
	  
			}	
     }

 