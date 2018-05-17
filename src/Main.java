import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends Thread{

	private Socket socket;
	BufferedReader input;
	PrintWriter output;
	int playerNum;
	
	public Main(Socket s, int id) {

		this.socket = s;
		this.playerNum = id;

		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			
			
		} catch (IOException e) {
			System.out.println("Player died: " + e);
		}

	}
	
	public void run() {
		
		while(true) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(input.ready()){
					String morseMessage = input.readLine();
					Server.addChat(morseMessage, playerNum);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(!Server.isChatEmpty(playerNum)){
				output.println(Server.getChat(playerNum));
			}
			
		}
		
	}
	

}
