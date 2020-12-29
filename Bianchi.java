import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Bianchi {

		final int portNumber = 81;
		
		String dato;
		
		public void connetti() throws IOException{
		System.out.println("In attesa di Nero sulla porta p.n.: " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		Socket socket = serverSocket.accept();
		OutputStream os = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		dato=br.toString();
		
		while (true) {

			
			System.out.println("Tocca a te muovere: ");

			Scanner sc=new Scanner(System.in);
			String input = sc.nextLine();
			System.out.println("Tocca Nero muovere!\n...");

			
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(input);

			String str = br.readLine();

			//pw.println("Molto bene, " + str);
			pw.close();
			socket.close();

			System.out.println("Nero dice: " + str);
		
		}
	}
}