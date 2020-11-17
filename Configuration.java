import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Configuration {
	public static  String fileName = "file.txt";
  
	public static void load() throws IOException{ 
		Scacchiera.posizione.clear();
		Scacchiera.posizione_backup.clear();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				Scacchiera.board[i][j]=new Casella(i,j,null);
			Scacchiera.board_backup[i][j]=new Casella(i,j,null)	;
			}						
     try {
    	  String line;
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader =  new BufferedReader(fileReader); 
         
         line = bufferedReader.readLine();
         if(line.equals("true"))     Pezzo.turno=true;      
         else if(line.equals("false"))  Pezzo.turno=false;
         while((line = bufferedReader.readLine()) != null) {  
        String  Line[]=line.split(" ", 5);
        if(Line[2].charAt(0)=='P') {
        	
        	Pedone p=new Pedone(Line[2],Line[3]);
        	if(Line[4].equals(true)) p.firstMove=true;
        	else if(Line[4].equals(false))	p.firstMove=false;
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	
        }
        else if((Line[2].charAt(0)=='A')){
        	Alfiere p=new Alfiere(Line[2],Line[3]);
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	
        }
        else if((Line[2].charAt(0)=='T')){
        	Torre p=new Torre(Line[2],Line[3]);
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	
        }
        else if((Line[2].charAt(0)=='C')){
        	Cavallo p=new Cavallo(Line[2],Line[3]);
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	
        }
        else if(Line[2].equals("RGB")||Line[2].equals("RGN")){
        	Regina p=new Regina(Line[2],Line[3]);
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
              
         }    
        else if(Line[2].equals("ReB")||Line[2].equals("ReN")){
        	Re p=new Re(Line[2],Line[3]);
        	Casella c=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.posizione.add(c);
        	Scacchiera.posizione_backup.add(c);
        	Scacchiera.board[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
        	Scacchiera.board_backup[Integer.parseInt(Line[0])][Integer.parseInt(Line[1])]=new Casella(Integer.parseInt(Line[0]),Integer.parseInt(Line[1]),p);
              
         }    
         }
         
         bufferedReader.close();            
     
     }
    catch(FileNotFoundException ex) {
         System.out.println(ex);                

         System.out.println("catch 1: Impossibile trovare il file: '" + fileName + "'");                
     }
	}
	public static void save(){
		  try {
			     
	            FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            bufferedWriter.write(Pezzo.turno+"");
		        bufferedWriter.newLine();
	            for(Casella c:Scacchiera.posizione){        
	            bufferedWriter.write(c.x+" ");    
	            bufferedWriter.write(c.y+" ");
	            bufferedWriter.write(c.pezzo.nome+" ");
	            bufferedWriter.write(c.pezzo.colore+" ");
	            if(c.pezzo.nome.charAt(0)=='P')  
	            	{
	            	Pedone p=(Pedone)Scacchiera.board[c.x][c.y].pezzo;
	            	bufferedWriter.write(p.firstMove+" ");
	            	}
	            else bufferedWriter.write(null+" ");
	            bufferedWriter.newLine();           
	            }
	            bufferedWriter.flush();	            
	            // Chiudere SEMPRE il file
	            bufferedWriter.close();
	        
	        }
	        catch(IOException ex) {
	            System.out.println("Errore di scrittura del file: '" + fileName + "'");
	        }
	    }
			
}
     
 


