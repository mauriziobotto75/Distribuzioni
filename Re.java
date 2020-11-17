import java.awt.Color;




public class Re extends Pezzo {
	boolean firstMove;
	public Re(String nome,String colore){
		super(nome,colore);
	}

	public boolean  muovi(int x, int y,boolean Demo,boolean TestMatto ){
		Interface.statusLabel.removeAll();
		if (this.mosse_possibili(x, y))
		{
			if (Scacchiera.board[x][y].pezzo != null)
			{
				 Pezzo a=Scacchiera.board[x][y].pezzo;
				 a.togliPezzo();
			}
		        	 
			this.aggiornaPezzo(x, y);
			
	    	if (Pezzo.sottoScacco()!=null&&!Pezzo.sottoScacco().colore.equals(this.colore)){
	    		System.out.println("Il re e sotto sccaco !da posizione "+Pezzo.posizionePezzo.x+"  "+Pezzo.posizionePezzo.y);
	    	    Scacchiera.posizione.clear();
	    		for(Casella casella : Scacchiera.posizione_backup){
	    		Scacchiera.posizione.add(casella);
	    		}
  	    	    for(int i=0;i<8;i++){
  	    	   	 for(int j=0;j<8;j++){
  	    	   	Scacchiera.board[i][j]=new Casella(Scacchiera.board_backup[i][j].x,Scacchiera.board_backup[i][j].y,Scacchiera.board_backup[i][j].pezzo);
  	    	        }   	    	 
  	    	     }
  	            
  	      	if (Demo==true)   {IniziaBoard.sottoScaccoShowMode(Color.blue);
  	      Scacchiera.stampa();
  	      	}
		        return false;

	    	}
	         	else {
	         		
	         		if(TestMatto==false){
	         			if( Pezzo.turno==false) Interface.statusLabel.setText("mossa per nera");
 			        	else if( Pezzo.turno==true)  Interface.statusLabel.setText("mossa per bianco");
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
	         		if (Demo==true) {Scacchiera.stampa();
				      IniziaBoard.PutPezzi(Color.green); }
	         		   Configuration.save();
	         		  
					   return true;
	         	}
	              
		}
		else  if (Demo==true)   System.out.println("Mossa Errata!");
		return false;
	}
	 
    public boolean  mosse_possibili (int x , int y){
    	
     for(Casella c :Scacchiera.posizione){
    	 if (c.pezzo.nome.equals(this.nome)){
    	  if (Scacchiera.board[x][y].pezzo==null){
    		if((x==c.x+1&&y==c.y)||(x==c.x&&y==c.y+1)||(x==c.x-1&&y==c.y)||(x==c.x&&y==c.y-1)||(x==c.x+1&&y==c.y+1)
    				||(x==c.x-1&&y==c.y-1)||(x==c.x+1&&y==c.y-1)||(x==c.x-1&&y==c.y+1))
    			return true ;
    			else return false ;
    	  }
    	  else if(!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))
    	  {
    		  if((x==c.x+1&&y==c.y)||(x==c.x&&y==c.y+1)||(x==c.x-1&&y==c.y)||(x==c.x&&y==c.y-1)||(x==c.x+1&&y==c.y+1)
      				||(x==c.x-1&&y==c.y-1)||(x==c.x+1&&y==c.y-1)||(x==c.x-1&&y==c.y+1))
      			return true ;
      			else return false ;
    	  }
     }
		
     }
          return false ;
}
  
}
