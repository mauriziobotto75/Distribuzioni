
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MouseSpy  implements MouseListener {
     static int index1;
     static int index2;
 	static  int x1;
	static  int  y1;
	static  int x2;
	static  int  y2;
	static boolean status=false;

	@Override
	 public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {

		    // TODO Auto-generated method stub
	int  index_x=(int)(e.getX()/Interface.ab[0]+1);
	int  index_y=(int)(e.getY()/Interface.ab[1]+1);
		int index=	(index_y*8-8+index_x)-1;
		MouseSpy.index1=index;
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
		// TODO Auto-generated method stub	
		    int  index_x=(int)(e.getX()/Interface.ab[0]+1);
		    int  index_y=(int)(e.getY()/Interface.ab[1]+1);
			int index=	(index_y*8-8+index_x)-1;
			MouseSpy.index2=index;	
			if (Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo!=null){
				    MouseSpy.x1=(int)MouseSpy.index1/8;
				    MouseSpy.y1=MouseSpy.index1%8;	
				    MouseSpy.x2=(int)MouseSpy.index2/8;
				    MouseSpy.y2=MouseSpy.index2%8;
				    
		         Pezzo MyPezzo=new Pezzo(Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo.nome ,Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo.colore);
		      
			    if (MyPezzo.nome.equals("P0B")||MyPezzo.nome.equals("P1B")||MyPezzo.nome.equals("P2B")||MyPezzo.nome.equals("P3B")||MyPezzo.nome.equals("P4B")||MyPezzo.nome.equals("P5B")||
			    	MyPezzo.nome.equals("P6B")||MyPezzo.nome.equals("P7B")||MyPezzo.nome.equals("P0N")||MyPezzo.nome.equals("P1N")||MyPezzo.nome.equals("P2N")||MyPezzo.nome.equals("P3N")||
			    	MyPezzo.nome.equals("P4N")||MyPezzo.nome.equals("P5N")||MyPezzo.nome.equals("P6N")||MyPezzo.nome.equals("P7N")){
			        Pedone p=(Pedone)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			        if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){			        
			        	boolean a = p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);
			       if(a==true) status= true;	
			        }    
			    }
			    else if (MyPezzo.nome.equals("A1B")||MyPezzo.nome.equals("A2B")||MyPezzo.nome.equals("A3N")||MyPezzo.nome.equals("A4N")){
			    	 Alfiere p=(Alfiere)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    		 boolean a = p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);	
		            if(a==true) status= true;
			    	 }
			    }
			    else if (MyPezzo.nome.equals("C1B")||MyPezzo.nome.equals("C2B")||MyPezzo.nome.equals("C3N")||MyPezzo.nome.equals("C4N")){
			    	 Cavallo p=(Cavallo)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    		 boolean a = p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);
		          if(a==true) status= true;
     
			    	 }
			    }
			    else if (MyPezzo.nome.equals("RGB")||MyPezzo.nome.equals("RGN")){
			   	  
			    	 Regina p=(Regina)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    		 boolean a =p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);	
		            if(a==true) status= true;
			    	 }
			    }
			    else  if (MyPezzo.nome.equals("ReB")||MyPezzo.nome.equals("ReN")){
			    	 Re p=(Re)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    		 boolean a = p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);
		            if(a==true) status= true;
			    	 }   
			    }
			    else if  (MyPezzo.nome.equals("T1B")||MyPezzo.nome.equals("T2B")||MyPezzo.nome.equals("T3N")||MyPezzo.nome.equals("T4N")){
			    	 Torre p=(Torre)Scacchiera.board[(int)MouseSpy.index1/8][MouseSpy.index1%8].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    		 boolean a = p.muovi((int)MouseSpy.index2/8,MouseSpy.index2%8,true,false);	
		           if(a==true) status= true;
			    	 }			    	 
			    }
			
			      Pezzo.scaccoMatto();
			    
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
}
