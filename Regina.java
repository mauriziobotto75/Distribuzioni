import java.awt.Color;




public class Regina extends Pezzo {
	public Regina(String nome,String colore){
		super(nome,colore);
		
	}
	public boolean  muovi(int x, int y,boolean Demo,boolean TestMatto) {
		Interface.statusLabel.removeAll();
	     if(this.mosse_possibili (x , y, TestMatto)){
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
  	    	 
  		        if (Demo==true) {
  		        	IniziaBoard.sottoScaccoShowMode(Color.blue);
  		          Scacchiera.stampa();
  		        }
  		        return false;
  	    	     
	    	}
	    	
	         	else {
	         		
	         		
	         	if (TestMatto==false)	{
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
	      	    	 
	         	}// we are not testing scaccomatto 
	         	else if (TestMatto==true){
	         		if( Pezzo.turno==false) Interface.statusLabel.setText("mossa per nera");
			        	else if( Pezzo.turno==true)  Interface.statusLabel.setText("mossa per bianco");
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
	         	
	    if (Demo==true){   Scacchiera.stampa();
				 IniziaBoard.PutPezzi(Color.green);}
	             Configuration.save();	             
				 return true;
				 }
	        	 
	 	}
			else if (Demo==true)  System.out.println("Mossa Errata!");
	     return false;
	    	 
	}
	public boolean  mosse_possibili (int x , int y,boolean TestMatto){
	
					if(this.stradaLibera(x, y,TestMatto)) return true;
					else return false ;
	    }

     public boolean stradaLibera(int x , int y,boolean TestMatto){
    	        int i=0;
    	 for(Casella c:Scacchiera.posizione){
    		 if(c.pezzo.nome.equals(this.nome))	{
    			do{
    			 if((y==c.y)&&(x==c.x+i+1)){ if(Scacchiera.board[x][y].pezzo!=null) {
    				 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
    				 else {
    					 if(TestMatto==false)	{
    						System.out.println("Bloccato Regina");
    						Interface.statusLabel.setText("Regina  e bloccato");
    					}
    					 return false;
    					 
    				 }
    				 }
    			     else return true;
    			 }
    			    if(c.x+i>6)break;
    			 i++;
    			 }while(Scacchiera.board[c.x+i][c.y].pezzo==null);		
    			i=0;
    			 do{
        		 if((x==c.x)&&(y==c.y+i+1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
        			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
    				 else {
    					 if(TestMatto==false)	{
     						System.out.println("Bloccato Regina");
     						Interface.statusLabel.setText("Regina  e bloccato");
     					}
    					 return false;
    				 }
    				 }
        		     else return true ;
        		 }
        			 if(c.y+i>6)break;
        			 i++;
        			 }while(Scacchiera.board[c.x][c.y+i].pezzo==null);	
    			 i=0;
     			 do{
         		 if((x==c.x+i+1)&&(y==c.y+i+1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
         			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
     				 else return false;}
         		     else return true ;
         		 }
         			 if(c.x+i>6||c.y+i>6)break;
         			 i++;
         			 }while(Scacchiera.board[c.x+i][c.y+i].pezzo==null);			 
     			 i=0;
     			 do{
          		 if((x==c.x-i-1)&&(y==c.y-i-1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
          			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
      				 else {
      					if(TestMatto==false)	{
    						System.out.println("Bloccato Regina");
    						Interface.statusLabel.setText("Regina  e bloccato");
    					}
      					 return false;
      				 }
      				 }
          		     else return true ;
          		 }
          			 if(c.x-i<1||c.y-i<1)break;
          			 i++;
          			 }while(Scacchiera.board[c.x-i][c.y-i].pezzo==null);	
      			 i=0;
       			 do{
           		 if((x==c.x-i-1)&&(y==c.y)){ if(Scacchiera.board[x][y].pezzo!=null) { 
           			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
       				 else{ 
       					if(TestMatto==false)	{
    						System.out.println("Bloccato Regina");
    						Interface.statusLabel.setText("Regina  e bloccato");
    					}
       					 return false;
       				 }
       				 }
           		     else return true ;
           		 }
           			 if(c.x-i<1)break;
           			 i++;
           			 }while(Scacchiera.board[c.x-i][c.y].pezzo==null);	
       			 i=0;
        			 do{
            		 if((x==c.x)&&(y==c.y-i-1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
            			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
        				 else {
        					 if(TestMatto==false)	{
         						System.out.println("Bloccato Regina");
         						Interface.statusLabel.setText("Regina  e bloccato");
         					}
        					 return false;
        				 }
        				 }
            		     else return true ;
            		 }
            			 if(c.y-i<1)break;
            			 i++;
            			 }while(Scacchiera.board[c.x][c.y-i].pezzo==null);	
        			 i=0;
         			 do{
             		 if((x==c.x+i+1)&&(y==c.y-i-1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
             			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
         				 else {
         					if(TestMatto==false)	{
        						System.out.println("Bloccato Regina");
        						Interface.statusLabel.setText("Regina  e bloccato");
        					}
         					 return false;
         				 }
         				 }
             		     else return true ;
             		 }
             			 if(c.y-i<1||c.x+i>6)break;
             			 i++;
             			 }while(Scacchiera.board[c.x+i][c.y-i].pezzo==null);	
         			i=0;
        			 do{
            		 if((x==c.x-i-1)&&(y==c.y+i+1)){ if(Scacchiera.board[x][y].pezzo!=null) { 
            			 if (!Scacchiera.board[x][y].pezzo.colore.equals(this.colore))return true;
        				 else{ 
        					 if(TestMatto==false)	{
         						System.out.println("Bloccato Regina");
         						Interface.statusLabel.setText("Regina  e bloccato");
         					}
        					 return false;
        				 }
        				 }
            		     else return true ;
            		 }
            			 if(c.x-i<1||c.y+i>6)break;
            			 i++;
            			 }while(Scacchiera.board[c.x-i][c.y+i].pezzo==null);	 
    		 }
    		 
    	 }
    	 
    	 return false ;
     }
           
}