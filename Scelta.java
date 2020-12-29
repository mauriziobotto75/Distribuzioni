import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Scelta {
	
	static String host=null;

	
	public static void main(String args[]) throws IOException {
		
		Scanner a= new Scanner(System.in);
		InetAddress ia = InetAddress.getLocalHost();
		ia.getHostAddress();
		System.out.print("\t\tGIOCO DEGLI SCACCHI\n\n"+ia+"\nVuoi i bianchi o i neri?");
		
		String c = a.next();
		
		
		if(c.equalsIgnoreCase("neri")){
			try {
				System.out.println("inserire l'ip dell'avversario: ");
				host=a.next();

				Neri n = new Neri();
				n.connetti(host);
			}
			catch (IOException ex) {
				System.out.print(ex + "\nerrore 1");
				Neri n = new Neri();
				n.connetti(host);
				
			}
			
			
			
		}
		else if ( c.equalsIgnoreCase("bianchi")){
			Bianchi b = new Bianchi();
			try {
				b.connetti();
			}
			catch (IOException ex) {
				System.out.print(ex + "\nerrore 2");
				b.connetti();

				}
			
		}
		
		
		
		
	}

}
