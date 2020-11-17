import java.io.*;
import java.net.*;

public class Client {
	Socket mioSocket=null;
	int porta=6789;
	DataInputStream in;
	DataOutputStream out;
	BufferedReader tastiera ;
	public void Comunica(){
		try {    
		/*	tastiera=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("(2) -messaggio da inviare al server  ");
			String messaggio =tastiera.readLine();
			System.out.print("(3) -invio  "+messaggio );
			out.writeBytes(messaggio+"\n");
			System.out.print("(4) - In attesa di una riposta .... ");
			String ricevuta = in.readLine();
			System.out.print("(5) - risposta del server : " + ricevuta);*/
		//	out.writeBytes("hi i am client and ready  "+"\n");
			String ricevuta = in.readLine();
			System.out.println(ricevuta );
			String []ramin=ricevuta.split(" ");
			MouseSpy.x1=Integer.parseInt(ramin[0]);
			MouseSpy.y1=Integer.parseInt(ramin[1]);
			MouseSpy.x2=Integer.parseInt(ramin[2]);
			MouseSpy.y2=Integer.parseInt(ramin[3]);
		
		   /////////////
		   Pezzo MyPezzo=new Pezzo(Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo.nome ,Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo.colore);		      
			    if (MyPezzo.nome.equals("P0B")||MyPezzo.nome.equals("P1B")||MyPezzo.nome.equals("P2B")||MyPezzo.nome.equals("P3B")||MyPezzo.nome.equals("P4B")||MyPezzo.nome.equals("P5B")||
			    	MyPezzo.nome.equals("P6B")||MyPezzo.nome.equals("P7B")||MyPezzo.nome.equals("P0N")||MyPezzo.nome.equals("P1N")||MyPezzo.nome.equals("P2N")||MyPezzo.nome.equals("P3N")||
			    	MyPezzo.nome.equals("P4N")||MyPezzo.nome.equals("P5N")||MyPezzo.nome.equals("P6N")||MyPezzo.nome.equals("P7N")){
			        Pedone p=(Pedone)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			        if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){			        
			        p.muovi(MouseSpy.x2,MouseSpy.y2,true,false);
			        }    
			    }
			    else if (MyPezzo.nome.equals("A1B")||MyPezzo.nome.equals("A2B")||MyPezzo.nome.equals("A3N")||MyPezzo.nome.equals("A4N")){
			    	 Alfiere p=(Alfiere)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
			    	 p.muovi(	MouseSpy.x2,MouseSpy.y2,true,false);	
			    	
			    	 }
			    }
			    else if (MyPezzo.nome.equals("C1B")||MyPezzo.nome.equals("C2B")||MyPezzo.nome.equals("C3N")||MyPezzo.nome.equals("C4N")){
			    	 Cavallo p=(Cavallo)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
		             p.muovi(	MouseSpy.x2,MouseSpy.y2,true,false);
		      
			    	 }
			    }
			    else if (MyPezzo.nome.equals("RGB")||MyPezzo.nome.equals("RGN")){
			    	 Regina p=(Regina)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
		             p.muovi(	MouseSpy.x2,MouseSpy.y2,true,false);	
			    	 }
			    }
			    else  if (MyPezzo.nome.equals("ReB")||MyPezzo.nome.equals("ReN")){
			    	 Re p=(Re)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
		           p.muovi(	MouseSpy.x2,MouseSpy.y2,true,false);

			    	 }   
			    }
			    else if  (MyPezzo.nome.equals("T1B")||MyPezzo.nome.equals("T2B")||MyPezzo.nome.equals("T3N")||MyPezzo.nome.equals("T4N")){
			    	 Torre p=(Torre)Scacchiera.board[MouseSpy.x1][MouseSpy.y1].pezzo;
			    	 if(p.colore.equals("bianco") && Pezzo.turno==false||p.colore.equals("nero") && Pezzo.turno==true){
		         p.muovi(	MouseSpy.x2,MouseSpy.y2,true,false);
			    	 }			    	 
			    }
			      Pezzo.scaccoMatto();
			////////////////
			      
	
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	

		do{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(MouseSpy.status==true){
			try {
				out.writeBytes(MouseSpy.x1+" "+MouseSpy.y1+" "+MouseSpy.x2+" "+MouseSpy.y2+"\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MouseSpy.status=false;
		   
			break;
			}
		}while(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
	
	public Socket connetti(){
		try {
			System.out.println("(0) provo a connetermi a server ");
			Socket mioSocket=new Socket(InetAddress.getLocalHost(),porta);
			System.out.println("(1) connesso ");
			in=new DataInputStream(mioSocket.getInputStream());
			out=new DataOutputStream(mioSocket.getOutputStream());
		} catch (UnknownHostException e) {
			System.err.println("Host sconoscutto ");
		
		} catch (IOException e) {
	
			System.err.println("Impossiblile stabile la conessione ");
		}
		
		return mioSocket;
		
	}
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c=new Client();
	while (true){
		c.connetti();
		c.Comunica();
	}
	}*/

}
