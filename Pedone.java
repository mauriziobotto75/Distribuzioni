import java.awt.Color;



public class Pedone extends Pezzo  {
	
 	boolean firstMove;
	public Pedone(String nome,String colore){

		super(nome,colore);
		firstMove=false;
	}
	
	public boolean  muovi(int x , int y,boolean Demo,boolean TestMatto) {
		Interface.statusLabel.removeAll();
		boolean b= this.mosse_possibili(x, y);
	     if(b){
	    	 if(Scacchiera.board[x][y].pezzo != null){
	    		 Pezzo a=Scacchiera.board[x][y].pezzo;
	    		 a.togliPezzo();
	    	 }
	    	 
	    	 
	    	this.aggiornaPezzo(x, y);
	  	if (Pezzo.sottoScacco()!=null&&!Pezzo.sottoScacco().colore.equals(this.colore)){
	    	
	    		Scacchiera.posizione.clear();  
	    		for(Casella casella : Scacchiera.posizione_backup){
	    		Scacchiera.posizione.add(casella);
	    		}
  	    	    for(int i=0;i<8;i++){
  	    	     for(int j=0;j<8;j++){
  	    	    	Scacchiera.board[i][j]=new Casella(Scacchiera.board_backup[i][j].x,Scacchiera.board_backup[i][j].y,Scacchiera.board_backup[i][j].pezzo); 
  	    	   	 }   	    	 
  	    	     }
		   
		        if (Demo==true) {IniziaBoard.sottoScaccoShowMode(Color.blue);
		        Scacchiera.stampa();
		        }
		        return false;
               
	   
	    	}
	         	else {
	         		
	         		if(TestMatto==false){
	         		  
	 			        	if( Pezzo.turno==false) Interface.statusLabel.setText("mossa per nera");
	 			        	else if( Pezzo.turno==true)  Interface.statusLabel.setText("mossa per bianco");
	 			        	        	
	 			        	 this.firstMove = true;
	         			if(Pezzo.turno==false) Pezzo.turno=true;
		         		else if(Pezzo.turno==true) Pezzo.turno=false;
	         		Scacchiera.posizione_backup.clear();	         
	         		for(Casella casella : Scacchiera.posizione){
	    	    		Scacchiera.posizione_backup.add(casella);
	    	    		}
	      	    	     for(int i=0;i<8;i++){
	      	    	      for(int j=0;j<8;j++){
	      	    	    	Scacchiera.board_backup[i][j]=new Casella(Scacchiera.board[i][j].x,Scacchiera.board[i][j].y,Scacchiera.board[i][j].pezzo); 
	      	    	     }   	    	 
	      	    	    }
	

	         		}
	         		else if(TestMatto==true){
	    	    		Scacchiera.posizione.clear();
	    	    		for(Casella casella : Scacchiera.posizione_backup){
	    	    		Scacchiera.posizione.add(casella);
	    	    		}
	      	    	    for(int i=0;i<8;i++){
	      	    	     for(int j=0;j<8;j++){
	      	    	    	Scacchiera.board[i][j]=new Casella(Scacchiera.board_backup[i][j].x,Scacchiera.board_backup[i][j].y,Scacchiera.board_backup[i][j].pezzo); 
	      	    	   	 }   	    	 
	      	    	     }
	         			
	         		}
	         		  if (Demo==true){ Scacchiera.stampa();
	      		        IniziaBoard.PutPezzi(Color.green);}
	         		    Configuration.save();
	      		        return true;  
	         	}
	      
	        }
	     
	           else    if (Demo==true)  System.out.println("Mossa Errata!");
	                  return false;
		
	}
	public boolean  mosse_possibili (int x , int y){
	
		int i = 0,j = -1 , k = -1;
		while(!(Scacchiera.posizione.get(i).pezzo.nome).equals(this.nome))
		{
			i++;
		}
		Casella c = Scacchiera.posizione.get(i);
		
		if (c.pezzo.nome.equals(this.nome))
			{
				
				 k = c.x;
				 j = c.y;
			}	
		
	if (Scacchiera.board[k][j].pezzo.colore.equals("bianco")){	
		
		
		if (Scacchiera.board[x][y].pezzo == null)
		{
			if(((j==y) && (x == k+1))||((j==y) && (x == k+2) && (this.firstMove == false)&&Scacchiera.board[k+1][j].pezzo==null)) return true;
			else return false;
		}
		else 
		{
			if (((x == k+1) && (y == j+1)) || ((x == k+1) && (y == j-1)))
					{
				
						 if(Scacchiera.board[x][y].pezzo.colore != this.colore)
						    return true;
				         else
				        	 return false;
					 }
			else 
				return false;
				
		}
}     // condizioni per il pezzo bianco 	
	
	else if (Scacchiera.board[k][j].pezzo.colore.equals("nero")){	
		if (Scacchiera.board[x][y].pezzo == null)
		{
			if(((j==y) && (x == k-1))||((j==y) && (x == k-2) && (this.firstMove == false)&&Scacchiera.board[k-1][j].pezzo==null)) return true;
			else return false;
		}
		else 
		{
			if (((x == k-1) && (y == j-1)) || ((x == k-1) && (y == j+1)))
					{
				
						 if(Scacchiera.board[x][y].pezzo.colore != this.colore)
						    return true;
				         else
				        	 return false;
					 }
			else 
				return false;
				
		}
	}
		return false ;	
	}
}
