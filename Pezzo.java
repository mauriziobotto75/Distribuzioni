
public class Pezzo {//creazione classe pezzo
	public
		String nome;//attributi di pezzo
		String colore;
		static int showMode;
		static Casella posizioneRe;
		static Casella posizionePezzo;
		static boolean turno=true;
	
	
		
 	public Pezzo(String nome,String colore){//costruttore di pezzo
			this.nome=nome;
			this.colore=colore;
	}
	
	public void togliPezzo() //metodo togli pezzi
	 {
		int i = 0,k = -1,j = -1;
		while(!(Scacchiera.posizione.get(i).pezzo.nome).equals(this.nome))
		{
			i++;
		}
		Casella c = Scacchiera.posizione.get(i);
		if (c.pezzo.nome.equals(this.nome))
		{			
			 k = c.x;
			 j = c.y;
			 Scacchiera.posizione.remove(c);
		  	
		}				
		
		 Scacchiera.board[k][j].pezzo = null; 		
	}
	
	public void cambiaPezzo(Pezzo nuovo)

	
	{
		int i = -1,j = -1;
		for(Casella c : Scacchiera.posizione )
		{
			
			if (c.pezzo.nome.equals(this.nome))
			{
				
				 i = c.x;
				 j = c.y;
				 Scacchiera.posizione.remove(c);
				 Scacchiera.posizione_backup=Scacchiera.posizione;
			}	
		}
		
		Scacchiera.board[i][j].pezzo = nuovo;
		Casella ca = new Casella(i,j,nuovo);
		Scacchiera.posizione.add(ca);
		Scacchiera.posizione_backup=Scacchiera.posizione;
		
	}
	public void aggiornaPezzo(int x, int y){
		int k=-1 , j=-1 , i = 0;
		
		while(!(Scacchiera.posizione.get(i).pezzo.nome).equals(this.nome))
		{
			i++;
		}
		Casella c = Scacchiera.posizione.get(i);
		if((c.pezzo.nome).equals(this.nome))
		{
			 k = c.x;
			 j = c.y;
			 Scacchiera.posizione.remove(c);
			
			 Scacchiera.board[k][j].pezzo = null; 
			 k=x;
			 j=y;
			 Scacchiera.posizione.add(new Casella(k,j,this));
			 Scacchiera.board[x][y].pezzo=this;
			
			 
			 
		}
		else System.out.println("Pezzo non trovato!");
       
		
	}
    public   static Pezzo  sottoScacco(){
	    	 for(Casella c :Scacchiera.posizione){  		 
	    /////////////////		 
	    if(c.pezzo.nome.equals("ReB")||c.pezzo.nome.equals("ReN")){
	       int i=0;   
        while(c.x+i<7 ){
        	
             if(Scacchiera.board[c.x+i+1][c.y].pezzo!=null){
        	 if((Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("T1B")||Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("T2B")
     	    		||Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("T3N")||Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("T4N"))&&
     	    		(!Scacchiera.board[c.x+i+1][c.y].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
        		 posizionePezzo=Scacchiera.board[c.x+i+1][c.y];
        		 showMode=1;
        		 return Scacchiera.board[c.x+i+1][c.y].pezzo;
     	    		}
        	 else  break;
	    }	
	         i++;
        } 
         i=0;   
        while(c.y+i<7 ){
        	
             if(Scacchiera.board[c.x][c.y+i+1].pezzo!=null){
        	 if((Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("T1B")||Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("T2B")
     	    		||Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("T3N")||Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("T4N"))&&
     	    		(!Scacchiera.board[c.x][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
        		 posizionePezzo=Scacchiera.board[c.x][c.y+i+1];
        		 showMode=2;
        		 return Scacchiera.board[c.x][c.y+i+1].pezzo; 
        	 }
         else  break;
	    }	
	         i++;
        }  
          i=0;
        while(c.y-i>0 ){     	
            if(Scacchiera.board[c.x][c.y-i-1].pezzo!=null){
       	 if((Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("T1B")||Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("T2B")
    	    		||Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("T3N")||Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("T4N"))&&
    	    		(!Scacchiera.board[c.x][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))){
       		posizioneRe=Scacchiera.board[c.x][c.y];
   		    posizionePezzo=Scacchiera.board[c.x][c.y-i-1];
       		 showMode=3;
       		 return Scacchiera.board[c.x][c.y-i-1].pezzo; 
       	 }
       	 else  break;
	    }	
	         i++;
       }    
	         
        i=0;
        while(c.x-i>0 ){
        	
            if(Scacchiera.board[c.x-i-1][c.y].pezzo!=null){
       	 if((Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("T1B")||Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("T2B")
    	    		||Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("T3N")||Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("T4N"))&&
    	    		(!Scacchiera.board[c.x-i-1][c.y].pezzo.colore.equals(c.pezzo.colore))) {
       		posizioneRe=Scacchiera.board[c.x][c.y];
   		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y];
       		 showMode=4;
       		 return Scacchiera.board[c.x-i-1][c.y].pezzo;   	
       	 }
       	else  break;
	    }	
	         i++;
       }     
       i=0;
        /////// Alfiere 
        while(c.x-i>0&&c.y-i>0 ){
        	
            if(Scacchiera.board[c.x-i-1][c.y-i-1].pezzo!=null){
       	 if((Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("A1B")||Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("A2B")
    	    		||Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("A3N")||Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("A4N"))&&
    	    		(!Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))){
       		posizioneRe=Scacchiera.board[c.x][c.y];
   		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y-i-1];
       		 showMode=5;
       		 return Scacchiera.board[c.x-i-1][c.y-i-1].pezzo;   	
       	 }
       	else  break;
	         }	
	         i++;
       }   
        i=0;
     while(c.x+i<7&&c.y+i<7 ){
        	
            if(Scacchiera.board[c.x+i+1][c.y+i+1].pezzo!=null){
       	 if((Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("A1B")||Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("A2B")
    	    		||Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("A3N")||Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("A4N"))&&
    	    		(!Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))){
       		posizioneRe=Scacchiera.board[c.x][c.y];
   		    posizionePezzo=Scacchiera.board[c.x+i+1][c.y+i+1];
       		 showMode=6;
       		 return Scacchiera.board[c.x+i+1][c.y+i+1].pezzo;   	
       	 }
       	else  break;
	         }	
	         i++;
       }   
     i=0;
	            
     while(c.x-i>0&&c.y+i<7 ){
     	
         if(Scacchiera.board[c.x-i-1][c.y+i+1].pezzo!=null){
    	 if((Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("A1B")||Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("A2B")
 	    		||Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("A3N")||Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("A4N"))&&
 	    		(!Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))) {
    			posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y+i+1];
    		 showMode=7;
    		 return Scacchiera.board[c.x-i-1][c.y+i+1].pezzo;   	
    	 }
    	else  break;
	    }	
	         i++;
    }    
     i=0;
     while(c.x+i<7&&c.y-i>0 ){
      	
         if(Scacchiera.board[c.x+i+1][c.y-i-1].pezzo!=null){
    	 if((Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("A1B")||Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("A2B")
 	    		||Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("A3N")||Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("A4N"))&&
 	    		(!Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))) {
    			posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x+i+1][c.y-i-1];
    		 showMode=8;
    		 return Scacchiera.board[c.x+i+1][c.y-i-1].pezzo;   	
    	 }
    	else  break;
	    }	
	         i++;
    }          
	      //// cavalo   
     
    
    if(c.x+2<8 && c.y-1>-1 ){
      	
         if(Scacchiera.board[c.x+2][c.y-1].pezzo!=null){
    	 if((Scacchiera.board[c.x+2][c.y-1].pezzo.nome.equals("C1B")||Scacchiera.board[c.x+2][c.y-1].pezzo.nome.equals("C2B")
 	    		||Scacchiera.board[c.x+2][c.y-1].pezzo.nome.equals("C3N")||Scacchiera.board[c.x+2][c.y-1].pezzo.nome.equals("C4N"))&&
 	    		(!Scacchiera.board[c.x+2][c.y-1].pezzo.colore.equals(c.pezzo.colore))){
    		 posizioneRe=Scacchiera.board[c.x][c.y];
    		    posizionePezzo=Scacchiera.board[c.x+2][c.y-1];
    		 showMode=9;
    		 return Scacchiera.board[c.x+2][c.y-1].pezzo;   	
    	 }
	    }	         
    } 
     
     if(c.x+2<8 && c.y+1<8 ){
       	
         if(Scacchiera.board[c.x+2][c.y+1].pezzo!=null){
    	 if((Scacchiera.board[c.x+2][c.y+1].pezzo.nome.equals("C1B")||Scacchiera.board[c.x+2][c.y+1].pezzo.nome.equals("C2B")
 	    		||Scacchiera.board[c.x+2][c.y+1].pezzo.nome.equals("C3N")||Scacchiera.board[c.x+2][c.y+1].pezzo.nome.equals("C4N"))&&
 	    		(!Scacchiera.board[c.x+2][c.y+1].pezzo.colore.equals(c.pezzo.colore))){
    		 posizioneRe=Scacchiera.board[c.x][c.y];
 		    posizionePezzo=Scacchiera.board[c.x+2][c.y+1];
    		 showMode=10;
    		 return Scacchiera.board[c.x+2][c.y+1].pezzo;   	
    	 }
	    }	         
    }       
     if(c.x-2>-1&&c.y+1<8 ){
        	
         if(Scacchiera.board[c.x-2][c.y+1].pezzo!=null){
    	 if((Scacchiera.board[c.x-2][c.y+1].pezzo.nome.equals("C1B")||Scacchiera.board[c.x-2][c.y+1].pezzo.nome.equals("C2B")
 	    		||Scacchiera.board[c.x-2][c.y+1].pezzo.nome.equals("C3N")||Scacchiera.board[c.x-2][c.y+1].pezzo.nome.equals("C4N"))&&
 	    		(!Scacchiera.board[c.x-2][c.y+1].pezzo.colore.equals(c.pezzo.colore))) {
    		 posizioneRe=Scacchiera.board[c.x][c.y];
  		    posizionePezzo=Scacchiera.board[c.x-2][c.y+1];
    		 showMode=11;
    		 return Scacchiera.board[c.x-2][c.y+1].pezzo;   	
    	 }
	    }	   
     }
         if(c.x-2>-1&&c.y-1>-1 ){
         	
             if(Scacchiera.board[c.x-2][c.y-1].pezzo!=null){
        	 if((Scacchiera.board[c.x-2][c.y-1].pezzo.nome.equals("C1B")||Scacchiera.board[c.x-2][c.y-1].pezzo.nome.equals("C2B")
     	    		||Scacchiera.board[c.x-2][c.y-1].pezzo.nome.equals("C3N")||Scacchiera.board[c.x-2][c.y-1].pezzo.nome.equals("C4N"))&&
     	    		(!Scacchiera.board[c.x-2][c.y-1].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x-2][c.y-1];
        		 showMode=12;
        		 return Scacchiera.board[c.x-2][c.y-1].pezzo;   	
        	 }
    	    }	  
         } 
         ////////////////
         if(c.x-1>-1&&c.y-2>-1 ){
          	
             if(Scacchiera.board[c.x-1][c.y-2].pezzo!=null){
        	 if((Scacchiera.board[c.x-1][c.y-2].pezzo.nome.equals("C1B")||Scacchiera.board[c.x-1][c.y-2].pezzo.nome.equals("C2B")
     	    		||Scacchiera.board[c.x-1][c.y-2].pezzo.nome.equals("C3N")||Scacchiera.board[c.x-1][c.y-2].pezzo.nome.equals("C4N"))&&
     	    		(!Scacchiera.board[c.x-1][c.y-2].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x-1][c.y-2];
        		 showMode=13;
        		 return Scacchiera.board[c.x-1][c.y-2].pezzo;   	
        	 }
    	    }	  
         } 
         if(c.x-1>-1&&c.y+2<8 ){
           	
             if(Scacchiera.board[c.x-1][c.y+2].pezzo!=null){
        	 if((Scacchiera.board[c.x-1][c.y+2].pezzo.nome.equals("C1B")||Scacchiera.board[c.x-1][c.y+2].pezzo.nome.equals("C2B")
     	    		||Scacchiera.board[c.x-1][c.y+2].pezzo.nome.equals("C3N")||Scacchiera.board[c.x-1][c.y+2].pezzo.nome.equals("C4N"))&&
     	    		(!Scacchiera.board[c.x-1][c.y+2].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x-1][c.y+2];
        		 showMode=14;
        		 return Scacchiera.board[c.x-1][c.y+2].pezzo;   	
        	 }
    	    }	
         }
             if(c.x+1<8 &&c.y+2<8 ){
                	
                 if(Scacchiera.board[c.x+1][c.y+2].pezzo!=null){
            	 if((Scacchiera.board[c.x+1][c.y+2].pezzo.nome.equals("C1B")||Scacchiera.board[c.x+1][c.y+2].pezzo.nome.equals("C2B")
         	    		||Scacchiera.board[c.x+1][c.y+2].pezzo.nome.equals("C3N")||Scacchiera.board[c.x+1][c.y+2].pezzo.nome.equals("C4N"))&&
         	    		(!Scacchiera.board[c.x+1][c.y+2].pezzo.colore.equals(c.pezzo.colore))) {
            		 posizioneRe=Scacchiera.board[c.x][c.y];
           		    posizionePezzo=Scacchiera.board[c.x+1][c.y+2];
            		 showMode=15;
            	 return Scacchiera.board[c.x+1][c.y+2].pezzo;   	
            	 }
        	    }
             }
                 if(c.x+1<8 &&c.y-2>-1 ){
                 	
                     if(Scacchiera.board[c.x+1][c.y-2].pezzo!=null){
                	 if((Scacchiera.board[c.x+1][c.y-2].pezzo.nome.equals("C1B")||Scacchiera.board[c.x+1][c.y-2].pezzo.nome.equals("C2B")
             	    		||Scacchiera.board[c.x+1][c.y-2].pezzo.nome.equals("C3N")||Scacchiera.board[c.x+1][c.y-2].pezzo.nome.equals("C4N"))&&
             	    		(!Scacchiera.board[c.x+1][c.y-2].pezzo.colore.equals(c.pezzo.colore))) {
                		 posizioneRe=Scacchiera.board[c.x][c.y];
               		    posizionePezzo=Scacchiera.board[c.x+1][c.y-2];
                		 showMode=16;
                	 return Scacchiera.board[c.x+1][c.y-2].pezzo;   	
                	 }
            	    }	  
                 }
        /// regina 
      
          i=0;   
         while(c.x+i<7 ){
         	
              if(Scacchiera.board[c.x+i+1][c.y].pezzo!=null){
         	 if((Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("RGB")||Scacchiera.board[c.x+i+1][c.y].pezzo.nome.equals("RGN"))&&
      	    		(!Scacchiera.board[c.x+i+1][c.y].pezzo.colore.equals(c.pezzo.colore))) {
        		 posizioneRe=Scacchiera.board[c.x][c.y];
        		    posizionePezzo=Scacchiera.board[c.x+i+1][c.y];
         		 showMode=17;
         		 return Scacchiera.board[c.x+i+1][c.y].pezzo;
         	 }
         	 else  break;
 	    }	
 	         i++;
         } 
          i=0;   
         while(c.y+i<7 ){
         	
              if(Scacchiera.board[c.x][c.y+i+1].pezzo!=null){
            	  if((Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x][c.y+i+1].pezzo.nome.equals("RGN"))&&
            	    		(!Scacchiera.board[c.x][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))){
            			 posizioneRe=Scacchiera.board[c.x][c.y];
             		    posizionePezzo=Scacchiera.board[c.x][c.y+i+1];
            		  showMode=18;
            		  return Scacchiera.board[c.x][c.y+i+1].pezzo; 
            	  }
          else  break;
 	    }	
 	         i++;
         }  
           i=0;
         while(c.y-i>0 ){
         	
             if(Scacchiera.board[c.x][c.y-i-1].pezzo!=null){
            	 if((Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x][c.y-i-1].pezzo.nome.equals("RGN"))&&
           	    		(!Scacchiera.board[c.x][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))) {
            		 posizioneRe=Scacchiera.board[c.x][c.y];
          		    posizionePezzo=Scacchiera.board[c.x][c.y-i-1];
            		 showMode=19;
            		 return Scacchiera.board[c.x][c.y-i-1].pezzo;
            	 }
        	 else  break;
 	    }	
 	         i++;
        }    
 	         
         i=0;
         while(c.x-i>0 ){
         	
             if(Scacchiera.board[c.x-i-1][c.y].pezzo!=null){
            	 if((Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("RGB")||Scacchiera.board[c.x-i-1][c.y].pezzo.nome.equals("RGN"))&&
           	    		(!Scacchiera.board[c.x-i-1][c.y].pezzo.colore.equals(c.pezzo.colore))) {
            		 posizioneRe=Scacchiera.board[c.x][c.y];
           		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y];
            		 showMode=20;
            		 return Scacchiera.board[c.x-i-1][c.y].pezzo;	
            	 }
        	else  break;
 	    }	
 	         i++;
        }     
         i=0;
         while(c.x-i>0&&c.y-i>0 ){
         	
             if(Scacchiera.board[c.x-i-1][c.y-i-1].pezzo!=null){
            	 if((Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.nome.equals("RGN"))&&
           	    		(!Scacchiera.board[c.x-i-1][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))) {
            		 posizioneRe=Scacchiera.board[c.x][c.y];
            		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y-i-1];
            		 showMode=21;
            		 return Scacchiera.board[c.x-i-1][c.y-i-1].pezzo;	
            	 }
        	else  break;
 	    }	
 	         i++;
        }   
         i=0;
      while(c.x+i<7&&c.y+i<7 ){
         	
             if(Scacchiera.board[c.x+i+1][c.y+i+1].pezzo!=null){
            	 if((Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.nome.equals("RGN"))&&
           	    		(!Scacchiera.board[c.x+i+1][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))) {
            		 posizioneRe=Scacchiera.board[c.x][c.y];
         		    posizionePezzo=Scacchiera.board[c.x+i+1][c.y+i+1];
            		 showMode=22;
            		 return Scacchiera.board[c.x+i+1][c.y+i+1].pezzo; 	
            	 }
        	else  break;
 	    }	
 	         i++;
        }   
      i=0;
 	            
      while(c.x-i>0&&c.y+i<7 ){
      	
          if(Scacchiera.board[c.x-i-1][c.y+i+1].pezzo!=null){
        	  if((Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.nome.equals("RGN"))&&
        	    		(!Scacchiera.board[c.x-i-1][c.y+i+1].pezzo.colore.equals(c.pezzo.colore))){
        		  posizioneRe=Scacchiera.board[c.x][c.y];
       		    posizionePezzo=Scacchiera.board[c.x-i-1][c.y+i+1];
        		  showMode=23;
        		  return Scacchiera.board[c.x-i-1][c.y+i+1].pezzo;	
        	  }
     	else  break;
 	    }	
 	         i++;
     }    
      i=0;
      while(c.x+i<7&&c.y-i>0 ){
       	
          if(Scacchiera.board[c.x+i+1][c.y-i-1].pezzo!=null){
        	  if((Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("RGB")||Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.nome.equals("RGN"))&&
        	    		(!Scacchiera.board[c.x+i+1][c.y-i-1].pezzo.colore.equals(c.pezzo.colore))) {
        		  posizioneRe=Scacchiera.board[c.x][c.y];
         		    posizionePezzo=Scacchiera.board[c.x+i+1][c.y-i-1];
        		  showMode=24;
        		  return Scacchiera.board[c.x+i+1][c.y-i-1].pezzo; 	
        	  }
     	else  break;
 	    }	
 	         i++;
     }                       
        /////////////// pedone  

     if(c.x+1<8&&c.y+1<8){
        	
           if(Scacchiera.board[c.x+1][c.y+1].pezzo!=null){
      	 if((Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P0N")||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P1N")
   	    		||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P2N")||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P3N")
   	    		||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P4N")||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P5N")
   	    		||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P6N")||Scacchiera.board[c.x+1][c.y+1].pezzo.nome.equals("P7N"))&&
   	    		(!Scacchiera.board[c.x+1][c.y+1].pezzo.colore.equals(c.pezzo.colore))){
      		 posizioneRe=Scacchiera.board[c.x][c.y];
  		    posizionePezzo=Scacchiera.board[c.x+1][c.y+1];
      		 showMode=25;
      		 return Scacchiera.board[c.x+1][c.y+1].pezzo;   	
      	 }
  	    }	         
      }
       
       if(c.x+1<8 && c.y-1>-1){  
    	   if(Scacchiera.board[c.x+1][c.y-1].pezzo!=null){
    	   if((Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P0N")||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P1N")
      	    		||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P2N")||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P3N")
      	    		||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P4N")||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P5N")
      	    		||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P6N")||Scacchiera.board[c.x+1][c.y-1].pezzo.nome.equals("P7N"))&&
      	    		(!Scacchiera.board[c.x+1][c.y-1].pezzo.colore.equals(c.pezzo.colore))) {
    			 posizioneRe=Scacchiera.board[c.x][c.y];
    	  		    posizionePezzo=Scacchiera.board[c.x+1][c.y-1];
    		   showMode=26;
    		   return Scacchiera.board[c.x+1][c.y-1].pezzo;   
    	   }
  	    }	         
       }   
       if(c.x-1>-1&&c.y+1<8 ){
    	   if(Scacchiera.board[c.x-1][c.y+1].pezzo!=null){
    	   if((Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P0B")||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P1B")
     	    		||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P2B")||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P3B")
     	    		||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P4B")||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P5B")
     	    		||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P6B")||Scacchiera.board[c.x-1][c.y+1].pezzo.nome.equals("P7B"))&&
     	    		(!Scacchiera.board[c.x-1][c.y+1].pezzo.colore.equals(c.pezzo.colore))) {
    			 posizioneRe=Scacchiera.board[c.x][c.y];
 	  		    posizionePezzo=Scacchiera.board[c.x-1][c.y+1];
    		   showMode=27;
    		   return Scacchiera.board[c.x-1][c.y+1].pezzo;  
    	   }
  	    }	   
          }
       if(c.x-1>-1&&c.y-1>-1 ){
    	   if(Scacchiera.board[c.x-1][c.y-1].pezzo!=null){
    	   if((Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P0B")||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P1B")
     	    		||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P2B")||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P3B")
     	    		||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P4B")||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P5B")
     	    		||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P6B")||Scacchiera.board[c.x-1][c.y-1].pezzo.nome.equals("P7B"))&&
     	    		(!Scacchiera.board[c.x-1][c.y-1].pezzo.colore.equals(c.pezzo.colore))){
    			 posizioneRe=Scacchiera.board[c.x][c.y];
  	  		    posizionePezzo=Scacchiera.board[c.x-1][c.y-1];
    		   showMode=28;
    		   return Scacchiera.board[c.x-1][c.y-1].pezzo;  
    	   }
  	    }	   
         
	    }   	  
      ///////////end of pedone 
	    }  
	    	 }
	    
	    	 return null ;    
  }
    public static boolean scaccoMatto(){
    	
     Scacchiera.scaccomatto.clear();
    for( Casella c: Scacchiera.posizione){
    	 Scacchiera.scaccomatto.add(c);
     }
	 for(Casella c:Scacchiera.scaccomatto){
	boolean test=false;
	char pezzo=c.pezzo.nome.charAt(0);
	String Pezzo=c.pezzo.nome.substring(0, 2);
	switch (pezzo){
	case 'P' :
		 Pedone p=(Pedone)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(p.colore.equals("bianco") && turno==false||p.colore.equals("nero") && turno==true)	test=p.muovi(i, j, false, true);
				if (test==true){
					return false;		
				}
			}
		}
		break;
	case 'A':
		Alfiere A=(Alfiere)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(A.colore.equals("bianco") && turno==false||A.colore.equals("nero") && turno==true) test=A.muovi(i, j, false, true);
				if (test==true){
					return false;		
				}
			}
		}
		break;
	case 'T':
		Torre T=(Torre)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(T.colore.equals("bianco") && turno==false||T.colore.equals("nero") && turno==true)	test=T.muovi(i, j, false, true);
				if (test==true){	
					return false;		
				}
			}
		}
		break;

	case 'C':
		Cavallo C=(Cavallo)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(C.colore.equals("bianco") && turno==false||C.colore.equals("nero") && turno==true)	test=C.muovi(i, j, false, true);
				if (test==true){
					return false;		
				}
			}
		}
		break;
	
	 }
	
	switch (Pezzo){
	case "Re" :
		 Re re=(Re)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(re.colore.equals("bianco") && turno==false||re.colore.equals("nero") && turno==true)test=re.muovi(i, j, false, true);
				if (test==true){
					return false;		
				}
			}
		}
		break;
	case "RG":
		Regina rg=(Regina)Scacchiera.board[c.x][c.y].pezzo;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(rg.colore.equals("bianco") && turno==false||rg.colore.equals("nero") && turno==true)	test=rg.muovi(i, j, false, true);
				if (test==true){
					return false;		
				}
			}
		}
		break;
	}
	  
   }
	 System.out.println("scaco matto ");
	 Interface.statusLabel.setText("Scacco matto !");
	 
	 return true;
	 
}
}