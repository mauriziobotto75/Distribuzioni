import java.awt.Color;



public class Alfiere extends Pezzo  {
	public Alfiere(String nome,String colore) {
		super(nome,colore);
		
	}
		
	public boolean  muovi(int x , int y,boolean Demo,boolean TestMatto) {
		Interface.statusLabel.removeAll();
		boolean b= this.mosse_possibili(x, y,TestMatto);

	     if(b){
	    	 if(Scacchiera.board[x][y].pezzo != null){
	    		 Pezzo a=Scacchiera.board[x][y].pezzo;
	    		 a.togliPezzo();
	    	 }
	    	     	 
	    	this.aggiornaPezzo(x, y);
	    if (Pezzo.sottoScacco()!=null&&!Pezzo.sottoScacco().colore.equals(this.colore)){    
	    		Scacchiera.posizione.clear();
	    		for(Casella casella : Scacchiera.posizione_backup)
	    		Scacchiera.posizione.add(casella);
	
  	   	     for(int i=0;i<8;i++){
  	   	    	 for(int j=0;j<8;j++){
  	   	    	Scacchiera.board[i][j]=new Casella(Scacchiera.board_backup[i][j].x,Scacchiera.board_backup[i][j].y,Scacchiera.board_backup[i][j].pezzo);
  	   	    	 }
  	   	     }
  	   	 if (Demo==true){
  	       Scacchiera.stampa();
	       IniziaBoard.sottoScaccoShowMode(Color.blue);}
	        return false;
	    	}
	         	else {
	         	
	         		if (TestMatto==false){
	         			if( Pezzo.turno==false) Interface.statusLabel.setText("mossa per nera");
 			        	else if( Pezzo.turno==true)  Interface.statusLabel.setText("mossa per bianco");
	         			if(Pezzo.turno==false) Pezzo.turno=true;
		         		else if(Pezzo.turno==true) Pezzo.turno=false;
	         		Scacchiera.posizione_backup.clear();
	         		for(Casella casella : Scacchiera.posizione)
	    	    		Scacchiera.posizione_backup.add(casella);
	      	   	     for(int i=0;i<8;i++){
	      	   	    	 for(int j=0;j<8;j++){
	      	        		Scacchiera.board_backup[i][j]=new Casella(Scacchiera.board[i][j].x,Scacchiera.board[i][j].y,Scacchiera.board[i][j].pezzo);
	      	   	    	 }
	      	   	     }
	 

	         		}
	         		else if(TestMatto==true){
	         			Scacchiera.posizione.clear();
	    	    		for(Casella casella : Scacchiera.posizione_backup)
	    	    		Scacchiera.posizione.add(casella);
	    	
	      	   	     for(int i=0;i<8;i++){
	      	   	    	 for(int j=0;j<8;j++){
	      	   	    	Scacchiera.board[i][j]=new Casella(Scacchiera.board_backup[i][j].x,Scacchiera.board_backup[i][j].y,Scacchiera.board_backup[i][j].pezzo);
	      	   	    	 }
	      	   	     }
	         			
	         		}
	         	 	 if (Demo==true){
	      	       Scacchiera.stampa();
					IniziaBoard.PutPezzi(Color.green);  }
	         	 	 Configuration.save();
					return true;
	      	    	     
	         	}
	    
             
	     }
	  
	     else if (Demo==true)System.out.println("Mossa Errata!");
	     return false;
		
	}
			
public boolean  mosse_possibili (int x , int y,boolean TestMatto){
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
	if (Scacchiera.board[x][y].pezzo == null)
	{	
		if( (((x-k)==(y-j)) || ((k-x)==(j-y))  || ((x-k)==(j-y)) || ((k-x)==(y-j))) && (this.strada_libera (x, y,TestMatto)) ) 
											     
			     return true;
					
		else return false;
	}
	
	else 
	{
		if( (((x-k)==(y-j)) || ((k-x)==(j-y))  || ((x-k)==(j-y)) || ((k-x)==(y-j))) && (this.strada_libera (x, y,TestMatto)))
				{
			
					 if(Scacchiera.board[x][y].pezzo.colore != this.colore)
					    return true;
			         else
			        	 return false;
				 }
		else return false;
    }
}



public boolean strada_libera (int x, int y ,boolean TestMatto){	
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
	boolean g=true;
	if (   (x>k)&&(y>j)   )		
	{ 
	   int p=k+1; 
       int z=j+1;
      
		while ((p<x)&&(z<y)) 
		{
			Pezzo v= Scacchiera.board[p][z].pezzo;
			if (v==null) {
					
			p++;
			z++;
			}			
	  	    else {
	  	    p=150;
			g=false;
			if(TestMatto==false)	{
				System.out.println("Bloccato alfiere");
				Interface.statusLabel.setText("Alfiere e bloccato");
			}
				}			
		}
		
		}
	
if (   (x<k)&&(y<j)   )
		
	{ 
	   int p=k-1; 
       int z=j-1;
      
		while ((p>x)&&(z>y)) 
		{
			Pezzo v= Scacchiera.board[p][z].pezzo;
			if (v==null) {
					
			p--;
			z--;
			}
			
	  	    else {
	  	    p=-150;
			g=false;
		if(TestMatto==false)	{
			System.out.println("Bloccato alfiere");
			Interface.statusLabel.setText("Alfiere e bloccato");
		}
				}
			
		}
		
		}
	

if (   (x>k)&&(y<j)   )

{ 
   int p=k+1; 
   int z=j-1;
  
	while ((p<x)&&(z>y)) 
	{
		Pezzo v= Scacchiera.board[p][z].pezzo;
		if (v==null) {
				
		p++;
		z--;
		}
		
  	    else {
  	    p=150;
		g=false;
		if(TestMatto==false)	{
			System.out.println("Bloccato alfiere");
			Interface.statusLabel.setText("Alfiere e bloccato");
		}
			}
		
	}
	
	}


else

{ 
   int p=k-1; 
   int z=j+1;
  
	while ((p>x)&&(z<y)) 
	{
		Pezzo v= Scacchiera.board[p][z].pezzo;
		if (v==null) {
				
		p--;
		z++;
		}
		
  	    else {
  	    p=-150;
		g=false;
		if(TestMatto==false)	{
			System.out.println("Bloccato alfiere");
			Interface.statusLabel.setText("Alfiere e bloccato");
		}
			}
		
	}
	
	}
		
	return g;
		
}

}


