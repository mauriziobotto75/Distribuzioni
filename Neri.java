import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Neri {

	public void connetti(final String host) throws UnknownHostException, IOException{
		//final String host = "192.168.5.37";							//indirizzo del pc al quale mi devo collegare!!!
		final int portNumber = 81;
		Socket socket;
		String input;
		System.out.println("Mi collego a Bianco! p.n.: " + portNumber);
		System.out.println("Tocca a Bianco!\n...");
		while (true) {
			socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			input = br.readLine();
			
			System.out.println("Bianco dice:" + input);
			System.out.println("Tocca a te muovere: ");

			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			out.println(userInput);
			System.out.println("Tocca a Bianco muovere!\n...");


			//System.out.println("risposta del server:" + br.readLine());192.168.5.12

			/*if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}*/
		}
	}
}